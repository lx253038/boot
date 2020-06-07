package com.mybatis.boot.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.mybatis.boot.model.User;
import com.mybatis.boot.service.RedisService;

/**
 * @Author LX
 * @Date 2020/2/20 15:31
 * @Description ����������
 */
@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    RedisService redisService;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return User.class == methodParameter.getParameterType();
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        //�ֶ�����cookie��ʽʵ��
        User tokenUser = redisService.getUserByToken(request);
        //ʹ��springSession �ֲ�ʽsessionʵ��
        Object sessionUser = redisTemplate.opsForValue().get("session::" + request.getSession().getId());
        return tokenUser == null ? sessionUser : tokenUser;
    }
}
