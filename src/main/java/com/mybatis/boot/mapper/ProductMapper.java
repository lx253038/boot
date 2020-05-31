package com.mybatis.boot.mapper;

import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatis.boot.model.Product;

/**
 * @Author LX
 * @Date 2020/5/28 13:38
 * @Description
 */
public interface ProductMapper extends BaseMapper<Product> {

    @Update("update product set count=count-#{count} where id=#{id} ")
    boolean updateCountById(int id, int count);

}
