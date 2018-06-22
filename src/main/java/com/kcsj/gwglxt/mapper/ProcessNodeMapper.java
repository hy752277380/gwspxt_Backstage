package com.kcsj.gwglxt.mapper;

import com.kcsj.gwglxt.entity.Department;
import com.kcsj.gwglxt.entity.Position;
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

    //获取当前流程最后一步
    int getMaxStep(String processNodeProcess);
    //利用当前文档所走流程和流程子节点步骤锁定下一个流程节点操作人所在的部门和所需要的职位
    ProcessNode getNextOne(@Param("processNodeProcess")String processNodeProcess,@Param("processNodeStep")Integer processNodeStep);
    //查询该文档所走流程的每一个流程节点
    List<ProcessNode> getAllProcessNode(String processNodeProcess);

    List<ProcessNode> getProcessNodeByUser(@Param("processNodeDepartment") String processNodeDepartment,@Param("processNodePosition") String processNodePosition);

    List<ProcessNode> getProcessNodeByPro(String process);
}