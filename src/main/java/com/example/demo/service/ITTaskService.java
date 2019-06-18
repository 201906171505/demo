package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.TTaskModel;
import com.example.demo.vo.TaskModelResVo;
import com.example.demo.vo.TaskQueryVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xl
 * @since 2019-05-30
 */
public interface ITTaskService extends IService<TTaskModel> {

    IPage<TTaskModel> queryTaskList(Page<TTaskModel> objectPage, TaskQueryVo taskQueryVo) throws Exception;

    List<TTaskModel> selectSubTask(String taskId) throws Exception;

    TaskModelResVo viewTaskDetail(String taskId) throws Exception;
}
