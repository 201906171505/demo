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
@TableName("t_plan")
@ApiModel(value="TPlanModel对象", description="")
public class TPlanModel implements Serializable {

private static final long serialVersionUID=1L;
    @TableId
    private String planId;

    @ApiModelProperty(value = "计划名称")
    private String name;

    @ApiModelProperty(value = "开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginDate;

    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    @ApiModelProperty(value = "状态（1 未安排 2 已安排）")
    private Integer state;

    @ApiModelProperty(value = "学年学期")
    private String schoolSemester;

    @ApiModelProperty(value = "附件URL")
    private String attachmentUrl;


}
