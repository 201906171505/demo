package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author xl
 * @since 2019-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("users")
@ApiModel(value="UsersModel对象", description="")
public class UsersModel implements Serializable {

private static final long serialVersionUID=1L;
    @TableId
    private String userId;

    private String userName;

    private String userPassword;

    private String userEmail;

    private LocalDateTime registerTime;

    private Integer valid;


}
