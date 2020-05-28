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
 * @Date 2019/12/12 14:28
 * @Description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("systemlog")
public class SystemLog {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String userName;

    private String operation;

    private long time;

    private String method;

    private String params;

    private String ip;

    private Date createTime;

}
