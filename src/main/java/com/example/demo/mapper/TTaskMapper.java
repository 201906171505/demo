package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.model.TTaskModel;
import com.example.demo.vo.TaskQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xl
 * @since 2019-05-30
 */
public interface TTaskMapper extends BaseMapper<TTaskModel> {

    IPage<TTaskModel> selectTaskPage(Page<TTaskModel> objectPage,@Param("tv") TaskQueryVo taskQueryVo);

    List<TTaskModel> selectSubTaskList(@Param("taskPid") String taskId);

}
