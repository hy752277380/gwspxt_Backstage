package com.kcsj.gwglxt.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-06-10
 */
public class Document {
    private String documentId;

    private String documentTitle;

    private String documentType;

    private String documentNo;

    private String documentDept;

    private String documentUser;

    private Integer documentConfidential;

    private String doucmentContent;

    private String documentRemark;

    private String documentProcess;

    private Integer documentLocation;

    private String documentProcessBegin;

    private String documentProcessFinish;

    private Integer documentState;

    private Integer documentSpeed;

    private String creationTime;

    private Integer documentIsdelete;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId == null ? null : documentId.trim();
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle == null ? null : documentTitle.trim();
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType == null ? null : documentType.trim();
    }

    public String getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo == null ? null : documentNo.trim();
    }

    public String getDocumentDept() {
        return documentDept;
    }

    public void setDocumentDept(String documentDept) {
        this.documentDept = documentDept == null ? null : documentDept.trim();
    }

    public String getDocumentUser() {
        return documentUser;
    }

    public void setDocumentUser(String documentUser) {
        this.documentUser = documentUser == null ? null : documentUser.trim();
    }

    public Integer getDocumentConfidential() {
        return documentConfidential;
    }

    public void setDocumentConfidential(Integer documentConfidential) {
        this.documentConfidential = documentConfidential;
    }

    public String getDoucmentContent() {
        return doucmentContent;
    }

    public void setDoucmentContent(String doucmentContent) {
        this.doucmentContent = doucmentContent == null ? null : doucmentContent.trim();
    }

    public String getDocumentRemark() {
        return documentRemark;
    }

    public void setDocumentRemark(String documentRemark) {
        this.documentRemark = documentRemark == null ? null : documentRemark.trim();
    }

    public String getDocumentProcess() {
        return documentProcess;
    }

    public void setDocumentProcess(String documentProcess) {
        this.documentProcess = documentProcess == null ? null : documentProcess.trim();
    }

    public Integer getDocumentLocation() {
        return documentLocation;
    }

    public void setDocumentLocation(Integer documentLocation) {
        this.documentLocation = documentLocation;
    }

    public String getDocumentProcessBegin() {
        return documentProcessBegin;
    }

    public void setDocumentProcessBegin(String documentProcessBegin) {
        this.documentProcessBegin = documentProcessBegin == null ? null : documentProcessBegin.trim();
    }

    public String getDocumentProcessFinish() {
        return documentProcessFinish;
    }

    public void setDocumentProcessFinish(String documentProcessFinish) {
        this.documentProcessFinish = documentProcessFinish == null ? null : documentProcessFinish.trim();
    }

    public Integer getDocumentState() {
        return documentState;
    }

    public void setDocumentState(Integer documentState) {
        this.documentState = documentState;
    }

    public Integer getDocumentSpeed() {
        return documentSpeed;
    }

    public void setDocumentSpeed(Integer documentSpeed) {
        this.documentSpeed = documentSpeed;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentId='" + documentId + '\'' +
                ", documentTitle='" + documentTitle + '\'' +
                ", documentType='" + documentType + '\'' +
                ", documentNo='" + documentNo + '\'' +
                ", documentDept='" + documentDept + '\'' +
                ", documentUser='" + documentUser + '\'' +
                ", documentConfidential=" + documentConfidential +
                ", doucmentContent='" + doucmentContent + '\'' +
                ", documentRemark='" + documentRemark + '\'' +
                ", documentProcess='" + documentProcess + '\'' +
                ", documentLocation=" + documentLocation +
                ", documentProcessBegin='" + documentProcessBegin + '\'' +
                ", documentProcessFinish='" + documentProcessFinish + '\'' +
                ", documentState=" + documentState +
                ", documentSpeed=" + documentSpeed +
                ", creationTime='" + creationTime + '\'' +
                ", documentIsdelete=" + documentIsdelete +
                '}';
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime == null ? null : creationTime.trim();
    }

    public Integer getDocumentIsdelete() {
        return documentIsdelete;
    }

    public void setDocumentIsdelete(Integer documentIsdelete) {
        this.documentIsdelete = documentIsdelete;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentId='" + documentId + '\'' +
                ", documentTitle='" + documentTitle + '\'' +
                ", documentType='" + documentType + '\'' +
                ", documentNo='" + documentNo + '\'' +
                ", documentDept='" + documentDept + '\'' +
                ", documentUser='" + documentUser + '\'' +
                ", documentConfidential=" + documentConfidential +
                ", doucmentContent='" + doucmentContent + '\'' +
                ", documentRemark='" + documentRemark + '\'' +
                ", documentProcess='" + documentProcess + '\'' +
                ", documentLocation=" + documentLocation +
                ", documentProcessBegin='" + documentProcessBegin + '\'' +
                ", documentProcessFinish='" + documentProcessFinish + '\'' +
                ", documentState=" + documentState +
                ", documentSpeed=" + documentSpeed +
                ", creationTime='" + creationTime + '\'' +
                ", documentIsdelete=" + documentIsdelete +
                '}';
    }
}