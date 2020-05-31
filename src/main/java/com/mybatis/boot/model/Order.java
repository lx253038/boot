package com.mybatis.boot.model;

import java.util.Date;

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
@TableName("product_order")
public class Order {

    private int id;

    private String orderCode;

    private int productId;

    private int userId;

    private Date createDate;
}
