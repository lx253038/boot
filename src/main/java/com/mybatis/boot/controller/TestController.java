package com.mybatis.boot.controller;

import com.mybatis.boot.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

}
