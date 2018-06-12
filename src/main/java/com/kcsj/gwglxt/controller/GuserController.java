package com.kcsj.gwglxt.controller;

import com.kcsj.gwglxt.entity.Guser;
import com.kcsj.gwglxt.entity.LoginCustom;
import com.kcsj.gwglxt.service.GuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class GuserController {
    @Autowired
    private GuserService guserService;
    //根据id查询用户表
    @RequestMapping("/index3")
    public Guser selectByPrimaryKey(){
        return guserService.selectByPrimaryKey("15478012");
    }
    //根据id查询用户基本信息
    @RequestMapping("/index4")
    public LoginCustom loginInfo(){

        return guserService.loginInfo("15478012");
    }
    @RequestMapping("/index5")
    public  LoginCustom loginFunction(String userAccount, String userPassword, HttpSession httpSession, HttpServletResponse response ){
       /* LoginCustom loginCustom=

        if (userPassword.equals(loginCustom.getGuser().setUserPassword()){

        }*/

        return guserService.loginFunction("15478020");

    }
    /*@RequestMapping()
    public LoginCustom loginFunction(String userAccount, String userPassword){
        String return=null;

    }*/

    @RequestMapping("/testnnn")
    public String sss(){
        return "sssssssss";
    }
}
