package com.mybatis.boot.mapper;

import com.mybatis.boot.model.User;
import com.mybatis.boot.model.UserExample;
import com.wf.captcha.ChineseCaptcha;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Random;
import java.util.Set;

/**
 * @Author LX
 * @Date 2019/12/3 15:08
 * @Description TODO
 */
@SpringBootTest
class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    UserExample userExample = new UserExample();

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void countByExample() {
        long l = userMapper.countByExample(userExample);
        redisTemplate.opsForValue().set("user::count", l);
        System.out.println(l);
    }

    @Test
    void deleteByExample() {

        UserExample.Criteria criteria1 = userExample.createCriteria();

        userExample.createCriteria().andIdEqualTo(1);
        userExample.createCriteria().andAgeEqualTo(33);

        criteria1.andIdEqualTo(2);

        userExample.or(criteria1);

        System.out.println(userExample.getOredCriteria());

        System.out.println(userMapper.deleteByExample(userExample));

    }

    @Test
    void deleteByPrimaryKey() {
    }

    @Test
    void insert() {

        for (int i = 0; i < 100; i++) {
            ChineseCaptcha chineseCaptcha = new ChineseCaptcha();

            userMapper.insert(new User(chineseCaptcha.text(), new Random().nextInt(100) + 1));

        }

    }

    @Test
    void insertSelective() {
    }

    @Test
    void selectByExample() {

    }

    @Test
    void selectByPrimaryKey() {

        User user = userMapper.selectByPrimaryKey(21);
        redisTemplate.opsForValue().set("user::" + user.getId(), user);
        System.out.println(user);
    }

    @Test
    void updateByExampleSelective() {
    }

    @Test
    void updateByExample() {
    }

    @Test
    void updateByPrimaryKeySelective() {
    }

    @Test
    void updateByPrimaryKey() {
    }

    @Test
    void redisTest(){
        Set keys = redisTemplate.keys("user::*");
        System.out.println(keys);
    }
}