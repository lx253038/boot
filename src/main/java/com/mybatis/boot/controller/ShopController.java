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
 * @Description 商品相关
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
     * 传统秒杀（只查询数据库效率较慢）
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
        //判断库存
        Product product = productService.getById(productId);
        if (product.getCount() <= 0) {
            return LayuiResult.error("商品库存为空！");
        }
        //判断用户是否重复购买
        List<Order> list = orderService.list(new LambdaQueryWrapper<Order>().eq(Order::getUserId, userId).eq(Order::getProductId, productId));
        if (list.size() > 0) {
            return LayuiResult.error("您已秒杀成功，请不要重复购买！");
        }
        //秒杀购买商品
        try {
            productService.buyProduct(userId, productId, 1);
        } catch (Exception e) {
            return LayuiResult.error(e.getMessage());
        }
        return LayuiResult.success("秒杀成功！");
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

        return LayuiResult.success("秒杀开始！");
    }

    /**
     * Redis预减库存，使用rabbitmq消息队列异步下单
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
        //执行redis lua脚本
        String script = "if (redis.call('exists', KEYS[1]) and redis.call('get', KEYS[1]) > '0')  then redis.call('decr', KEYS[1])  return true else return false end";
        DefaultRedisScript<Boolean> redisScript=new DefaultRedisScript<>(script);
        redisScript.setResultType(Boolean.class);
        List<String> listKey = new ArrayList();
        listKey.add("product::" + productId);
        if ( !(Boolean) redisTemplate.execute(redisScript,listKey)) {
            return LayuiResult.error("商品库存为空！");
        }
        //判断用户是否重复购买
        if (redisTemplate.opsForValue().get("buyProduct::" + userId + "-" + productId) != null) {
            redisTemplate.opsForValue().increment("product::" + productId);
            return LayuiResult.error("您已秒杀成功，请不要重复购买！");
        }
        //将商品id和用户id加入队列
        rabbitTemplate.convertAndSend(ExchangeAndQueue.DIRECT_EXCHANGE, "createOrder", new ProductMessageVo(productId, userId));

        return LayuiResult.success("排队中");
    }

}
