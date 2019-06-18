package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.common.AppException;
import com.example.demo.mapper.TPlanMapper;
import com.example.demo.model.TPlanModel;
import com.example.demo.model.TTaskModel;
import com.example.demo.model.TTaskPlayModel;
import com.example.demo.service.ITPlanService;
import com.example.demo.service.ITTaskPlayService;
import com.example.demo.service.ITTaskService;
import com.example.demo.vo.TaskModelVo;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xl
 * @since 2019-05-30
 */
@Service
public class TPlanServiceImpl extends ServiceImpl<TPlanMapper, TPlanModel> implements ITPlanService {
    @Autowired
    ITTaskService taskService;

    @Autowired
    ITTaskPlayService taskPlayService;
    /**
     * slf4j
     */
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void savePlan(TPlanModel planModel) throws Exception{
        try {
            planModel.setPlanId(UUID.randomUUID().toString());
            this.baseMapper.insert(planModel);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("计划插入错误:{}",e.getMessage());
            throw new AppException(500,"计划插入错误!");
        }
    }

    @Override
    public void updatePlan(TPlanModel planModel){
        try {
            Map<String,Object> params = Maps.newHashMap();
            params.put("id",planModel.getPlanId());
            params.put("name",planModel.getName());
            Integer countNum = this.baseMapper.countSamePlanName(params);
            if (0!=Integer.parseInt(countNum.toString())){
                logger.info("存在相同计划名称，校验失败！");
            }
            this.baseMapper.updateById(planModel);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("计划更新错误:{}",e.getMessage());
            throw new AppException(500,"计划更新错误!");
        }
    }

    @Override
    public IPage<TPlanModel> selectPlanList(Page<TPlanModel> tPlanModelPage, TPlanModel planModel) throws Exception{
        QueryWrapper<TPlanModel> qw = new QueryWrapper<TPlanModel>().eq("name", "李四");
        IPage<TPlanModel> tPlanModelIPage;
        try {
            this.baseMapper.selectById(planModel.getPlanId());
            tPlanModelIPage = this.baseMapper.selectPage(tPlanModelPage,qw);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("分页查询出错：{}",e.getMessage());
            throw new AppException(500,"分页查寻出错");
        }
        return tPlanModelIPage;
    }

    @Transactional
    @Override
    public String makeTask(TaskModelVo taskModelVo) throws Exception {
        try {
            TTaskModel task = taskModelVo.getTask();
            task.setState(1);//待接收
            //插入任务
            this.taskService.save(task);
            //
            List<String> playIds = taskModelVo.getPlayIds();
            for (String playId : playIds) {
                TTaskPlayModel tTaskPlayModel = new TTaskPlayModel();
                tTaskPlayModel.setPlayId(playId);
                tTaskPlayModel.setTaskId(task.getTaskId());
                this.taskPlayService.save(tTaskPlayModel);
            }
            //更新计划状态
            TPlanModel plan = new TPlanModel();
            plan.setPlanId(taskModelVo.getTask().getPlanId());
            plan.setState(2);
            this.baseMapper.updateById(plan);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("安排任务失败! 事务回滚",e.getMessage());
            throw  new AppException(500,"安排任务失败");
        }
        return taskModelVo.getTask().getTaskId();
    }


}
