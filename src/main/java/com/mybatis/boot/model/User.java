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
//@JsonIgnoreProperties({"id","age"})  //����һ������
public class User implements Serializable {
    private static final long serialVersionUID = 1366286602560674740L;
    @TableId(type = IdType.AUTO)
    private Integer id;


    @Length(max = 10, message = "�������ʮλ")
    private String name;
    //    @JsonProperty("aaa")  //�ô�������ʾ��ǰ����
    //    @JsonIgnore   //���Ե�ǰ����
    private Integer age;

    @TableField(exist = false) //��ӳ�����ݿ���ֶ�
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