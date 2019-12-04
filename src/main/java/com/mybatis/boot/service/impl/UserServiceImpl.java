package com.mybatis.boot.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mybatis.boot.dao.UserMapper;
import com.mybatis.boot.model.User;
import com.mybatis.boot.model.UserExample;
import com.mybatis.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LX
 * @Date 2019/12/3 14:27
 * @Description TODO
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RedisTemplate redisTemplate;

    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getUserAll() {
        System.out.println(userMapper);
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public int addUser(User user) {

        return userMapper.insert(user);
    }

    @Override
    public Page<User> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.selectByExample(new UserExample());

        return (Page<User>) list;
    }

    @Override
    public User getById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
