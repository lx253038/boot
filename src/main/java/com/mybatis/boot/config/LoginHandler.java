package com.mybatis.boot.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mybatis.boot.model.User;
import com.mybatis.boot.service.RedisService;

/**
 * @Author LX
 * @Date 2020/2/20 16:04
 * @Description ������У���û��Ƿ��¼
 */
@Component
public class LoginHandler extends HandlerInterceptorAdapter {
    @Autowired
    RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //�ֶ�����cookieʵ��
        // User user = redisService.getUserByToken(request);
        //ʹ��springSession �ֲ�ʽsessionʵ��
        User user = redisService.getUserBySession(request);
        if (user != null) {
            return true;
        }
        String url = request.getContextPath() + "/login";
        response.sendRedirect(url);
        return false;
    }
}
