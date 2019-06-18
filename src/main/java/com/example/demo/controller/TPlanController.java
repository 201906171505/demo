package com.example.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.ResponseBean;
import com.example.demo.model.TPlanModel;
import com.example.demo.service.ITPlanService;
import com.example.demo.vo.TaskModelVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xl
 * @since 2019-05-30
 */
@Api(tags = "计划接口")
@RestController
@RequestMapping("/plan")
public class TPlanController {
    @Autowired
    ITPlanService itPlanService;


    @PostMapping("/save")
    @ApiOperation(value="计划新增", notes="添加计划")
    public ResponseBean savePlan(TPlanModel planModel) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        itPlanService.savePlan(planModel);
        responseBean.setMessage("新增成功");
        responseBean.setCode(200);
        return responseBean;
    }

    @PutMapping("/update")
    @ApiOperation(value="计划修改", notes="对计划进行修改")
    public ResponseBean updatePlan(TPlanModel planModel) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        itPlanService.updatePlan(planModel);
        responseBean.setMessage("修改成功");
        responseBean.setCode(200);
        return responseBean;
    }


    @PostMapping("/list")
    @ApiOperation(value="查询计划", notes="查询计划列表")
    public ResponseBean selectPlanList(@RequestBody TPlanModel planModel,@RequestParam("page") int page,@RequestParam("pageSize") int pageSize) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        IPage<TPlanModel> datas = itPlanService.selectPlanList(new Page<>(page, pageSize),planModel);
        responseBean.setMessage("查询成功返回");
        responseBean.setCode(200);
        responseBean.setData(datas);
        return responseBean;
    }

    @PostMapping("/makeTask")
    @ApiOperation(value="安排任务", notes="安排任务")
    public ResponseBean makeTask(@RequestBody TaskModelVo taskModelVo) throws Exception{
        ResponseBean responseBean = new ResponseBean();
        //做参数校验
        String taskId = itPlanService.makeTask(taskModelVo);
        responseBean.setMessage("安排任务成功");
        responseBean.setCode(200);
        responseBean.setData(taskId);
        return responseBean;
    }






}

