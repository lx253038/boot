package com.mybatis.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatis.boot.model.Carousel;
import com.mybatis.boot.util.MybatisRedisCache;
import org.apache.ibatis.annotations.CacheNamespace;

@CacheNamespace(implementation = MybatisRedisCache.class, eviction = MybatisRedisCache.class, size = 1024)
public interface CarouselMapper extends BaseMapper<Carousel> {

}