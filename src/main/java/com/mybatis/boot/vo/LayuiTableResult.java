package com.mybatis.boot.vo;

import java.util.List;

/**
 * @Author LX
 * @Date 2020/1/12 15:40
 * @Description
 */
public class LayuiTableResult {
    private Integer code;

    private String msg;

    private Long count;

    private List data;

    public LayuiTableResult() {
    }

    public LayuiTableResult(Long count, List data) {//默认成功
        this.code = 0;
        this.msg = "成功";
        this.count = count;
        this.data = data;
    }

    public LayuiTableResult(Integer code, String msg, Long count, List data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
