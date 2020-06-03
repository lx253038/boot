package com.mybatis.boot.redisson;

/**
 * @Author LX
 * @Date 2020/6/3 21:13
 * @Description
 */
public interface RedLockService {
    /**
     * ������,�����ֶ�����!�̲߳���������������Զ����! ����
     */
    void lock(String lockKey);

    /**
     * ������,�����ֶ�������ȴ�leaseTime��ʱ
     */
    void lock(String lockKey, long leaseTime);


    boolean tryLockTimeout(String lockKey, long waitTime, long leaseTime) throws InterruptedException;


    void unLock(String lockKey);

}
