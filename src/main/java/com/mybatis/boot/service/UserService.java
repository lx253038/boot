package com.mybatis.boot.service;

import com.github.pagehelper.PageInfo;
import com.mybatis.boot.model.User;

import java.util.List;

/**
 * @Author LX
 * @Date 2019/12/3 14:26
 * @Description TODO
 */
public interface UserService {

    List<User> getUserAll();

    int addUser(User user);

    PageInfo<User> findAllUser(int pageNum, int pageSize);

    User getById(int id);

    int del(Integer id);
}
