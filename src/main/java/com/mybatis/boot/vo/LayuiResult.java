package com.mybatis.boot.vo;

/**
 * @Author LX
 * @Date 2019/10/17 15:11
 * @Description TODO
 */
public class LayuiResult<T> {
    private Integer code;

    private String msg;

    private T data;

    public LayuiResult() {
    }

    public LayuiResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static LayuiResult success(String msg) {
        return new LayuiResult(0, msg, null);
    }

    public static LayuiResult error(String msg) {
        return new LayuiResult(-1, msg, null);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
