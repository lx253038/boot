package com.mybatis.boot.redisson;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author LX
 * @Date 2020/6/3 21:21
 * @Description
 */
@RestController
public class RedissonController {

    @Autowired
    private Executor pool;

    @Autowired
    private RedLockService redLockService;


    private int number = 0;


    @GetMapping("/lock")
    public String testLock() {
        Runnable runnable = () -> {
            redLockService.lock("mylock");
            try {
                number++;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                redLockService.unLock("mylock");
            }
        };
        for (int i = 0; i < 1000; i++) {

            pool.execute(runnable);
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(number);
        number=0;
        return "number:" + number;
    }

}
