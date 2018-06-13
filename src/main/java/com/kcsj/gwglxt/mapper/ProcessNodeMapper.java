package com.kcsj.gwglxt.mapper;

import com.kcsj.gwglxt.entity.ProcessNode;
import com.kcsj.gwglxt.entity.ProcessNodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessNodeMapper {
    int countByExample(ProcessNodeExample example);

    int deleteByExample(ProcessNodeExample example);

    int deleteByPrimaryKey(String processNodeId);

    int insert(ProcessNode record);

    int insertSelective(ProcessNode record);

    List<ProcessNode> selectByExample(ProcessNodeExample example);

    ProcessNode selectByPrimaryKey(String processNodeId);

    int updateByExampleSelective(@Param("record") ProcessNode record, @Param("example") ProcessNodeExample example);

    int updateByExample(@Param("record") ProcessNode record, @Param("example") ProcessNodeExample example);

    int updateByPrimaryKeySelective(ProcessNode record);

    int updateByPrimaryKey(ProcessNode record);

    //根据id获取当前流程最后一步
    int getMaxStep(String processNodeProcess);
}