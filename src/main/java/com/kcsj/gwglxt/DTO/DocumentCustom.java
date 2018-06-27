package com.kcsj.gwglxt.DTO;

import com.kcsj.gwglxt.entity.*;
import com.kcsj.gwglxt.entity.Process;

public class DocumentCustom {
    private Document document;
    private Documenttype documenttype;
    private Department department;
    private Guser guser;
    private com.kcsj.gwglxt.entity.Process process;
    private Borrowing borrowing;

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

    public Borrowing getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(Borrowing borrowing) {
        this.borrowing = borrowing;
    }

    @Override
    public String toString() {
        return "DocumentCustom{" +
                "document=" + document +
                ", documenttype=" + documenttype +
                ", department=" + department +
                ", guser=" + guser +
                ", process=" + process +
                ", borrowing=" + borrowing +
                '}';
    }
}
