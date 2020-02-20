package com.mybatis.boot.config;

import com.mybatis.boot.model.User;
import com.mybatis.boot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author LX
 * @Date 2020/2/20 16:04
 * @Description 拦截器校验用户是否登录
 */
@Component
public class LoginHandler extends HandlerInterceptorAdapter {
    @Autowired
    RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        User user = redisService.getUserByToken(request);
        if (user != null) {
            return true;
        }
        String url = request.getContextPath() + "/login";
        response.sendRedirect(url);
        return false;
    }
}
