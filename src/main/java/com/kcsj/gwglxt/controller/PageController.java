package com.kcsj.gwglxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
//登录页面
@RequestMapping("/login")
public String login() {
    return "login.html";
}
    //个人信息页面
    @RequestMapping("/infomation")
    public String infomation() {
        return "infomation.html";
    }
    //文档查看页面
    @RequestMapping("/reviewDocument")
    public String reviewDocument() {
        return "reviewDocument.html";
    }
    //文档管理页面
    @RequestMapping("/documentManage")
    public String documentManage() {
        return "documentManage.html";
    }
    //批阅申请页面
    @RequestMapping("/approvalApplication")
    public String approvalApplication() {
        return "approvalApplication.html";
    }
    //流程管理页面
    @RequestMapping("/processManagement")
    public String processManagement() {
        return "processManagement.html";
    }
    //流程节点页面
    @RequestMapping("/processNode")
    public String processNode() {
        return "processNode.html";
    }
    //帐号管理页面
    @RequestMapping("/accountManagement")
    public String accountManagement() {
        return "accountManagement.html";
    }
    //部门管理页面
    @RequestMapping("/departmentManagement")
    public String departmentManagement() {
        return "departmentManagement.html";
    }
    //职称管理页面
    @RequestMapping("/departmentPosition")
    public String departmentPosition() {
        return "departmentPosition.html";
    }
}
