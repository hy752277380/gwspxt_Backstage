package com.kcsj.gwglxt.controller.ProcessManage;

import com.kcsj.gwglxt.DTO.ProcessInfo;
import com.kcsj.gwglxt.entity.Process;
import com.kcsj.gwglxt.service.processManage.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProcessController {
    @Autowired
    private ProcessService processService;

    /********************************8流程管理******************************/
    /*//获得所有流程
    @RequestMapping("/getAllProcess")
    public List<Process> getAllProcess(){
        List<Process> processes = processService.getAllProcess();
        return processes;
    }*/
    //根据流程id查询流程节点详细信息
    @RequestMapping("/getProNodeByPro")
    public List<ProcessInfo> getProNodeByPro(String processId){
        List<ProcessInfo> processInfos = processService.getProNodeByPro(processId);
        return processInfos;
    }
    //添加流程节点
    //删除流程节点
    //修改流程信息
    //删除流程

}
