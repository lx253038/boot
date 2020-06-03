package com.mybatis.boot.redisson;

/**
 * @Author LX
 * @Date 2020/6/3 21:13
 * @Description
 */
public interface RedLockService {
    /**
     * 可重入,必须手动解锁!线程不主动解锁将会永远存在! 慎用
     */
    void lock(String lockKey);

    /**
     * 可重入,必须手动解锁或等待leaseTime超时
     */
    void lock(String lockKey, long leaseTime);


    boolean tryLockTimeout(String lockKey, long waitTime, long leaseTime) throws InterruptedException;


    void unLock(String lockKey);

}
