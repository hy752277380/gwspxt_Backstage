package com.kcsj.gwglxt.entity;

public class DocumentCustom {
    private Document document;
    private Documenttype documenttype;
    private Department department;
    private Guser guser;
    private Process process;

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

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

}
