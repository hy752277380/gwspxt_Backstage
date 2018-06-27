package com.kcsj.gwglxt.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-06-08
 */
public class Permission {
    private String permissionId;

    private Integer permissionLevel;

    private String permissionRemark;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    public Integer getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(Integer permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public String getPermissionRemark() {
        return permissionRemark;
    }

    public void setPermissionRemark(String permissionRemark) {
        this.permissionRemark = permissionRemark == null ? null : permissionRemark.trim();
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId='" + permissionId + '\'' +
                ", permissionLevel=" + permissionLevel +
                ", permissionRemark='" + permissionRemark + '\'' +
                '}';
    }
}