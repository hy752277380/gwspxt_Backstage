package com.kcsj.gwglxt.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-06-10
 */
public class Documenttype {
    private String documenttypeId;

    private String documenttypeName;

    private String documenttypeRemark;

    private Integer documenttypeIsdelete;

    public String getDocumenttypeId() {
        return documenttypeId;
    }

    public void setDocumenttypeId(String documenttypeId) {
        this.documenttypeId = documenttypeId == null ? null : documenttypeId.trim();
    }

    public String getDocumenttypeName() {
        return documenttypeName;
    }

    public void setDocumenttypeName(String documenttypeName) {
        this.documenttypeName = documenttypeName == null ? null : documenttypeName.trim();
    }

    public String getDocumenttypeRemark() {
        return documenttypeRemark;
    }

    public void setDocumenttypeRemark(String documenttypeRemark) {
        this.documenttypeRemark = documenttypeRemark == null ? null : documenttypeRemark.trim();
    }

    public Integer getDocumenttypeIsdelete() {
        return documenttypeIsdelete;
    }

    public void setDocumenttypeIsdelete(Integer documenttypeIsdelete) {
        this.documenttypeIsdelete = documenttypeIsdelete;
    }
}