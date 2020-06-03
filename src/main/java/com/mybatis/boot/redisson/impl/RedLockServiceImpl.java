package com.mybatis.boot.redisson.impl;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.boot.redisson.RedLockService;

/**
 * @Author LX
 * @Date 2020/6/3 21:09
 * @Description �ֲ�ʽ����ط���
 */
@Service
public class RedLockServiceImpl implements RedLockService {

    @Autowired
    private RedissonClient redissonClient;

    /**
     * ������,!�̲߳���������������Զ����! ����
     */
    @Override
    public void lock(String lockKey) {
        RLock rLock = redissonClient.getLock(lockKey);
        redissonClient.getRedLock(rLock).lock();
    }

    @Override
    public void lock(String lockKey, long leaseTime) {
        RLock rLock = redissonClient.getLock(lockKey);
        redissonClient.getRedLock(rLock).lock(leaseTime, TimeUnit.MILLISECONDS);
    }


    @Override
    public boolean tryLockTimeout(String lockKey, long waitTime, long leaseTime) throws InterruptedException {
        RLock rLock = redissonClient.getLock(lockKey);
        return redissonClient.getRedLock(rLock).tryLock(waitTime, leaseTime, TimeUnit.MILLISECONDS);
    }


    @Override
    public void unLock(String lockKey) {
        RLock rLock = redissonClient.getLock(lockKey);
        redissonClient.getRedLock(rLock).unlock();
    }


}
