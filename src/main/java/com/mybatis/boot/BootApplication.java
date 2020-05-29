package com.mybatis.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync
@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
@MapperScan("com.mybatis.boot.**.mapper")
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
        //�ر�Banner
//        SpringApplication app=new SpringApplication(BootApplication.class);
//        app.setBannerMode(Mode.OFF);
//        app.run(args);
    }

}
