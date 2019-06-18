package com.example.demo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel(value="返回对象", description="")
public class ResponseBean implements Serializable {
    @ApiModelProperty(value = "状态码")
    private int code;
    @ApiModelProperty(value = "提示信息")
    private String message;
    @ApiModelProperty(value = "返回数据")
    private Object data;


    

}
