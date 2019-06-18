package com.example.demo.vo;

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
@ApiModel(value="task查询对象", description="")
public class TaskQueryVo implements Serializable {

private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "学年学期")
    private String schoolYear;

    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    @ApiModelProperty(value = "任务类型")
    private String taskType;


    @ApiModelProperty(value = "任务状态(0、进行中 1、已完成 2、已终止)")
    private int taskStatus;


    @ApiModelProperty(value = "计划名称")
    private String planName;

    @ApiModelProperty(value = "当前登录的用户ID")
    private String currentUserId;




}
