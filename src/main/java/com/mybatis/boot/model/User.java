package com.mybatis.boot.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("users")
public class User implements Serializable {
    private static final long serialVersionUID = 1366286602560674740L;
    @TableId(type = IdType.AUTO)
    private Integer id;


    @Length(max = 10, message = "长度最多十位")
    private String name;


    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}