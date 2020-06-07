package com.mybatis.boot.service;

import com.mybatis.boot.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author LX
 * @Date 2020/2/20 17:24
 * @Description
 */
public interface RedisService {

    User getUserByToken(HttpServletRequest request);

    User getUserBySession(HttpServletRequest request);

}
