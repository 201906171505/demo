package com.example.demo.common;

public class ResultUtil {

    public static ResponseBean success(ResponseBean responseBean) {
        return responseBean;
    }

    public static ResponseBean success() {
        return success(null);
    }

    public static ResponseBean error(Integer code, String msg) {
        ResponseBean result = new ResponseBean();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
}