package com.kcsj.gwglxt.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-06-08
 */
public class Department {
    private String departmentId;

    private String departmentName;

    private String departmentPhone;

    private Integer departmentIsdelete;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getDepartmentPhone() {
        return departmentPhone;
    }

    public void setDepartmentPhone(String departmentPhone) {
        this.departmentPhone = departmentPhone == null ? null : departmentPhone.trim();
    }

    public Integer getDepartmentIsdelete() {
        return departmentIsdelete;
    }

    public void setDepartmentIsdelete(Integer departmentIsdelete) {
        this.departmentIsdelete = departmentIsdelete;
    }
}