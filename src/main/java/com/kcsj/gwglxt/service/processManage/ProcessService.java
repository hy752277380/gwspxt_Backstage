package com.kcsj.gwglxt.service.processManage;

import com.kcsj.gwglxt.DTO.ProcessInfo;
import com.kcsj.gwglxt.entity.Process;
import com.kcsj.gwglxt.entity.ProcessNode;

import java.util.List;

public interface ProcessService {
    //根据流程id查询流程节点详细信息
    List<ProcessInfo> getProNodeByPro(String processId);
    //添加流程节点
    int addProcessNode(ProcessNode processNode);
    //删除流程节点
    int deleteProcessNode(String processNodeId);
    //删除流程
    int deleteProcess(String[] ids);
    //修改流程信息
    int updateProcessInfo(Process process);

    int addProcess(Process process);
    /*//获取所有流程
    List<Process> getAllProcess();*/
}
