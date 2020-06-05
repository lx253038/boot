package com.mybatis.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import com.mybatis.boot.mapper.UserMapper;
import com.mybatis.boot.model.User;
import com.mybatis.boot.model.UserExample;
import com.mybatis.boot.service.ProductService;
import com.mybatis.boot.service.UserService;

/**
 * @Author LX
 * @Date 2019/12/3 14:27
 * @Description TODO
 */
@Service
@CacheConfig(cacheNames = "user",cacheManager = "redisCacheManager")  //缓存当前区域，@CacheEvict(allEntries = true)清空当前区域的所有缓存
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    private final RedisTemplate redisTemplate;

    private final UserMapper userMapper;

    public UserServiceImpl(RedisTemplate redisTemplate, UserMapper userMapper) {
        this.redisTemplate = redisTemplate;
        this.userMapper = userMapper;
    }

    @Autowired
    ProductService productService;

    @Override
    @Cacheable
    public List<User> getUserAll() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    @CacheEvict(allEntries = true)
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    @Cacheable
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.selectList(null);
        return new PageInfo<>(list, 4);
    }

    @Override
    @Cacheable
    public User getById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @CacheEvict(allEntries = true)
    public int del(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }


    @Override
    @Transactional
    public void buyListProduct(int userId, List<Integer> productIdList) {
        for (Integer id : productIdList) {
            productService.buyProduct(userId, id, 1);
        }
    }
}
