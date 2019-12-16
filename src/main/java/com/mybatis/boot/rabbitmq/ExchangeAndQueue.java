package com.mybatis.boot.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author LX
 * @Date 2019/12/13 15:34
 * @Description 三种类型的交换机
 */
@Configuration
public class ExchangeAndQueue {

    private final AmqpAdmin amqpAdmin;

    public static final String DIRECT_EXCHANGE = "directExchange"; //直连交换机

    public static final String FANOUT_EXCHANGE = "fanoutExchange"; //扇形交换机

    public static final String TOPIC_EXCHANGE = "topicExchange"; //主题交换机


    private static final String QUEUE_ONE = "queue1";   //队列1
    private static final String QUEUE_TWO = "queue2";   //队列2
    private static final String QUEUE_THREE = "queue3"; //队列3
    private static final String QUEUE_FOUR = "queue4";  //队列4
    private static final String QUEUE_FIVE = "queue5";  //队列5

    public ExchangeAndQueue(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    /**
     * 直连交换机（只对路由键绑定的队列发送消息）
     *
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE, true, false);
    }

    /**
     * 扇形交换机（所有绑定的队列发送消息）
     *
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE, true, false);
    }


    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE, true, false);
    }


    /**
     * 队列1
     *
     * @return
     */
    @Bean
    public static Queue queue1() {
        return new Queue(QUEUE_ONE, true, false, false);
    }

    /**
     * 队列2
     *
     * @return
     */
    @Bean
    public Queue queue2() {
        return new Queue(QUEUE_TWO, true, false, false);
    }

    /**
     * 队列3
     *
     * @return
     */
    @Bean
    public Queue queue3() {
        return new Queue(QUEUE_THREE, true, false, false);
    }

    /**
     * 队列4
     *
     * @return
     */
    @Bean
    public Queue queue4() {
        return new Queue(QUEUE_FOUR, true, false, false);
    }

    /**
     * 队列5
     *
     * @return
     */
    @Bean
    public Queue queue5() {
        return new Queue(QUEUE_FIVE, true, false, false);
    }

    /**
     * 直连交换机绑定队列1使用routingKey=directUser
     *
     * @return
     */
    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(directExchange()).with("directUser");
    }

    /**
     * 使用amqpAdmin创建绑定关系
     */
    @Bean
    public void bindAll() {
        //扇形交换机绑定不需要路由键
        amqpAdmin.declareBinding(new Binding(QUEUE_TWO, Binding.DestinationType.QUEUE, FANOUT_EXCHANGE, "", null));  //扇形交换机和队列2绑定
        amqpAdmin.declareBinding(new Binding(QUEUE_THREE, Binding.DestinationType.QUEUE, FANOUT_EXCHANGE, "", null));  //扇形交换机和队列3绑定
        amqpAdmin.declareBinding(new Binding(QUEUE_FOUR, Binding.DestinationType.QUEUE, FANOUT_EXCHANGE, "", null));  //扇形交换机和队列4绑定

        //主题交换机绑定根据路由键去匹配
        /*  amqpAdmin.declareBinding(new Binding(QUEUE_ONE, Binding.DestinationType.QUEUE, TOPIC_EXCHANGE, "top.*", null)); //主题交换机使用路由键 top.*和队列一绑定*/
        amqpAdmin.declareBinding(new Binding(QUEUE_TWO, Binding.DestinationType.QUEUE, TOPIC_EXCHANGE, "top.#", null)); //主题交换机使用路由键 top.*和队列二绑定
        amqpAdmin.declareBinding(new Binding(QUEUE_THREE, Binding.DestinationType.QUEUE, TOPIC_EXCHANGE, "*.user", null)); //主题交换机使用路由键 *.user和队列三绑定

        amqpAdmin.declareBinding(new Binding(QUEUE_FOUR, Binding.DestinationType.QUEUE, TOPIC_EXCHANGE, "top.user.*", null)); //主题交换机使用路由键 top.user.*和队列四绑定
        amqpAdmin.declareBinding(new Binding(QUEUE_FIVE, Binding.DestinationType.QUEUE, TOPIC_EXCHANGE, "top.user.#", null)); //主题交换机使用路由键 top.user.#和队列五绑定


    }

}
