package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author xl
 * @since 2019-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "t_task",resultMap = "TTaskModelResultMap")
@ApiModel(value="TTaskModel对象", description="")
public class TTaskModel implements Serializable {

private static final long serialVersionUID=1L;
    @TableId
    private String taskId;

    @ApiModelProperty(value = "父任务id")
    private String taskPId = "-1" ;

    @ApiModelProperty(value = "所属计划")
    private String planId;

    @ApiModelProperty(value = "任务名称")
    private String name;

    @ApiModelProperty(value = "分配人")
    private String assignId;

    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginDate;

    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    @ApiModelProperty(value = "负责人")
    private String leaderId;

    @ApiModelProperty(value = "附件URL")
    private String attachmentUrl;

    @ApiModelProperty(value = "1待接收，2进行中、3已超期、4待验收")
    private Integer state;

    @ApiModelProperty(value = "任务描述")
    private String taskDesc;


}
