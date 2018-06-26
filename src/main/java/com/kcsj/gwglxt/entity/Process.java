package com.kcsj.gwglxt.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-06-10
 */
public class Process {
    private String processId;

    private String processIntroduction;

    private String processName;

    private Integer processIsdelete;

    public Integer getProcessIsdelete() {
        return processIsdelete;
    }

    public void setProcessIsdelete(Integer processIsdelete) {
        this.processIsdelete = processIsdelete;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    public String getProcessIntroduction() {
        return processIntroduction;
    }

    public void setProcessIntroduction(String processIntroduction) {
        this.processIntroduction = processIntroduction == null ? null : processIntroduction.trim();
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName == null ? null : processName.trim();
    }
}