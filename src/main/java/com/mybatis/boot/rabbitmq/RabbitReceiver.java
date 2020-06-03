package com.mybatis.boot.rabbitmq;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mybatis.boot.model.Order;
import com.mybatis.boot.model.Product;
import com.mybatis.boot.model.User;
import com.mybatis.boot.service.OrderService;
import com.mybatis.boot.service.ProductService;
import com.mybatis.boot.vo.ProductMessageVo;

/**
 * @Author LX
 * @Date 2019/12/13 16:24
 * @Description TODO
 */
@Component
public class RabbitReceiver {
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RedisTemplate redisTemplate;


    @RabbitListener(queues = "queue1")
    public void getMsg(User user) {
        System.out.println("队列1消费消息User=:" + user);
    }

    @RabbitListener(queues = {"queue1"})
    public void getMsg1(Message message) throws UnsupportedEncodingException {
        String userStr = new String(message.getBody(), "UTF-8");
        System.out.println("队列1消费消息Json:" + userStr);
        User user = JSON.parseObject(userStr, User.class);
        System.out.println(user);

    }


    @RabbitListener(queues = "queue2")
    public void getMsgStr2(ProductMessageVo messageVo) {

        Product product = productService.getById(messageVo.getProductId());
        if (product.getCount() <= 0) {
            return;
        }
        //判断用户是否重复购买
        List<Order> list = orderService.list(new LambdaQueryWrapper<Order>().eq(Order::getUserId, messageVo.getUserId()).eq(Order::getProductId, messageVo.getProductId()));
        if (list.size() > 0) {
            //将redis中库存加1
            redisTemplate.opsForValue().increment("product::" + messageVo.getProductId());
            return;
        }
        //秒杀购买商品
        try {
            productService.buyProduct(messageVo.getUserId(), messageVo.getProductId(), 1);
            redisTemplate.opsForValue().set("buyProduct::" + messageVo.getUserId() + "-" + messageVo.getProductId(), true);
        } catch (Exception e) {
            redisTemplate.opsForValue().increment("product::" + messageVo.getProductId());
            System.out.println(e.getMessage());
        }
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
