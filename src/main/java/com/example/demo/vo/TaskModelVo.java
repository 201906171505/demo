package com.example.demo.vo;

import com.example.demo.model.TTaskModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
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
@ApiModel(value="TTaskModel请求对象", description="")
public class TaskModelVo implements Serializable {

private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "任务相")
    private TTaskModel task;

    @ApiModelProperty(value = "参与人集合")
    private List<String> playIds;






}
