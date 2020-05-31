package com.mybatis.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author LX
 * @Date 2020/5/30 13:43
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductMessageVo {
    private int productId;
    private int userId;
}
