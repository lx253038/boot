package com.mybatis.boot.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("users")
//@JsonIgnoreProperties({"id","age"})  //忽略一组属性
public class User implements Serializable {
    private static final long serialVersionUID = 1366286602560674740L;
    @TableId(type = IdType.AUTO)
    private Integer id;


    @Length(max = 10, message = "长度最多十位")
    private String name;
    //    @JsonProperty("aaa")  //用此名称显示当前属性
    //    @JsonIgnore   //忽略当前属性
    private Integer age;

    @TableField(exist = false) //不映射数据库的字段
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate = new Date();

    private double money;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, Integer age, double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }
}