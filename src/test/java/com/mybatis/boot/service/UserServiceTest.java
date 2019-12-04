package com.mybatis.boot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Set;

/**
 * @Author LX
 * @Date 2019/12/3 15:06
 * @Description TODO
 */
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test1() {

        Set<String> keys = redisTemplate.keys("*:com.mybatis.boot.dao.UserMapper*");
        if (!CollectionUtils.isEmpty(keys)) {
            boolean number = redisTemplate.delete(keys.toArray()[0]);
            System.out.println(number);
        }
    }

}