package com.kcsj.gwglxt.controller;

import com.kcsj.gwglxt.entity.manage;
import com.kcsj.gwglxt.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @RequestMapping("/index")
    public List<manage> myTest(){
      return  myService.myTest();
    }

    @RequestMapping("/index2")
    public manage getId(){
        return myService.getOne();
    }
}
