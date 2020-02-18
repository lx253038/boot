package com.mybatis.boot;

import com.mybatis.boot.asyn.AsyncService;
import com.mybatis.boot.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class BootApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;
    @Test
    void contextLoads() {

    }

    @Test
    void test1(){
        redisTemplate.opsForValue().set("user1",new User("ÕÅÈý",20),20,TimeUnit.MINUTES);
    }
    @Test
    void test2(){
        System.out.println(redisTemplate.opsForValue().get("user1"));
    }
}
