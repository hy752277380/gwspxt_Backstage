package com.kcsj.gwglxt.mapper;

import com.kcsj.gwglxt.entity.ProcessExample;
import com.kcsj.gwglxt.entity.Process;
import java.util.List;

import com.kcsj.gwglxt.entity.ProcessNode;
import org.apache.ibatis.annotations.Param;

public interface ProcessMapper {
    int countByExample(ProcessExample example);

    int deleteByExample(ProcessExample example);

    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    List<Process> selectByExample(ProcessExample example);

    Process selectByPrimaryKey(String processId);

    int updateByExampleSelective(@Param("record") Process record, @Param("example") ProcessExample example);

    int updateByExample(@Param("record") Process record, @Param("example") ProcessExample example);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    List<Process> getAllProcess();

    List<Process> getProcessByName(@Param("processName") String processName);
}