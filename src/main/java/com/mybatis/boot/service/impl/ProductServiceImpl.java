package com.mybatis.boot.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.boot.mapper.OrderMapper;
import com.mybatis.boot.mapper.ProductMapper;
import com.mybatis.boot.mapper.UserMapper;
import com.mybatis.boot.model.Order;
import com.mybatis.boot.model.Product;
import com.mybatis.boot.model.User;
import com.mybatis.boot.service.ProductService;
import com.mybatis.boot.util.StringUtils;

/**
 * @Author LX
 * @Date 2020/5/28 15:41
 * @Description
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    OrderMapper orderMapper;

    @Override
    //REQUIRED:如果当前有事务就加入到这个事务,没有就新建
    //@Transactional(propagation = Propagation.REQUIRED)
    //REQUIRES_NEW：如果当前有事务挂起该事务并创建新事务，没有也新建事务
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    //SUPPORTS：如果当前有事务，则使用事务。如果当前没有事务，则不使用事务
    //@Transactional(propagation = Propagation.SUPPORTS)
    //NOT_SUPPORTED：调用方存在事务则挂起，不存在就不使用事务
    //@Transactional(propagation = Propagation.NOT_SUPPORTED)
    //MANDATORY：调用方必须存在事务，不存在则抛异常
    //@Transactional(propagation = Propagation.MANDATORY)
    //NEVER：调用方必须不存在事务，否则抛异常
    //@Transactional(propagation = Propagation.NEVER)
    public void buyProduct(int userId, int productId, int count) {
        User user = userMapper.selectByPrimaryKey(userId);
        Product product = productMapper.selectById(productId);
        //减库存
        if (productMapper.updateCountById(productId, count)) {
            //更新用户余额
            user.setMoney(user.getMoney() - product.getPrice() * count);
            if (user.getMoney() < 0) {
                throw new RuntimeException("余额不足");
            }
            userMapper.updateById(user);
            //写入订单
            Order order = new Order();
            order.setOrderCode(StringUtils.getOrderStr());
            order.setUserId(userId);
            order.setProductId(productId);
            order.setCreateDate(new Date());
            orderMapper.insert(order);
        }else{
            System.out.println(111);
        }
    }


}
