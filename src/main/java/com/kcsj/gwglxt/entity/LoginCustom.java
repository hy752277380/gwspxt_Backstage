package com.kcsj.gwglxt.entity;

public class LoginCustom {

    private Guser guser;

    private Department department;

    private  Position position;

    private  Permission permission;

    public Guser getGuser() {
        return guser;
    }

    public Department getDepartment() {
        return department;
    }

    public Position getPosition() {
        return position;
    }

    public Permission getPermission() {
        return permission;
    }


    public void setGuser(Guser guser) {
        this.guser = guser;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

}
