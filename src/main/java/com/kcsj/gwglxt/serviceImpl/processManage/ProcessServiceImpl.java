package com.kcsj.gwglxt.serviceImpl.processManage;

import com.kcsj.gwglxt.DTO.ProcessInfo;
import com.kcsj.gwglxt.entity.Process;
import com.kcsj.gwglxt.entity.ProcessNode;
import com.kcsj.gwglxt.mapper.ProcessMapper;
import com.kcsj.gwglxt.mapper.ProcessNodeMapper;
import com.kcsj.gwglxt.service.processManage.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    private ProcessMapper processMapper;
    @Autowired
    private ProcessNodeMapper processNodeMapper;

    //根据流程id查询流程节点详细信息
    @Override
    public List<ProcessInfo> getProNodeByPro(String processId) {
        return processNodeMapper.getProNodeByPro(processId);
    }
    /*//获取所有流程
    @Override
    public List<Process> getAllProcess() {
        return processMapper.getAllProcess();
    }*/
}
