package com.kcsj.gwglxt.controller;

import com.kcsj.gwglxt.DTO.CountByMouth;
import com.kcsj.gwglxt.entity.Guser;
import com.kcsj.gwglxt.DTO.LoginCustom;
import com.kcsj.gwglxt.entity.Position;
import com.kcsj.gwglxt.service.GuserService;
import com.kcsj.gwglxt.util.md5;
import com.kcsj.gwglxt.vo.QueryForPage;
import com.kcsj.gwglxt.vo.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class GuserController {
    @Autowired
    private GuserService guserService;

    //根据id查询用户表
    @RequestMapping("/index3")
    public Guser selectByPrimaryKey() {
        return guserService.selectByPrimaryKey("15478012");
    }

    //根据id查询用户基本信息
    @RequestMapping("/index4")
    public String loginInfo() {
        if (guserService.loginInfo("154780") == null) {
            return "没有获取";
        }
        return "qudaole";
    }
    //定义的用户登录方法

    @Override
    public String toString() {
        return "GuserController{" +
                "guserService=" + guserService +
                '}';
    }

    @RequestMapping("/login/{userAccount}/{userPassword}")
    public UserLogin login(@PathVariable("userAccount") String userAccount, @PathVariable("userPassword") String userPassword, HttpSession httpSession) {
        LoginCustom loginCustom = guserService.loginFunction(userAccount);
        if (loginCustom == null) {
            //"用户名不存在";
            return new UserLogin("20001", null);
        }
        //将密码加密比对
        if (md5.GetMD5Code(userPassword).equals(loginCustom.getGuser().getUserPassword())) {
            //"密码正确";
            //存入用户信息到session
            httpSession.setAttribute("LoginInformation", loginCustom);
            return new UserLogin("20000", loginCustom);
        } else {
            // "密码错误";
            return new UserLogin("20002", null);
        }
    }

    //获取用户信息的方法
    @RequestMapping("/getUserInfo")
    public LoginCustom getLoginInfo(HttpSession httpSession, HttpServletResponse response) {
        LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
        return loginCustom;
    }

    //获取个人信息
    @RequestMapping("/personalInfo")
    public LoginCustom getPersonalInfo(HttpSession httpSession) {
        //获取session内容
        LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
        LoginCustom personalInfo = guserService.getPersonalInfo(loginCustom.getGuser().getUserId());
        return personalInfo;
    }
    //登出
    @RequestMapping("/loginout")
    public String loginout(){
        return "";
    }
    //登陆检测
    public boolean LoginInterceptor (HttpSession httpSession){
        //获取session内容
        LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
        if(loginCustom==null){

            return false;
        }return true;
    }
    /************************************首页数据*******************************/
    //首页月份人数统计
    @RequestMapping("/countUserByMouth")
    public CountByMouth countUserByMouth(){
        CountByMouth countByMouth = guserService.countUserByMouth();
        return countByMouth;
    }

    //计算总人数
    @RequestMapping("/countAllUser")
    public int countAllUser(){
        int result = guserService.countAllUser();
        return result;
    }

    //计算总数文档
    @RequestMapping("/countAllDocument")
    public int countAllDocument(){
        String department = null;
        String user = null;
        int result = guserService.countAllDocument(department,user);
        return result;
    }

    //计算部门文档
    @RequestMapping("/countDptDocument")
    public int countDptDocument(HttpSession httpSession){
        //获取session内容
        LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
        String department = loginCustom.getGuser().getUserDepartment();
        String user = null;
        int result = guserService.countAllDocument(department,user);
        return result;
    }

    //计算个人文档
    @RequestMapping("/countPersonalDocument")
    public int countPersonalDocument(HttpSession httpSession){
        //获取session内容
        LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
        String department = null;
        String user = loginCustom.getGuser().getUserId();
        int result = guserService.countAllDocument(department,user);
        return result;
    }
    //计算月份文档数
    @RequestMapping("/countDocumentByMouth")
    public CountByMouth countDocumentByMouth(){
        CountByMouth countByMouth = guserService.countDocumentByMouth();
        return countByMouth;
    }
    //部门文档月份统计
    @RequestMapping("/countDptDocumentByMouth")
    public CountByMouth countDptDocumentByMouth(HttpSession httpSession){
        //获取session内容
        LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
        CountByMouth countByMouth = guserService.countDptDocumentByMouth(loginCustom.getGuser().getUserDepartment());
        return countByMouth;
    }
    //个人文档月份统计
    @RequestMapping("/countPersonalDocumentByMouth")
    public CountByMouth countPersonalDocumentByMouth(HttpSession httpSession){
        //获取session内容
        LoginCustom loginCustom = (LoginCustom) httpSession.getAttribute("LoginInformation");
        CountByMouth countByMouth = guserService.countPersonalDocumentByMouth(loginCustom.getGuser().getUserId());
        return countByMouth;
    }
    /***************************8账号管理*******************************/
    //列出所有账号
    @RequestMapping("/getAllUser")
    public QueryForPage getAllUser(int currentPage){
        QueryForPage users = guserService.getAllUser(currentPage);
        return users;
    }
    //添加账号
    @RequestMapping("/andUser")
    public String andUser(Guser guser){
        String result;
        int insertResult = guserService.insert(guser);
        //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
        if (insertResult == 0) {
            result = "updateFailed";
        }
        result = "updateSuccess";
        return result;
    }
    //根据部门查询本部门职位
    @RequestMapping("/getPositionByDpt/{department}")
    public List<Position> getPositionByDpt(@PathVariable("department") String department){
        List<Position> positions = guserService.getPositionByDpt(department);
        return positions;
    }
}

