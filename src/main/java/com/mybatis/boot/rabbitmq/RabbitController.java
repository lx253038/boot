package com.mybatis.boot.rabbitmq;

import com.mybatis.boot.annotation.SysLog;
import com.mybatis.boot.model.User;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

/**
 * @Author LX
 * @Date 2019/12/13 16:08
 * @Description TODO
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 测试直连
     *
     * @param message
     * @return
     */
    @SysLog("生产消息")
    @GetMapping("/send/{message}")
    public String sendMessage(@PathVariable String message) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(ExchangeAndQueue.DIRECT_EXCHANGE, "directUser", new User(message, new Random().nextInt(100)), correlationId);
        return "发送成功！";
    }

    /**
     * 测试扇形
     *
     * @param message
     * @return
     */
    @GetMapping("/send2/{message}")
    public String send2(@PathVariable String message) {
        rabbitTemplate.convertAndSend(ExchangeAndQueue.FANOUT_EXCHANGE, "1111", message);
        return "发送成功！";
    }

    /**
     * 测试主题
     *
     * @param message
     * @param key
     * @return
     */
    @GetMapping("/send3/{message}/{key}")
    public String send2(@PathVariable String message, @PathVariable String key) {
        rabbitTemplate.convertAndSend(ExchangeAndQueue.TOPIC_EXCHANGE, key, message);
        return "发送成功！";
    }


}
