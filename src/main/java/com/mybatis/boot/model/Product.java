package com.mybatis.boot.model;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author LX
 * @Date 2020/5/28 13:35
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("product")
public class Product {

    private int id;

    private String name;

    private int count;

    private double price;

    private String content;

    public Product(String name, int count, double price, String content) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.content = content;
    }
}
