package com.mybatis.boot.controller;

import com.mybatis.boot.util.ResultUtil;
import com.mybatis.boot.vo.LayuiResult;
import com.wf.captcha.SpecCaptcha;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
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
@Validated
public class LoginController {

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/loginCheck")
    @ResponseBody
    public LayuiResult loginCheck(HttpServletResponse response, @Length(min = 3, max = 10, message = "用户名长度最少3位，最多10位！") String username, @NotEmpty String password, String vercode, String codeKey) {


        Object relText = redisTemplate.opsForValue().get(codeKey);
        if (relText == null) {
            return ResultUtil.error(500, "验证码已过期");
        }
        if (!vercode.equalsIgnoreCase(String.valueOf(relText))) {
            return ResultUtil.error(500, "验证码错误");
        }
        redisTemplate.delete(codeKey);

        String token = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set("token::" + token, username, 7, TimeUnit.DAYS);
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(3600 * 24 * 7);
        cookie.setPath("/boot");
        response.addCookie(cookie);
        return ResultUtil.success("登录成功！");

    }

    @GetMapping("/index")
    public String index(@RequestParam(value = "token", required = false) String param, @CookieValue(value = "token", required = false) String token, Model model) {
        String userName = (String) redisTemplate.opsForValue().get("token::" + (StringUtils.isEmpty(param) ? token : param));
        if (StringUtils.isEmpty(userName)) {
            return "login";
        }
        model.addAttribute("user", userName);

        return "hello";
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
