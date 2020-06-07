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
 * @Description 参数解析器
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
        //手动设置cookie方式实现
        User tokenUser = redisService.getUserByToken(request);
        //使用springSession 分布式session实现
        Object sessionUser = redisTemplate.opsForValue().get("session::" + request.getSession().getId());
        return tokenUser == null ? sessionUser : tokenUser;
    }
}
