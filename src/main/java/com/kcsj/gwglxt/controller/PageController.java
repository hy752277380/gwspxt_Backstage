package com.kcsj.gwglxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "page-login.html";
    }

    //登录页面
   /* @GetMapping("/login")
    public String login() {
        return "login.html";
    }*/

    //登录2页面
    @GetMapping("/login")
    public String login2() {
        return "page-login.html";
    }

    //首页
    @GetMapping("/index")
    public String indexPage() {
        return "index.html";
    }

    //个人信息页面
    @RequestMapping("/information")
    public String infomation() {
        return "information.html";
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

    //查看文档详细界面
    @RequestMapping("/reviewDetailDocument")
    public String reviewDetailDocument() {
        return "reviewDetailDocument.html";
    }

    //查看文档详细界面
    @RequestMapping("/editDetailDocument")
    public String editDetailDocument() {
        return "editDetailDocument.html";
    }

    /*部门成员管理*/
    @RequestMapping("/departmentMemberManage")
    public String departmentMemberManage() {
        return "departmentMemberManage.html";
    }

    /*成员管理中查看成员文档*/
    @RequestMapping("/reviewPersonDocument")
    public String reviewPersonDocument() {
        return "departmentMemberManage/reviewPersonDocument.html";
    }

    /*成员管理中查看成员日志*/
    @RequestMapping("/reviewPersonJournal")
    public String reviewPersonJournal() {
        return "departmentMemberManage/reviewPersonJournal.html";
    }

    /*查看文本内容*/
    @RequestMapping("/reviewContent")
    public String reviewContent() {
        return "reviewContent.html";
    }
}

