package com.example.demo.common;

/**
 * 应用异常类
 */
public class AppException extends RuntimeException{

    private Integer code;

    public AppException(int code,String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}