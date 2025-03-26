package com.example.baitapnhomoop.exception;

import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException {

    private final HttpStatus status;

    private final String error;

    private final String message;

    private Object errorDetail;


    public CommonException(HttpStatus status, String error, String message, Object errorDetail) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.errorDetail = errorDetail;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Object getErrorDetail() {
        return errorDetail;
    }
}