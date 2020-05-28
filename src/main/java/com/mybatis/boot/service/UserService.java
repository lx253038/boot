package com.mybatis.boot.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.mybatis.boot.model.User;

/**
 * @Author LX
 * @Date 2019/12/3 14:26
 * @Description TODO
 */
public interface UserService extends IService<User> {

    List<User> getUserAll();

    int addUser(User user);

    PageInfo<User> findAllUser(int pageNum, int pageSize);

    User getById(int id);

    int del(Integer id);

    void buyListProduct(int userId, List<Integer> productIdList);
}
