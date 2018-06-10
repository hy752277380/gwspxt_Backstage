package com.kcsj.gwglxt.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-06-10
 */
public class ProcessNode {
    private String processNodeId;

    private String processNodeProcess;

    private String processNodeName;

    private String processNodeDepartment;

    private String processNodePosition;

    private Integer processNodeStep;

    private Integer processNodeIsdelete;

    public String getProcessNodeId() {
        return processNodeId;
    }

    public void setProcessNodeId(String processNodeId) {
        this.processNodeId = processNodeId == null ? null : processNodeId.trim();
    }

    public String getProcessNodeProcess() {
        return processNodeProcess;
    }

    public void setProcessNodeProcess(String processNodeProcess) {
        this.processNodeProcess = processNodeProcess == null ? null : processNodeProcess.trim();
    }

    public String getProcessNodeName() {
        return processNodeName;
    }

    public void setProcessNodeName(String processNodeName) {
        this.processNodeName = processNodeName == null ? null : processNodeName.trim();
    }

    public String getProcessNodeDepartment() {
        return processNodeDepartment;
    }

    public void setProcessNodeDepartment(String processNodeDepartment) {
        this.processNodeDepartment = processNodeDepartment == null ? null : processNodeDepartment.trim();
    }

    public String getProcessNodePosition() {
        return processNodePosition;
    }

    public void setProcessNodePosition(String processNodePosition) {
        this.processNodePosition = processNodePosition == null ? null : processNodePosition.trim();
    }

    public Integer getProcessNodeStep() {
        return processNodeStep;
    }

    public void setProcessNodeStep(Integer processNodeStep) {
        this.processNodeStep = processNodeStep;
    }

    public Integer getProcessNodeIsdelete() {
        return processNodeIsdelete;
    }

    public void setProcessNodeIsdelete(Integer processNodeIsdelete) {
        this.processNodeIsdelete = processNodeIsdelete;
    }
}