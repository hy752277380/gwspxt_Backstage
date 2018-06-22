package com.kcsj.gwglxt.controller.ProcessManage;

import com.kcsj.gwglxt.DTO.ProcessInfo;
import com.kcsj.gwglxt.entity.Process;
import com.kcsj.gwglxt.entity.ProcessNode;
import com.kcsj.gwglxt.service.processManage.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("/addProcessNode")
    public String addProcessNode(@RequestBody ProcessNode processNode){
        String result;
        int addResult = processService.addProcessNode(processNode);
        //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
        if (addResult == 0) {
            result = "addFailed";
        }else{
            result = "addSuccess";
        }
        return result;
    }
    //删除流程节点
    @RequestMapping("/deleteProcessNode/{processNodeId}")
    public String deleteProcessNode(@PathVariable("processNodeId") String processNodeId){
        String result;
        int updateResult = processService.deleteProcessNode(processNodeId);
        //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
        if (updateResult == 0) {
            result = "updateFailed";
        } else {
            result = "updateSuccess";
        }
        return "{\"msg\":\"" + result + "\"}";
    }
    //修改流程信息
    //删除流程
    @RequestMapping("/deleteProcess")
    public String deleteProcess(String ids[]){
        String result;
        int updateResult = processService.deleteProcess(ids);
        //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
        if (updateResult == 0) {
            result = "updateFailed";
        } else {
            result = "updateSuccess";
        }
        return "{\"msg\":\"" + result + "\"}";
    }

}
