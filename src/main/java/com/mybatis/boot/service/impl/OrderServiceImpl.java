package com.mybatis.boot.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.boot.mapper.OrderMapper;
import com.mybatis.boot.model.Order;
import com.mybatis.boot.service.OrderService;

/**
 * @Author LX
 * @Date 2020/5/30 11:00
 * @Description
 */

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
