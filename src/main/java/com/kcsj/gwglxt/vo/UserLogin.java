package com.kcsj.gwglxt.vo;

import com.kcsj.gwglxt.entity.Guser;

import java.lang.reflect.Array;
import java.util.UUID;

public class UserLogin {
    String code;
    UUID token;
    String userId;
    String userName;
    String userPassword;
    String userPicture;
    Integer permissionLevel;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public Integer getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(Integer permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "code='" + code + '\'' +
                ", token=" + token +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPicture='" + userPicture + '\'' +
                ", permissionLevel=" + permissionLevel +
                '}';
    }
}
