package com.entity;

import org.springframework.stereotype.Repository;

@Repository
public class Data {
    private Integer code = 0;
    private String msg;
    private Object data;

    public Data(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Data() {
    }

    public Integer getCode() {
        return code;
    }

    public Data setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Data setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Data setData(Object data) {
        this.data = data;
        return this;
    }
}
