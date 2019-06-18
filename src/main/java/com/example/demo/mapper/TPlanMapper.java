package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.TPlanModel;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xl
 * @since 2019-05-30
 */
public interface TPlanMapper extends BaseMapper<TPlanModel> {


    Integer countSamePlanName(@Param("params") Map<String, Object> params);

    TPlanModel selectPlanById(String planId);
}
