package com.mybatis.boot.controller;

/**
 * @Author LX
 * @Date 2019/12/3 15:58
 * @Description TODO
 */

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.mybatis.boot.model.User;
import com.mybatis.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/8/16.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user) {
        return userService.addUser(user);
    }


    @GetMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable(value = "pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        Page<User> page = userService.findAllUser(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(page, 4);
        System.out.println(pageInfo);
        return pageInfo;
    }


    @GetMapping(value = "/get/{id}", produces = {"application/json;charset=UTF-8"})
    public User getById(@PathVariable(value = "id") int id) {

        return userService.getById(id);
    }
}

