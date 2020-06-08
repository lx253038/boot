package com.mybatis.boot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.mybatis.boot.model.Carousel;
import com.mybatis.boot.model.Order;
import com.mybatis.boot.model.Product;
import com.mybatis.boot.model.User;
import com.mybatis.boot.rabbitmq.ExchangeAndQueue;
import com.mybatis.boot.service.CarouselServie;
import com.mybatis.boot.service.OrderService;
import com.mybatis.boot.service.ProductService;
import com.mybatis.boot.vo.LayuiResult;
import com.mybatis.boot.vo.ProductMessageVo;

/**
 * @Author LX
 * @Date 2020/2/21 15:44
 * @Description ��Ʒ���
 */
@Controller
public class ShopController implements InitializingBean {

    @Autowired
    private CarouselServie carouselServie;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping({"/index", "/"})
    public String index(Model model, User user) {
        PageHelper.startPage(0, 5);
        List<Carousel> carouselList = carouselServie.list();
        model.addAttribute("carouselList", carouselList);
        model.addAttribute("user", user);
        model.addAttribute("type", "index");
        return "shop/index";
    }

    @GetMapping({"/product"})
    public String product(Model model, User user) {
        model.addAttribute("user", user);
        model.addAttribute("type", "product");
        return "shop/product";
    }

    @GetMapping({"/product-details"})
    public String productDetails(Model model, User user) {
        model.addAttribute("user", user);
        return "shop/product-details";
    }

    /**
     * ��ͳ��ɱ��ֻ��ѯ���ݿ�Ч�ʽ�����
     *
     * @param userId
     * @param productId
     * @return
     */
    @GetMapping("/miaosha")
    @ResponseBody
    public LayuiResult miaoSha(@RequestParam(required = false) Integer userId, @RequestParam(required = true) int productId) {
        if (userId == null) {
            userId = new Random().nextInt(100) + 1001;
        }
        //�жϿ��
        Product product = productService.getById(productId);
        if (product.getCount() <= 0) {
            return LayuiResult.error("��Ʒ���Ϊ�գ�");
        }
        //�ж��û��Ƿ��ظ�����
        List<Order> list = orderService.list(new LambdaQueryWrapper<Order>().eq(Order::getUserId, userId).eq(Order::getProductId, productId));
        if (list.size() > 0) {
            return LayuiResult.error("������ɱ�ɹ����벻Ҫ�ظ�����");
        }
        //��ɱ������Ʒ
        try {
            productService.buyProduct(userId, productId, 1);
        } catch (Exception e) {
            return LayuiResult.error(e.getMessage());
        }
        return LayuiResult.success("��ɱ�ɹ���");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        List<Product> list = productService.list();
        for (Product product : list) {
            redisTemplate.opsForValue().set("product::" + product.getId(), product.getCount());
        }
        redisTemplate.delete(redisTemplate.keys("buyProduct*"));
    }

    @GetMapping("/startMS")
    @ResponseBody
    public LayuiResult startMS() {
        List<Product> list = productService.list();
        for (Product product : list) {
            redisTemplate.opsForValue().set("product::" + product.getId(), product.getCount());
        }
        redisTemplate.delete(redisTemplate.keys("buyProduct*"));

        return LayuiResult.success("��ɱ��ʼ��");
    }

    /**
     * RedisԤ����棬ʹ��rabbitmq��Ϣ�����첽�µ�
     * @param userId
     * @param productId
     * @return
     */
    @GetMapping("/miaosha2")
    @ResponseBody
    public LayuiResult miaoSha2(@RequestParam(required = false) Integer userId, @RequestParam(required = true) int productId) {
        if (userId == null) {
            userId = new Random().nextInt(2000) + 1001;
        }
        //long count = redisTemplate.opsForValue().decrement("product::" + productId);
        //ִ��redis lua�ű�
        String script = "if (redis.call('exists', KEYS[1]) and redis.call('get', KEYS[1]) > '0')  then redis.call('decr', KEYS[1])  return true else return false end";
        DefaultRedisScript<Boolean> redisScript=new DefaultRedisScript<>(script);
        redisScript.setResultType(Boolean.class);
        List<String> listKey = new ArrayList();
        listKey.add("product::" + productId);
        if ( !(Boolean) redisTemplate.execute(redisScript,listKey)) {
            return LayuiResult.error("��Ʒ���Ϊ�գ�");
        }
        //�ж��û��Ƿ��ظ�����
        if (redisTemplate.opsForValue().get("buyProduct::" + userId + "-" + productId) != null) {
            redisTemplate.opsForValue().increment("product::" + productId);
            return LayuiResult.error("������ɱ�ɹ����벻Ҫ�ظ�����");
        }
        //����Ʒid���û�id�������
        rabbitTemplate.convertAndSend(ExchangeAndQueue.DIRECT_EXCHANGE, "createOrder", new ProductMessageVo(productId, userId));

        return LayuiResult.success("�Ŷ���");
    }

}
