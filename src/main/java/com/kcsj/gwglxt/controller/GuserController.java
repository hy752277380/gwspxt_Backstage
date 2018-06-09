package com.kcsj.gwglxt.controller;

import com.kcsj.gwglxt.entity.Guser;
import com.kcsj.gwglxt.entity.loginCustom;
import com.kcsj.gwglxt.service.GuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public loginCustom loginInfo(){
        return guserService.loginInfo("15478012");
    }
}
