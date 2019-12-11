package com.mybatis.boot.asyn;

/**
 * @Author LX
 * @Date 2019/12/10 18:06
 * @Description 创建异步线程接口
 */
public interface AsyncService {
    /**
     * 执行异步任务
     */
    void executeAsync();

}
