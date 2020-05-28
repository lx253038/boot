package com.mybatis.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mybatis.boot.model.Product;

/**
 * @Author LX
 * @Date 2020/5/28 13:38
 * @Description
 */
public interface ProductService extends IService<Product> {

    void buyProduct(int userId, int productId, int count);

}
