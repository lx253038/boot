package com.mybatis.boot.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

    Page<User> findAllUser(int pageNum, int pageSize);

    User getById(int id);
}
