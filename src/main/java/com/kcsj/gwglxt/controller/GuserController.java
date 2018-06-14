package com.kcsj.gwglxt.controller;

import com.kcsj.gwglxt.entity.Guser;
import com.kcsj.gwglxt.DTO.LoginCustom;
import com.kcsj.gwglxt.service.GuserService;
import com.kcsj.gwglxt.util.md5;
import com.kcsj.gwglxt.vo.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:9528")
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
    public String loginInfo(){
        if (guserService.loginInfo("154780")==null){
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

    @RequestMapping("/index5/{userAccount}/{userPassword}")
    public String login(@PathVariable("userAccount") String userAccount,@PathVariable("userPassword") String userPassword, HttpSession httpSession ) {
        String msg;
        UserLogin userLogin = new UserLogin();
        //生成随机数
        userLogin.setToken(UUID.randomUUID());
        if (guserService.loginFunction(userAccount)==null){
            msg = "用户名不存在";
            userLogin.setCode("20001");
            System.out.println(msg);
            /*httpSession.setAttribute("Token", userLogin.getToken());
            httpSession.setAttribute("userLogin", userLogin);*/
            return "\n" +
                    "            \"code\": " + userLogin.getCode() + ",\n" +
                    "                \"data\": {\n" +
                    "            \"token\": \"" + userLogin.getToken() + "\"\n" +
                    "        }";
        }
        LoginCustom loginCustom = guserService.loginFunction(userAccount);
        //将密码加密比对
        if ( md5.GetMD5Code(userPassword).equals(loginCustom.getGuser().getUserPassword())) {
                userLogin.setCode("20000");
                userLogin.setUserName(loginCustom.getGuser().getUserName());
                userLogin.setUserId(loginCustom.getGuser().getUserId());
                userLogin.setPermissionLevel(loginCustom.getPermission().getPermissionLevel());
                userLogin.setUserPicture(loginCustom.getGuser().getUserPicture());
                msg = "密码正确";
                System.out.println(msg);
                //存入用户信息到session
                httpSession.setAttribute("LoginInfomation",loginCustom);
                return "{\n" +
                        "  \"code\": " + userLogin.getCode() + ",\n" +
                        "  \"data\": {\n" +
                        "    \"roles\": [\"" + userLogin.getPermissionLevel() + "\"],\n" +
                        "    \"name\": \"" + userLogin.getUserId() + "\",\n" +
                        "    \"avatar\": \"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif \n" +
                        "\n" +
                        "\"\n" +
                        "  }\n" +
                        "}";
            } else {
                userLogin.setUserId(loginCustom.getGuser().getUserId());
                userLogin.setCode("20002");
                msg = "密码错误";
                System.out.println(msg);
                return "{\n" +
                        "  \"code\": "+userLogin.getCode()+",\n" +
                        "  \"data\": {\n" +
                        "    \"token\": \""+userLogin.getToken()+"\"\n" +
                        "  }\n" +
                        "}";
            }
    }
    //获取用户信息的方法
    @RequestMapping("/index6")
    public String getLoginInfo( HttpSession httpSession, HttpServletResponse response){
        LoginCustom loginCustom = (LoginCustom)httpSession.getAttribute("LoginInfomation");
        UserLogin userLogin = new UserLogin();
        userLogin.setCode("20002");
        userLogin.setUserId(loginCustom.getGuser().getUserId());
        userLogin.setPermissionLevel(loginCustom.getPermission().getPermissionLevel());
        userLogin.setUserPicture(loginCustom.getGuser().getUserPicture());
        System.out.println(" 111  ");
        return "{\n" +
                "  \"code\": " + userLogin.getCode() + ",\n" +
                "  \"data\": {\n" +
                "    \"roles\": [\"" + userLogin.getPermissionLevel() + "\"],\n" +
                "    \"name\": \"" + userLogin.getUserId() + "\",\n" +
                "    \"avatar\": \"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif \n" +
                "\n" +
                "\"\n" +
                "  }\n" +
                "}";
    }
}

