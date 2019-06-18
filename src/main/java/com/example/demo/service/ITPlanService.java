package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.TPlanModel;
import com.example.demo.vo.TaskModelVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xl
 * @since 2019-05-30
 */
public interface ITPlanService extends IService<TPlanModel> {

    void savePlan(TPlanModel planModel) throws Exception;

    void updatePlan(TPlanModel planModel) throws Exception;

    IPage<TPlanModel> selectPlanList(Page<TPlanModel> tPlanModelPage, TPlanModel planModel) throws Exception;

    String makeTask(TaskModelVo taskModelVo) throws Exception;
}
