package com.mybatis.boot.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;

/**
 * @Author LX
 * @Date 2019/12/13 16:17
 * @Description TODO
 */
@Configuration
@Slf4j
public class RabbitMqConfig {

    @Autowired
    ExchangeAndQueue exchangeAndQueue;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Bean
    public MessageConverter messageConverter() {
        //消息转换器（序列化器）
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        //*若使用confirm-callback或return-callback，
        //*必须要配置publisherConfirms或publisherReturns为true
        //*每个rabbitTemplate只能有一个confirm-callback和return-callback
        template.setConfirmCallback((correlationData, b, s) -> {
            log.info("=========================消息发送确认=========================");
            log.info("MsgSendConfirmCallBack  , 回调id:" + correlationData);
            if (b) {
                log.info("消息生产成功");
            } else {
                log.error("消息生产失败:" + s + "重新发送");
            }
            log.info("=============================================================");

        });

        /**
         * 使用return-callback时必须设置mandatory为true，或者在配置中设置mandatory-expression的值为true，
         * 可针对每次请求的消息去确定’mandatory’的boolean值，
         * 只能在提供’return -callback’时使用，与mandatory互斥
         */
        template.setReturnCallback((message, i, s, s1, s2) -> {
            String msg = "";
            try {
                msg = new String(message.getBody(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            log.info("============================没有队列接收消息==============================");
            log.info("消息内容:{}, 交换机:{}, 路由键:{}:, 失败原因:{}", msg, s1, s2, s);
        });
        template.setMandatory(true);
        template.setMessageConverter(this.messageConverter());
        return template;
    }


}
