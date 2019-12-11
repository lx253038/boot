package com.mybatis.boot.asyn.impl;

import com.mybatis.boot.asyn.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2019/12/10 18:07
 * @Description 异步线程接口实现类
 */
@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {
    @Override
    @Async
    public void executeAsync() {
        log.info("start executeAsync");
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("end executeAsync");
    }
}
