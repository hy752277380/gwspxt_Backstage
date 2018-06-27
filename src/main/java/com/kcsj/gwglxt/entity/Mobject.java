package com.kcsj.gwglxt.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-06-10
 */
public class Mobject {
    private String mobjectId;

    private String mobjectUser;

    private String mobjectMessage;

    private Integer mobjectIsread;

    public String getMobjectId() {
        return mobjectId;
    }

    public void setMobjectId(String mobjectId) {
        this.mobjectId = mobjectId == null ? null : mobjectId.trim();
    }

    public String getMobjectUser() {
        return mobjectUser;
    }

    public void setMobjectUser(String mobjectUser) {
        this.mobjectUser = mobjectUser == null ? null : mobjectUser.trim();
    }

    public String getMobjectMessage() {
        return mobjectMessage;
    }

    public void setMobjectMessage(String mobjectMessage) {
        this.mobjectMessage = mobjectMessage == null ? null : mobjectMessage.trim();
    }

    public Integer getMobjectIsread() {
        return mobjectIsread;
    }

    public void setMobjectIsread(Integer mobjectIsread) {
        this.mobjectIsread = mobjectIsread;
    }
}