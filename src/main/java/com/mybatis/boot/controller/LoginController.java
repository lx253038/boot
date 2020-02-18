package com.mybatis.boot.controller;

import com.wf.captcha.SpecCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author LX
 * @Date 2020/2/6 9:55
 * @Description
 */
@Controller
public class LoginController {

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/loginCheck")
    @ResponseBody
    public String loginCheck(String username, String password, String vercode, String codeKey) {
        System.out.println(username);
        System.out.println(password);
        Object relText = redisTemplate.opsForValue().get(codeKey);
        if (relText == null) {
            return "验证码已过期！";
        }
        if (!vercode.equalsIgnoreCase(String.valueOf(relText))) {
            return "验证码错误！";
        }
        redisTemplate.delete(codeKey);
        return "登录成功！";

    }

    @PostMapping("/getCode")
    @ResponseBody
    public Map getCode() {
        Map<String, Object> map = new HashMap<>();
        String codeKey = "codeKey::" + UUID.randomUUID().toString();
        //中文GIF
        /* ChineseGifCaptcha captcha = new ChineseGifCaptcha(120, 40);  */
        //算数运算
       /* ArithmeticCaptcha  captcha=new ArithmeticCaptcha(120,40);
        captcha.setLen(2); //个数*/
        //普通中文
        /*ChineseCaptcha captcha = new ChineseCaptcha(120, 40);*/
        //字母数字混合gif
        /*GifCaptcha captcha=new GifCaptcha(120,40);*/
        //普通字母数字混合
        SpecCaptcha captcha = new SpecCaptcha(120, 40);
        captcha.setLen(4);


        redisTemplate.opsForValue().set(codeKey, captcha.text(), 2, TimeUnit.MINUTES);
        map.put("codeKey", codeKey);
        map.put("image", captcha.toBase64());
        return map;

    }

}
