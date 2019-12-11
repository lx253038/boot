package com.mybatis.boot;

import com.mybatis.boot.asyn.AsyncService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootApplicationTests {

    @Test
    void contextLoads() {

    }

    @Autowired
    AsyncService asyncService;
    @Test
    void test1(){
        for (int i = 0; i <10 ; i++) {
            asyncService.executeAsync();

        }
    }
}
