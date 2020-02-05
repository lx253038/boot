package com.mybatis.boot.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.boot.annotation.SysLog;
import com.mybatis.boot.asyn.AsyncService;
import com.mybatis.boot.model.User;
import com.mybatis.boot.service.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @Author LX
 * @Date 2019/12/3 15:58
 * @Description TODO
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    private final AsyncService asyncService;

    private final Executor pool;

    public UserController(UserService userService, AsyncService asyncService, Executor pool) {
        this.userService = userService;
        this.asyncService = asyncService;
        this.pool = pool;
    }


    @SysLog("新增用户")
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public Object addUser(@Valid User user,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return bindingResult.getFieldErrors();
        }
        return userService.addUser(user);
    }


    @SysLog("分页查询用户信息")
    @GetMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable(value = "pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        System.out.println(pool);
/*        pool.submit(() -> {
            int sum = 0;
            for (int i = 0; i <= 100; i++) {
                sum += i;
                try {
                    TimeUnit.MILLISECONDS.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+":sum="+sum);
            return sum;
        });*/
        PageHelper.startPage(pageNum, pageSize);
        /* PageInfo pageInfo = userService.findAllUser(pageNum, pageSize);*/   //spring缓存
        PageInfo pageInfo = new PageInfo(userService.list(), 4);      //mybatis二级缓存
//        for (int i = 0; i < 110; i++) {
//            asyncService.executeAsync();
//        }
        return pageInfo;
    }

    @SysLog("根据Id获取用户信息")
    @GetMapping(value = "/get/{id}", produces = {"application/json;charset=UTF-8"})
    public User getById(@PathVariable(value = "id") int id) {
        return userService.getById(id);
    }

    @SysLog("根据Id删除用户信息")
    @GetMapping(value = "/del/{id}")
    public int deleteById(@PathVariable(value = "id") Integer id) {
        return userService.del(id);
    }

    @GetMapping("/getAll")
    public List<User> getUserAll(){
        return userService.getUserAll();
    }
}

