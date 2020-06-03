package com.mybatis.boot.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author LX
 * @Date 2020/6/3 20:58
 * @Description RedLock, redis分布式锁相关配置
 */
@Configuration
public class RedissonSpringDataConfig {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;


    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() {
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://" + host + ":" + port);

        System.out.println("------------- redisson -----------------------");
        System.out.println(config.getTransportMode());
        return Redisson.create(config);
    }

}
