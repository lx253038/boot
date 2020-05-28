package com.mybatis.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.boot.mapper.ProductMapper;
import com.mybatis.boot.mapper.UserMapper;
import com.mybatis.boot.model.Product;
import com.mybatis.boot.model.User;
import com.mybatis.boot.service.ProductService;

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

    @Override
    //REQUIRED:�����ǰ������ͼ��뵽�������,û�о��½�
    //@Transactional(propagation = Propagation.REQUIRED)
    //REQUIRES_NEW�������ǰ�������������񲢴���������û��Ҳ�½�����
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    //SUPPORTS�������ǰ��������ʹ�����������ǰû��������ʹ������
    //@Transactional(propagation = Propagation.SUPPORTS)
    //NOT_SUPPORTED�����÷�������������𣬲����ھͲ�ʹ������
    //@Transactional(propagation = Propagation.NOT_SUPPORTED)
    //MANDATORY�����÷�����������񣬲����������쳣
    //@Transactional(propagation = Propagation.MANDATORY)
    //NEVER�����÷����벻�������񣬷������쳣
    //@Transactional(propagation = Propagation.NEVER)
    public void buyProduct(int userId, int productId, int count) {
        User user = userMapper.selectByPrimaryKey(userId);
        Product product = productMapper.selectById(productId);
        //�����
        productMapper.updateCountById(productId, count);
        //�����û����
        user.setMoney(user.getMoney() - product.getPrice() * count);
        if (user.getMoney() < 0) {
            throw new RuntimeException("����");
        }
        userMapper.updateById(user);
    }


}
