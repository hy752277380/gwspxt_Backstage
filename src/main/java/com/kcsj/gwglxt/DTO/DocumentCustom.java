package com.kcsj.gwglxt.DTO;

import com.kcsj.gwglxt.entity.Department;
import com.kcsj.gwglxt.entity.Document;
import com.kcsj.gwglxt.entity.Documenttype;
import com.kcsj.gwglxt.entity.Guser;
import com.kcsj.gwglxt.entity.Process;

public class DocumentCustom {
    private Document document;
    private Documenttype documenttype;
    private Department department;
    private Guser guser;
    private com.kcsj.gwglxt.entity.Process process;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Documenttype getDocumenttype() {
        return documenttype;
    }

    public void setDocumenttype(Documenttype documenttype) {
        this.documenttype = documenttype;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Guser getGuser() {
        return guser;
    }

    public void setGuser(Guser guser) {
        this.guser = guser;
    }

    public com.kcsj.gwglxt.entity.Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

}
