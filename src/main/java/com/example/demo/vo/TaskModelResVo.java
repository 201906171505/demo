package com.example.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
@ApiModel(value="TTaskModel返回对象", description="")
public class TaskModelResVo implements Serializable {

private static final long serialVersionUID=1L;

    private String taskId;

    @ApiModelProperty(value = "父任务id")
    private String taskPId;

    @ApiModelProperty(value = "所属计划")
    private String planId;

    @ApiModelProperty(value = "任务名称")
    private String name;

    @ApiModelProperty(value = "分配人")
    private String assignId;
    @ApiModelProperty(value = "分配人名称")
    private String assignName;

    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginDate;

    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    @ApiModelProperty(value = "负责人")
    private String leaderId;
    @ApiModelProperty(value = "负责人名称")
    private String leaderName;

    @ApiModelProperty(value = "附件URL")
    private String attachmentUrl;

    @ApiModelProperty(value = "1待接收，2进行中、3已超期、4待验收")
    private Integer state;

    @ApiModelProperty(value = "任务描述")
    private String taskDesc;

    @ApiModelProperty(value = "参与人")
    private List<User> users;

    public class User{
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}


