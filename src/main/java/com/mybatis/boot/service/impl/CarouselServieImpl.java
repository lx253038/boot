package com.mybatis.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.boot.mapper.CarouselMapper;
import com.mybatis.boot.model.Carousel;
import com.mybatis.boot.service.CarouselServie;
import org.springframework.stereotype.Service;

/**
 * @Author LX
 * @Date 2020/2/21 22:02
 * @Description
 */
@Service
public class CarouselServieImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselServie {
}
