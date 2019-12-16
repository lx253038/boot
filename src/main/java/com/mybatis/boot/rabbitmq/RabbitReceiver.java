package com.mybatis.boot.rabbitmq;

import com.mybatis.boot.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author LX
 * @Date 2019/12/13 16:24
 * @Description TODO
 */
@Component
public class RabbitReceiver {

    @RabbitListener(queues = {"queue1"})
    public void getMsg1(User user) {
        System.out.println(user);
    }

    @RabbitListener(queues = "queue2")
    public void getMsgStr2(String msg) {
        System.out.println("队列2：" + msg);
    }

    @RabbitListener(queues = {"queue3"})
    public void getMsgStr3(String msg) {
        System.out.println("队列3：" + msg);
    }

    @RabbitListener(queues = {"queue4"})
    public void getMsgStr4(String msg) {
        System.out.println("队列4：" + msg);
    }

    @RabbitListener(queues = {"queue5"})
    public void getMsgStr5(String msg) {
        System.out.println("队列5：" + msg);
    }


}
