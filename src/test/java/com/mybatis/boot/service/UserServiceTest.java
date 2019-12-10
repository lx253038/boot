package com.mybatis.boot.service;

import com.mybatis.boot.mapper.UserMapper;
import com.mybatis.boot.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

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

    @Autowired
    UserMapper userMapper;

    @Test
    public void test1() {

        Set<String> keys = redisTemplate.keys("*:com.mybatis.boot.dao.UserMapper*");
        if (!CollectionUtils.isEmpty(keys)) {
            boolean number = redisTemplate.delete(keys.toArray()[0]);
            System.out.println(number);
        }
    }

    @Test
    public void test2() {

        System.out.println(userMapper.selectByPrimaryKey(66));
        System.out.println(userMapper.selectById(66));
        userMapper.insert(new User("546456", 34));

    }
    @Test
    void test3(){
        System.out.println(userService.list());
    }

}