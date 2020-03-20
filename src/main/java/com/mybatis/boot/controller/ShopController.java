package com.mybatis.boot.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.mybatis.boot.model.Carousel;
import com.mybatis.boot.model.User;
import com.mybatis.boot.service.CarouselServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author LX
 * @Date 2020/2/21 15:44
 * @Description 商品相关
 */
@Controller
public class ShopController {

    @Autowired
    private CarouselServie carouselServie;

    @GetMapping({"/index", "/"})
    public String index(Model model, User user) {
        PageHelper.startPage(0, 5);
        List<Carousel> carouselList = carouselServie.list();
        model.addAttribute("carouselList", carouselList);
        model.addAttribute("user", user);
        model.addAttribute("type", "index");
        return "shop/index";
    }

    @GetMapping({"/product"})
    public String product(Model model, User user) {
        model.addAttribute("user", user);
        model.addAttribute("type", "product");
        return "shop/product";
    }

    @GetMapping({"/product-details"})
    public String productDetails(Model model, User user) {
        model.addAttribute("user", user);
        return "shop/product-details";
    }
}
