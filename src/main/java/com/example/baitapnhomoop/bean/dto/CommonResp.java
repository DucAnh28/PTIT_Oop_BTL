package com.example.baitapnhomoop.bean.dto;

public class CommonResp<T> {

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
