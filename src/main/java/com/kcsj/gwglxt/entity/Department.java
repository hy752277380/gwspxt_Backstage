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

    private String departmentSuperior;

    private int memberCount;

    private String siperiorName;

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

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

    public String getDepartmentSuperior() {
        return departmentSuperior;
    }

    public void setDepartmentSuperior(String departmentSuperior) {
        this.departmentSuperior = departmentSuperior;
    }

    public String getSiperiorName() {
        return siperiorName;
    }

    public void setSiperiorName(String siperiorName) {
        this.siperiorName = siperiorName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentPhone='" + departmentPhone + '\'' +
                ", departmentIsdelete=" + departmentIsdelete +
                ", memberCount=" + memberCount +
                '}';
    }
}