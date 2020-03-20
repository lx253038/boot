package com.mybatis.boot.controller;

import com.mybatis.boot.model.User;
import com.mybatis.boot.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2020/2/5 16:16
 * @Description
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public Object test(HttpServletRequest httpServletRequest) throws InterruptedException {
        httpServletRequest.getSession().setAttribute("user",new User("ÀîËÄ",45));
        TimeUnit.SECONDS.sleep(2);
        System.out.println(httpServletRequest.getSession().getId());
        return "SUCCESS";
    }

    @Autowired
    AlipayService alipayService;


    @RequestMapping("/pay")
    public void payMent(HttpServletResponse response, HttpServletRequest request) {
        try {
            alipayService.aliPay(response,request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
