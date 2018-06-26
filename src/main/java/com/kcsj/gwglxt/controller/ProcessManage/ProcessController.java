package com.kcsj.gwglxt.controller.ProcessManage;

import com.kcsj.gwglxt.DTO.LoginCustom;
import com.kcsj.gwglxt.DTO.ProcessInfo;
import com.kcsj.gwglxt.entity.Process;
import com.kcsj.gwglxt.entity.ProcessNode;
import com.kcsj.gwglxt.service.processManage.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    //添加流程
    @RequestMapping("/addProcess")
    public String addProcess(@RequestBody Process process, HttpSession httpSession){
        String result;
        int addResult = 0;
        try {
            LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
            addResult = processService.addProcess(process,loginCustom);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
        if (addResult == 0) {
            result = "addFailed";
        }else{
            result = "addSuccess";
        }
        return "{\"msg\":\"" + result + "\"}";
    }
    //根据流程id查询流程节点详细信息
    @RequestMapping("/getProNodeByPro")
    public List<ProcessInfo> getProNodeByPro(String processId){
        List<ProcessInfo> processInfos = null;
        try {
            processInfos = processService.getProNodeByPro(processId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return processInfos;
    }
    //添加流程节点
    @RequestMapping("/addProcessNode")
    public String addProcessNode(@RequestBody ProcessNode processNode,HttpSession httpSession){
        String result;
        int addResult = 0;
        try {
            LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
            addResult = processService.addProcessNode(processNode,loginCustom);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
        if (addResult == 0) {
            result = "addFailed";
        }else{
            result = "addSuccess";
        }
        return "{\"msg\":\"" + result + "\"}";
    }
    //删除流程节点
    @RequestMapping("/deleteProcessNode")
    public String deleteProcessNode(String processNodeId,HttpSession httpSession){
        String result;
        int updateResult = 0;
        try {
            LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
            updateResult = processService.deleteProcessNode(processNodeId,loginCustom);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
        if (updateResult == 0) {
            result = "updateFailed";
        } else {
            result = "updateSuccess";
        }
        return "{\"msg\":\"" + result + "\"}";
    }
    //修改流程信息
    @RequestMapping("/updateProcessInfo")
    public String updateProcessInfo(@RequestBody Process process,HttpSession httpSession){
        String result;
        int updateResult = 0;
        try {
            LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
            updateResult = processService.updateProcessInfo(process,loginCustom);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
        if (updateResult == 0) {
            result = "addFailed";
        }else{
            result = "addSuccess";
        }
        return "{\"msg\":\"" + result + "\"}";
    }
    //删除流程
    @RequestMapping("/deleteProcess")
    public String deleteProcess(@RequestParam("ids[]") String[] ids,HttpSession httpSession){
        String result;
        int updateResult = 0;
        try {
            LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
            updateResult = processService.deleteProcess(ids,loginCustom);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
        if (updateResult == 0) {
            result = "updateFailed";
        } else {
            result = "updateSuccess";
        }
        return "{\"msg\":\"" + result + "\"}";
    }

}
