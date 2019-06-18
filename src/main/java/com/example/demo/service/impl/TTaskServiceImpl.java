package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.common.AppException;
import com.example.demo.mapper.TTaskMapper;
import com.example.demo.model.TTaskModel;
import com.example.demo.service.ITTaskService;
import com.example.demo.service.IUsersService;
import com.example.demo.vo.TaskModelResVo;
import com.example.demo.vo.TaskQueryVo;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xl
 * @since 2019-05-30
 */
@Service
public class TTaskServiceImpl extends ServiceImpl<TTaskMapper, TTaskModel> implements ITTaskService {
    @Autowired
    IUsersService usersService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public IPage<TTaskModel> queryTaskList(Page<TTaskModel> objectPage, TaskQueryVo taskQueryVo) throws Exception{
        IPage<TTaskModel> taskModelIPage;
        try {
            taskModelIPage = this.baseMapper.selectTaskPage(objectPage,taskQueryVo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询任务列表出错:{}",e.getMessage());
            throw new AppException(500,"查询任务列表出错");
        }
        return taskModelIPage;
    }

    @Override
    public List<TTaskModel> selectSubTask(String taskId) throws Exception {
        List<TTaskModel> tTaskModels;
        try {
            tTaskModels = this.baseMapper.selectSubTaskList(taskId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询子任务列表出错:{}",e.getMessage());
            throw new AppException(500,"查询子任务列表出错");
        }
        return tTaskModels;
    }

    @Override
    public TaskModelResVo viewTaskDetail(String taskId) throws Exception {
        TTaskModel taskModel = this.baseMapper.selectById(taskId);
        TaskModelResVo taskModelResVo = new TaskModelResVo();
        BeanUtils.copyProperties(taskModel,taskModelResVo);
        //用户名查询作缓存  或做冗余字段
        taskModelResVo.setAssignName(usersService.getById(taskModel.getAssignId())==null?"":usersService.getById(taskModel.getAssignId()).getUserName());
        taskModelResVo.setLeaderName(usersService.getById(taskModel.getLeaderId())==null?"":usersService.getById(taskModel.getLeaderId()).getUserName());
        //参与人
        List<TaskModelResVo.User> users = Lists.newArrayList();
        //查询参与人
//        taskModelResVo.setAssignName();
//        taskModelResVo.setLeaderName();
        return taskModelResVo;
    }
}
