package com.kcsj.gwglxt.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-06-08
 */
public class Position {
    private String positionId;

    private String positionDept;

    private String positionPermission;

    private String positionName;

    private Integer positionIsdelete;

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId == null ? null : positionId.trim();
    }

    public String getPositionDept() {
        return positionDept;
    }

    public void setPositionDept(String positionDept) {
        this.positionDept = positionDept == null ? null : positionDept.trim();
    }

    public String getPositionPermission() {
        return positionPermission;
    }

    public void setPositionPermission(String positionPermission) {
        this.positionPermission = positionPermission == null ? null : positionPermission.trim();
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
    }


    public Integer getPositionIsdelete() {
        return positionIsdelete;
    }

    public void setPositionIsdelete(Integer positionIsdelete) {
        this.positionIsdelete = positionIsdelete;
    }
}