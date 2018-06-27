package com.kcsj.gwglxt.vo;

import com.kcsj.gwglxt.DTO.LoginCustom;

public class UserLogin {
   private String code;
   private LoginCustom loginCustom;

    public UserLogin() {
    }

    public UserLogin(String code, LoginCustom loginCustom) {
        this.code = code;
        this.loginCustom = loginCustom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LoginCustom getLoginCustom() {
        return loginCustom;
    }

    public void setLoginCustom(LoginCustom loginCustom) {
        this.loginCustom = loginCustom;
    }
}
