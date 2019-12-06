package com.mybatis.boot.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mybatis.boot.model.User;
import com.mybatis.boot.model.UserExample;
import com.mybatis.boot.util.MybatisRedisCache;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@CacheNamespace(implementation = MybatisRedisCache.class, eviction = MybatisRedisCache.class, size = 1024)
public interface UserMapper extends BaseMapper<User> {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    @Override
    Integer insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}