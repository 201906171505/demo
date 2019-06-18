package com.example.demo.enums;

public enum TaskType {
    IS_MY(1,"我参与的"),
    MY_DISPATCH(2,"我分配的"),
    MY_CHARGE(3,"我负责的");
    private  Integer code;
    private  String value;
    TaskType(Integer code,String value){
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
