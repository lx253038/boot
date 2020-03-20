package com.mybatis.boot.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Carousel {
    private Integer id;

    private String productid;

    private String imgurl;

    private String content;

}