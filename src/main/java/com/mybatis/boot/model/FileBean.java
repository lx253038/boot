package com.mybatis.boot.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * @Author LX
 * @Date 2020/1/12 13:31
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "filebean")
public class FileBean {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String guid; //¹ØÁªId

    private String name;

    private String url;

    private double size;

    private String type;

    private Date uploadTime;
}
