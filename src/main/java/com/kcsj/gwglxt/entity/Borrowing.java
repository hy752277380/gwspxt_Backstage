package com.kcsj.gwglxt.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-06-10
 */
public class Borrowing {
    private String borrowingId;

    private String borrowingBorrowUser;

    private String borrowingLendUser;

    private String borrowingDocument;

    private String borrowingApplicationdate;

    private Integer borrowingState;

    private String borrowingBegintime;

    private String borrowingOvertime;

    private String borrowingReason;

    private Integer borrowingIsdelete;

    public String getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(String borrowingId) {
        this.borrowingId = borrowingId == null ? null : borrowingId.trim();
    }

    public String getBorrowingBorrowUser() {
        return borrowingBorrowUser;
    }

    public void setBorrowingBorrowUser(String borrowingBorrowUser) {
        this.borrowingBorrowUser = borrowingBorrowUser == null ? null : borrowingBorrowUser.trim();
    }

    public String getBorrowingLendUser() {
        return borrowingLendUser;
    }

    public void setBorrowingLendUser(String borrowingLendUser) {
        this.borrowingLendUser = borrowingLendUser == null ? null : borrowingLendUser.trim();
    }

    public String getBorrowingDocument() {
        return borrowingDocument;
    }

    public void setBorrowingDocument(String borrowingDocument) {
        this.borrowingDocument = borrowingDocument == null ? null : borrowingDocument.trim();
    }

    public String getBorrowingApplicationdate() {
        return borrowingApplicationdate;
    }

    public void setBorrowingApplicationdate(String borrowingApplicationdate) {
        this.borrowingApplicationdate = borrowingApplicationdate == null ? null : borrowingApplicationdate.trim();
    }

    public Integer getBorrowingState() {
        return borrowingState;
    }

    public void setBorrowingState(Integer borrowingState) {
        this.borrowingState = borrowingState;
    }

    public String getBorrowingBegintime() {
        return borrowingBegintime;
    }

    public void setBorrowingBegintime(String borrowingBegintime) {
        this.borrowingBegintime = borrowingBegintime == null ? null : borrowingBegintime.trim();
    }

    public String getBorrowingOvertime() {
        return borrowingOvertime;
    }

    public void setBorrowingOvertime(String borrowingOvertime) {
        this.borrowingOvertime = borrowingOvertime == null ? null : borrowingOvertime.trim();
    }

    public String getBorrowingReason() {
        return borrowingReason;
    }

    public void setBorrowingReason(String borrowingReason) {
        this.borrowingReason = borrowingReason == null ? null : borrowingReason.trim();
    }

    public Integer getBorrowingIsdelete() {
        return borrowingIsdelete;
    }

    public void setBorrowingIsdelete(Integer borrowingIsdelete) {
        this.borrowingIsdelete = borrowingIsdelete;
    }
}