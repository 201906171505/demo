package com.example.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.ResponseBean;
import com.example.demo.model.TTaskModel;
import com.example.demo.service.ITTaskService;
import com.example.demo.vo.TaskModelResVo;
import com.example.demo.vo.TaskQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xl
 * @since 2019-05-30
 */
@Api(tags = "任务接口")
@RestController
@RequestMapping("/task")
public class TTaskController {

    @Autowired
    ITTaskService taskService;

    @PostMapping("/list")
    @ApiOperation(value="查询任务列表", notes="查询任务列表")
    public ResponseBean queryTaskList(@RequestBody TaskQueryVo taskQueryVo,@RequestParam("page") int page,@RequestParam("pageSize") int pageSize) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        IPage<TTaskModel> datas = taskService.queryTaskList(new Page<>(page, pageSize),taskQueryVo);
        responseBean.setData(datas);
        responseBean.setMessage("查询任务列表完毕");
        responseBean.setCode(200);
        return responseBean;
    }


    @GetMapping("/viewSub")
    @ApiOperation(value="查看子任务", notes="查看子任务")
    public ResponseBean viewSubTask(@RequestParam("taskId") String taskId) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        List<TTaskModel> datas = taskService.selectSubTask(taskId);
        responseBean.setData(datas);
        responseBean.setMessage("查询子任务列表完毕");
        responseBean.setCode(200);
        return responseBean;
    }


    @GetMapping("/viewTaskDetail")
    @ApiOperation(value="查看任务详情", notes="查看任务详情")
    public ResponseBean viewTaskDetail(@RequestParam("taskId") String taskId) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        TaskModelResVo taskModelResVo = taskService.viewTaskDetail(taskId);
        responseBean.setData(taskModelResVo);
        responseBean.setMessage("查询子任务列表完毕");
        responseBean.setCode(200);
        return responseBean;
    }






}

