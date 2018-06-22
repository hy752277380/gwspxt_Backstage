package com.kcsj.gwglxt.service.processManage;

import com.kcsj.gwglxt.DTO.ProcessInfo;
import com.kcsj.gwglxt.entity.Process;

import java.util.List;

public interface ProcessService {
    //根据流程id查询流程节点详细信息
    List<ProcessInfo> getProNodeByPro(String processId);
    /*//获取所有流程
    List<Process> getAllProcess();*/
}
