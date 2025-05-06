package com.example.baitapnhomoop.bean.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class CommonResp<T> implements Serializable {

    private String code;
    private String message;
    private T data;

    public CommonResp(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResp(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
