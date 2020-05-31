package com.mybatis.boot.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author LX
 * @Date 2019/12/13 15:34
 * @Description �������͵Ľ�����
 */
@Configuration
public class ExchangeAndQueue {

    private final AmqpAdmin amqpAdmin;

    public static final String DIRECT_EXCHANGE = "directExchange"; //ֱ��������

    public static final String FANOUT_EXCHANGE = "fanoutExchange"; //���ν�����

    public static final String TOPIC_EXCHANGE = "topicExchange"; //���⽻����


    private static final String QUEUE_ONE = "queue1";   //����1
    private static final String QUEUE_TWO = "queue2";   //����2
    private static final String QUEUE_THREE = "queue3"; //����3
    private static final String QUEUE_FOUR = "queue4";  //����4
    private static final String QUEUE_FIVE = "queue5";  //����5

    public ExchangeAndQueue(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    /**
     * ֱ����������ֻ��·�ɼ��󶨵Ķ��з�����Ϣ��
     *
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE, true, false);
    }

    /**
     * ���ν����������а󶨵Ķ��з�����Ϣ��
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
     * ����1
     *
     * @return
     */
    @Bean
    public static Queue queue1() {
        return new Queue(QUEUE_ONE, true, false, false);
    }

    /**
     * ����2
     *
     * @return
     */
    @Bean
    public Queue queue2() {
        return new Queue(QUEUE_TWO, true, false, false);
    }

    /**
     * ����3
     *
     * @return
     */
    @Bean
    public Queue queue3() {
        return new Queue(QUEUE_THREE, true, false, false);
    }

    /**
     * ����4
     *
     * @return
     */
    @Bean
    public Queue queue4() {
        return new Queue(QUEUE_FOUR, true, false, false);
    }

    /**
     * ����5
     *
     * @return
     */
    @Bean
    public Queue queue5() {
        return new Queue(QUEUE_FIVE, true, false, false);
    }

    /**
     * ֱ���������󶨶���1ʹ��routingKey=directUser
     *
     * @return
     */
    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(directExchange()).with("directUser");
    }

    /**
     * ʹ��amqpAdmin�����󶨹�ϵ
     */
    @Bean
    public void bindAll() {

        //ֱ��������
        amqpAdmin.declareBinding(new Binding(QUEUE_TWO,Binding.DestinationType.QUEUE,DIRECT_EXCHANGE,"createOrder",null));

        //���ν������󶨲���Ҫ·�ɼ�
        amqpAdmin.declareBinding(new Binding(QUEUE_TWO, Binding.DestinationType.QUEUE, FANOUT_EXCHANGE, "", null));  //���ν������Ͷ���2��
        amqpAdmin.declareBinding(new Binding(QUEUE_THREE, Binding.DestinationType.QUEUE, FANOUT_EXCHANGE, "", null));  //���ν������Ͷ���3��
        amqpAdmin.declareBinding(new Binding(QUEUE_FOUR, Binding.DestinationType.QUEUE, FANOUT_EXCHANGE, "", null));  //���ν������Ͷ���4��

        //���⽻�����󶨸���·�ɼ�ȥƥ��
        /*  amqpAdmin.declareBinding(new Binding(QUEUE_ONE, Binding.DestinationType.QUEUE, TOPIC_EXCHANGE, "top.*", null)); //���⽻����ʹ��·�ɼ� top.*�Ͷ���һ��*/
        amqpAdmin.declareBinding(new Binding(QUEUE_TWO, Binding.DestinationType.QUEUE, TOPIC_EXCHANGE, "top.#", null)); //���⽻����ʹ��·�ɼ� top.*�Ͷ��ж���
        amqpAdmin.declareBinding(new Binding(QUEUE_THREE, Binding.DestinationType.QUEUE, TOPIC_EXCHANGE, "*.user", null)); //���⽻����ʹ��·�ɼ� *.user�Ͷ�������

        amqpAdmin.declareBinding(new Binding(QUEUE_FOUR, Binding.DestinationType.QUEUE, TOPIC_EXCHANGE, "top.user.*", null)); //���⽻����ʹ��·�ɼ� top.user.*�Ͷ����İ�
        amqpAdmin.declareBinding(new Binding(QUEUE_FIVE, Binding.DestinationType.QUEUE, TOPIC_EXCHANGE, "top.user.#", null)); //���⽻����ʹ��·�ɼ� top.user.#�Ͷ������


    }

}
