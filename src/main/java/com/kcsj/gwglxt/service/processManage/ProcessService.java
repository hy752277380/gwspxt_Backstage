package com.kcsj.gwglxt.service.processManage;

import com.kcsj.gwglxt.DTO.LoginCustom;
import com.kcsj.gwglxt.DTO.ProcessInfo;
import com.kcsj.gwglxt.entity.Process;
import com.kcsj.gwglxt.entity.ProcessNode;

import java.util.List;

public interface ProcessService {
    //根据流程id查询流程节点详细信息
    List<ProcessInfo> getProNodeByPro(String processId);
    //添加流程节点
    int addProcessNode(ProcessNode processNode,LoginCustom loginCustom);
    //删除流程节点
    int deleteProcessNode(String processNodeId,LoginCustom loginCustom);
    //删除流程
    int deleteProcess(String[] ids,LoginCustom loginCustom);
    //修改流程信息
    int updateProcessInfo(Process process,LoginCustom loginCustom);

    int addProcess(Process process, LoginCustom loginCustom);

    boolean getProcessByName(String processName);
    /*//获取所有流程
    List<Process> getAllProcess();*/
}
