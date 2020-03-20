package com.mybatis.boot.service.impl;

import com.mybatis.boot.model.User;
import com.mybatis.boot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2020/2/20 17:24
 * @Description
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 根据cookie中的token获取redis中存储的user
     *
     * @param request
     * @return
     */
    @Override
    public User getUserByToken(HttpServletRequest request) {
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            Cookie[] cookies = request.getCookies();
            if(cookies!=null){
                for (Cookie cookie : cookies) {
                    if ("token".equals(cookie.getName())) {
                        token = cookie.getValue();
                    }
                }
            }
        }
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        User user = (User) redisTemplate.opsForValue().get("token::" + token);
        if (user == null) {
            return null;
        }
        redisTemplate.expire("token::" + token, 30, TimeUnit.MINUTES);
        return user;
    }
}
