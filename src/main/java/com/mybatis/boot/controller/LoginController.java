package com.mybatis.boot.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.boot.model.User;
import com.mybatis.boot.util.ResultUtil;
import com.mybatis.boot.vo.LayuiResult;
import com.wf.captcha.SpecCaptcha;

/**
 * @Author LX
 * @Date 2020/2/6 9:55
 * @Description
 */
@Controller
@Validated
public class LoginController {

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/login")
    public String login(User user) {
        if(user!=null){
            return "redirect:/";
        }
        return "login";
    }


    @GetMapping("/logout")
    public String logout(HttpServletResponse response, HttpServletRequest request) {

//        Cookie cookie = new Cookie("token", "");
//        cookie.setMaxAge(0);
//        cookie.setPath("/boot");
//        response.addCookie(cookie);
        redisTemplate.delete("session::" + request.getSession().getId());
        return "redirect:/login";
    }

    @PostMapping("/loginCheck")
    @ResponseBody
    public LayuiResult loginCheck(HttpServletRequest request, HttpServletResponse response, @Length(min = 3, max = 10, message = "�û�����������3λ�����10λ��") String username, @NotEmpty String password, String vercode, String codeKey) {

        Object relText = redisTemplate.opsForValue().get(codeKey);
        if (relText == null) {
            return ResultUtil.error(500, "��֤���ѹ���");
        }
        if (!vercode.equalsIgnoreCase(String.valueOf(relText))) {
            return ResultUtil.error(500, "��֤�����");
        }
        redisTemplate.delete(codeKey);
        User user = new User(username, new Random().nextInt(100));
        //�ֶ�����cookie
//        String token = UUID.randomUUID().toString();
//        redisTemplate.opsForValue().set("token::" + token, user, 30, TimeUnit.MINUTES);
//        Cookie cookie = new Cookie("token", token);
//        cookie.setMaxAge(3600 * 24 * 7);
//        cookie.setPath("/boot");
//        response.addCookie(cookie);
        //ʹ��SpringSessionʵ��
        redisTemplate.opsForValue().set("session::" + request.getSession().getId(), user, 30, TimeUnit.MINUTES);

        return ResultUtil.success("��¼�ɹ���");

    }



    @PostMapping("/getCode")
    @ResponseBody
    public Map getCode() {
        Map<String, Object> map = new HashMap<>();
        String codeKey = "codeKey::" + UUID.randomUUID().toString();
        //����GIF
        /* ChineseGifCaptcha captcha = new ChineseGifCaptcha(120, 40);  */
        //��������
       /* ArithmeticCaptcha  captcha=new ArithmeticCaptcha(120,40);
        captcha.setLen(2); //����*/
        //��ͨ����
        /*ChineseCaptcha captcha = new ChineseCaptcha(120, 40);*/
        //��ĸ���ֻ��gif
        /*GifCaptcha captcha=new GifCaptcha(120,40);*/
        //��ͨ��ĸ���ֻ��
        SpecCaptcha captcha = new SpecCaptcha(120, 40);
        captcha.setLen(4);


        redisTemplate.opsForValue().set(codeKey, captcha.text(), 2, TimeUnit.MINUTES);
        map.put("codeKey", codeKey);
        map.put("image", captcha.toBase64());
        return map;

    }

}
