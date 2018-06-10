package com.kcsj.gwglxt.entity;

import java.util.ArrayList;
import java.util.List;

public class BorrowingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BorrowingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 
     * 
     * @author wcyong
     * 
     * @date 2018-06-10
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBorrowingIdIsNull() {
            addCriterion("borrowing_id is null");
            return (Criteria) this;
        }

        public Criteria andBorrowingIdIsNotNull() {
            addCriterion("borrowing_id is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowingIdEqualTo(String value) {
            addCriterion("borrowing_id =", value, "borrowingId");
            return (Criteria) this;
        }

        public Criteria andBorrowingIdNotEqualTo(String value) {
            addCriterion("borrowing_id <>", value, "borrowingId");
            return (Criteria) this;
        }

        public Criteria andBorrowingIdGreaterThan(String value) {
            addCriterion("borrowing_id >", value, "borrowingId");
            return (Criteria) this;
        }

        public Criteria andBorrowingIdGreaterThanOrEqualTo(String value) {
            addCriterion("borrowing_id >=", value, "borrowingId");
            return (Criteria) this;
        }

        public Criteria andBorrowingIdLessThan(String value) {
            addCriterion("borrowing_id <", value, "borrowingId");
            return (Criteria) this;
        }

        public Criteria andBorrowingIdLessThanOrEqualTo(String value) {
            addCriterion("borrowing_id <=", value, "borrowingId");
            return (Criteria) this;
        }

        public Criteria andBorrowingIdLike(String value) {
            addCriterion("borrowing_id like", value, "borrowingId");
            return (Criteria) this;
        }

        public Criteria andBorrowingIdNotLike(String value) {
            addCriterion("borrowing_id not like", value, "borrowingId");
            return (Criteria) this;
        }

        public Criteria andBorrowingIdIn(List<String> values) {
            addCriterion("borrowing_id in", values, "borrowingId");
            return (Criteria) this;
        }

        public Criteria andBorrowingIdNotIn(List<String> values) {
            addCriterion("borrowing_id not in", values, "borrowingId");
            return (Criteria) this;
        }

        public Criteria andBorrowingIdBetween(String value1, String value2) {
            addCriterion("borrowing_id between", value1, value2, "borrowingId");
            return (Criteria) this;
        }

        public Criteria andBorrowingIdNotBetween(String value1, String value2) {
            addCriterion("borrowing_id not between", value1, value2, "borrowingId");
            return (Criteria) this;
        }

        public Criteria andBorrowingBorrowUserIsNull() {
            addCriterion("borrowing_borrow_user is null");
            return (Criteria) this;
        }

        public Criteria andBorrowingBorrowUserIsNotNull() {
            addCriterion("borrowing_borrow_user is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowingBorrowUserEqualTo(String value) {
            addCriterion("borrowing_borrow_user =", value, "borrowingBorrowUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingBorrowUserNotEqualTo(String value) {
            addCriterion("borrowing_borrow_user <>", value, "borrowingBorrowUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingBorrowUserGreaterThan(String value) {
            addCriterion("borrowing_borrow_user >", value, "borrowingBorrowUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingBorrowUserGreaterThanOrEqualTo(String value) {
            addCriterion("borrowing_borrow_user >=", value, "borrowingBorrowUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingBorrowUserLessThan(String value) {
            addCriterion("borrowing_borrow_user <", value, "borrowingBorrowUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingBorrowUserLessThanOrEqualTo(String value) {
            addCriterion("borrowing_borrow_user <=", value, "borrowingBorrowUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingBorrowUserLike(String value) {
            addCriterion("borrowing_borrow_user like", value, "borrowingBorrowUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingBorrowUserNotLike(String value) {
            addCriterion("borrowing_borrow_user not like", value, "borrowingBorrowUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingBorrowUserIn(List<String> values) {
            addCriterion("borrowing_borrow_user in", values, "borrowingBorrowUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingBorrowUserNotIn(List<String> values) {
            addCriterion("borrowing_borrow_user not in", values, "borrowingBorrowUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingBorrowUserBetween(String value1, String value2) {
            addCriterion("borrowing_borrow_user between", value1, value2, "borrowingBorrowUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingBorrowUserNotBetween(String value1, String value2) {
            addCriterion("borrowing_borrow_user not between", value1, value2, "borrowingBorrowUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingLendUserIsNull() {
            addCriterion("borrowing_lend_user is null");
            return (Criteria) this;
        }

        public Criteria andBorrowingLendUserIsNotNull() {
            addCriterion("borrowing_lend_user is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowingLendUserEqualTo(String value) {
            addCriterion("borrowing_lend_user =", value, "borrowingLendUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingLendUserNotEqualTo(String value) {
            addCriterion("borrowing_lend_user <>", value, "borrowingLendUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingLendUserGreaterThan(String value) {
            addCriterion("borrowing_lend_user >", value, "borrowingLendUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingLendUserGreaterThanOrEqualTo(String value) {
            addCriterion("borrowing_lend_user >=", value, "borrowingLendUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingLendUserLessThan(String value) {
            addCriterion("borrowing_lend_user <", value, "borrowingLendUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingLendUserLessThanOrEqualTo(String value) {
            addCriterion("borrowing_lend_user <=", value, "borrowingLendUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingLendUserLike(String value) {
            addCriterion("borrowing_lend_user like", value, "borrowingLendUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingLendUserNotLike(String value) {
            addCriterion("borrowing_lend_user not like", value, "borrowingLendUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingLendUserIn(List<String> values) {
            addCriterion("borrowing_lend_user in", values, "borrowingLendUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingLendUserNotIn(List<String> values) {
            addCriterion("borrowing_lend_user not in", values, "borrowingLendUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingLendUserBetween(String value1, String value2) {
            addCriterion("borrowing_lend_user between", value1, value2, "borrowingLendUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingLendUserNotBetween(String value1, String value2) {
            addCriterion("borrowing_lend_user not between", value1, value2, "borrowingLendUser");
            return (Criteria) this;
        }

        public Criteria andBorrowingDocumentIsNull() {
            addCriterion("borrowing_document is null");
            return (Criteria) this;
        }

        public Criteria andBorrowingDocumentIsNotNull() {
            addCriterion("borrowing_document is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowingDocumentEqualTo(String value) {
            addCriterion("borrowing_document =", value, "borrowingDocument");
            return (Criteria) this;
        }

        public Criteria andBorrowingDocumentNotEqualTo(String value) {
            addCriterion("borrowing_document <>", value, "borrowingDocument");
            return (Criteria) this;
        }

        public Criteria andBorrowingDocumentGreaterThan(String value) {
            addCriterion("borrowing_document >", value, "borrowingDocument");
            return (Criteria) this;
        }

        public Criteria andBorrowingDocumentGreaterThanOrEqualTo(String value) {
            addCriterion("borrowing_document >=", value, "borrowingDocument");
            return (Criteria) this;
        }

        public Criteria andBorrowingDocumentLessThan(String value) {
            addCriterion("borrowing_document <", value, "borrowingDocument");
            return (Criteria) this;
        }

        public Criteria andBorrowingDocumentLessThanOrEqualTo(String value) {
            addCriterion("borrowing_document <=", value, "borrowingDocument");
            return (Criteria) this;
        }

        public Criteria andBorrowingDocumentLike(String value) {
            addCriterion("borrowing_document like", value, "borrowingDocument");
            return (Criteria) this;
        }

        public Criteria andBorrowingDocumentNotLike(String value) {
            addCriterion("borrowing_document not like", value, "borrowingDocument");
            return (Criteria) this;
        }

        public Criteria andBorrowingDocumentIn(List<String> values) {
            addCriterion("borrowing_document in", values, "borrowingDocument");
            return (Criteria) this;
        }

        public Criteria andBorrowingDocumentNotIn(List<String> values) {
            addCriterion("borrowing_document not in", values, "borrowingDocument");
            return (Criteria) this;
        }

        public Criteria andBorrowingDocumentBetween(String value1, String value2) {
            addCriterion("borrowing_document between", value1, value2, "borrowingDocument");
            return (Criteria) this;
        }

        public Criteria andBorrowingDocumentNotBetween(String value1, String value2) {
            addCriterion("borrowing_document not between", value1, value2, "borrowingDocument");
            return (Criteria) this;
        }

        public Criteria andBorrowingApplicationdateIsNull() {
            addCriterion("borrowing_applicationdate is null");
            return (Criteria) this;
        }

        public Criteria andBorrowingApplicationdateIsNotNull() {
            addCriterion("borrowing_applicationdate is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowingApplicationdateEqualTo(String value) {
            addCriterion("borrowing_applicationdate =", value, "borrowingApplicationdate");
            return (Criteria) this;
        }

        public Criteria andBorrowingApplicationdateNotEqualTo(String value) {
            addCriterion("borrowing_applicationdate <>", value, "borrowingApplicationdate");
            return (Criteria) this;
        }

        public Criteria andBorrowingApplicationdateGreaterThan(String value) {
            addCriterion("borrowing_applicationdate >", value, "borrowingApplicationdate");
            return (Criteria) this;
        }

        public Criteria andBorrowingApplicationdateGreaterThanOrEqualTo(String value) {
            addCriterion("borrowing_applicationdate >=", value, "borrowingApplicationdate");
            return (Criteria) this;
        }

        public Criteria andBorrowingApplicationdateLessThan(String value) {
            addCriterion("borrowing_applicationdate <", value, "borrowingApplicationdate");
            return (Criteria) this;
        }

        public Criteria andBorrowingApplicationdateLessThanOrEqualTo(String value) {
            addCriterion("borrowing_applicationdate <=", value, "borrowingApplicationdate");
            return (Criteria) this;
        }

        public Criteria andBorrowingApplicationdateLike(String value) {
            addCriterion("borrowing_applicationdate like", value, "borrowingApplicationdate");
            return (Criteria) this;
        }

        public Criteria andBorrowingApplicationdateNotLike(String value) {
            addCriterion("borrowing_applicationdate not like", value, "borrowingApplicationdate");
            return (Criteria) this;
        }

        public Criteria andBorrowingApplicationdateIn(List<String> values) {
            addCriterion("borrowing_applicationdate in", values, "borrowingApplicationdate");
            return (Criteria) this;
        }

        public Criteria andBorrowingApplicationdateNotIn(List<String> values) {
            addCriterion("borrowing_applicationdate not in", values, "borrowingApplicationdate");
            return (Criteria) this;
        }

        public Criteria andBorrowingApplicationdateBetween(String value1, String value2) {
            addCriterion("borrowing_applicationdate between", value1, value2, "borrowingApplicationdate");
            return (Criteria) this;
        }

        public Criteria andBorrowingApplicationdateNotBetween(String value1, String value2) {
            addCriterion("borrowing_applicationdate not between", value1, value2, "borrowingApplicationdate");
            return (Criteria) this;
        }

        public Criteria andBorrowingStateIsNull() {
            addCriterion("borrowing_state is null");
            return (Criteria) this;
        }

        public Criteria andBorrowingStateIsNotNull() {
            addCriterion("borrowing_state is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowingStateEqualTo(Integer value) {
            addCriterion("borrowing_state =", value, "borrowingState");
            return (Criteria) this;
        }

        public Criteria andBorrowingStateNotEqualTo(Integer value) {
            addCriterion("borrowing_state <>", value, "borrowingState");
            return (Criteria) this;
        }

        public Criteria andBorrowingStateGreaterThan(Integer value) {
            addCriterion("borrowing_state >", value, "borrowingState");
            return (Criteria) this;
        }

        public Criteria andBorrowingStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("borrowing_state >=", value, "borrowingState");
            return (Criteria) this;
        }

        public Criteria andBorrowingStateLessThan(Integer value) {
            addCriterion("borrowing_state <", value, "borrowingState");
            return (Criteria) this;
        }

        public Criteria andBorrowingStateLessThanOrEqualTo(Integer value) {
            addCriterion("borrowing_state <=", value, "borrowingState");
            return (Criteria) this;
        }

        public Criteria andBorrowingStateIn(List<Integer> values) {
            addCriterion("borrowing_state in", values, "borrowingState");
            return (Criteria) this;
        }

        public Criteria andBorrowingStateNotIn(List<Integer> values) {
            addCriterion("borrowing_state not in", values, "borrowingState");
            return (Criteria) this;
        }

        public Criteria andBorrowingStateBetween(Integer value1, Integer value2) {
            addCriterion("borrowing_state between", value1, value2, "borrowingState");
            return (Criteria) this;
        }

        public Criteria andBorrowingStateNotBetween(Integer value1, Integer value2) {
            addCriterion("borrowing_state not between", value1, value2, "borrowingState");
            return (Criteria) this;
        }

        public Criteria andBorrowingBegintimeIsNull() {
            addCriterion("borrowing_begintime is null");
            return (Criteria) this;
        }

        public Criteria andBorrowingBegintimeIsNotNull() {
            addCriterion("borrowing_begintime is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowingBegintimeEqualTo(String value) {
            addCriterion("borrowing_begintime =", value, "borrowingBegintime");
            return (Criteria) this;
        }

        public Criteria andBorrowingBegintimeNotEqualTo(String value) {
            addCriterion("borrowing_begintime <>", value, "borrowingBegintime");
            return (Criteria) this;
        }

        public Criteria andBorrowingBegintimeGreaterThan(String value) {
            addCriterion("borrowing_begintime >", value, "borrowingBegintime");
            return (Criteria) this;
        }

        public Criteria andBorrowingBegintimeGreaterThanOrEqualTo(String value) {
            addCriterion("borrowing_begintime >=", value, "borrowingBegintime");
            return (Criteria) this;
        }

        public Criteria andBorrowingBegintimeLessThan(String value) {
            addCriterion("borrowing_begintime <", value, "borrowingBegintime");
            return (Criteria) this;
        }

        public Criteria andBorrowingBegintimeLessThanOrEqualTo(String value) {
            addCriterion("borrowing_begintime <=", value, "borrowingBegintime");
            return (Criteria) this;
        }

        public Criteria andBorrowingBegintimeLike(String value) {
            addCriterion("borrowing_begintime like", value, "borrowingBegintime");
            return (Criteria) this;
        }

        public Criteria andBorrowingBegintimeNotLike(String value) {
            addCriterion("borrowing_begintime not like", value, "borrowingBegintime");
            return (Criteria) this;
        }

        public Criteria andBorrowingBegintimeIn(List<String> values) {
            addCriterion("borrowing_begintime in", values, "borrowingBegintime");
            return (Criteria) this;
        }

        public Criteria andBorrowingBegintimeNotIn(List<String> values) {
            addCriterion("borrowing_begintime not in", values, "borrowingBegintime");
            return (Criteria) this;
        }

        public Criteria andBorrowingBegintimeBetween(String value1, String value2) {
            addCriterion("borrowing_begintime between", value1, value2, "borrowingBegintime");
            return (Criteria) this;
        }

        public Criteria andBorrowingBegintimeNotBetween(String value1, String value2) {
            addCriterion("borrowing_begintime not between", value1, value2, "borrowingBegintime");
            return (Criteria) this;
        }

        public Criteria andBorrowingOvertimeIsNull() {
            addCriterion("borrowing_overtime is null");
            return (Criteria) this;
        }

        public Criteria andBorrowingOvertimeIsNotNull() {
            addCriterion("borrowing_overtime is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowingOvertimeEqualTo(String value) {
            addCriterion("borrowing_overtime =", value, "borrowingOvertime");
            return (Criteria) this;
        }

        public Criteria andBorrowingOvertimeNotEqualTo(String value) {
            addCriterion("borrowing_overtime <>", value, "borrowingOvertime");
            return (Criteria) this;
        }

        public Criteria andBorrowingOvertimeGreaterThan(String value) {
            addCriterion("borrowing_overtime >", value, "borrowingOvertime");
            return (Criteria) this;
        }

        public Criteria andBorrowingOvertimeGreaterThanOrEqualTo(String value) {
            addCriterion("borrowing_overtime >=", value, "borrowingOvertime");
            return (Criteria) this;
        }

        public Criteria andBorrowingOvertimeLessThan(String value) {
            addCriterion("borrowing_overtime <", value, "borrowingOvertime");
            return (Criteria) this;
        }

        public Criteria andBorrowingOvertimeLessThanOrEqualTo(String value) {
            addCriterion("borrowing_overtime <=", value, "borrowingOvertime");
            return (Criteria) this;
        }

        public Criteria andBorrowingOvertimeLike(String value) {
            addCriterion("borrowing_overtime like", value, "borrowingOvertime");
            return (Criteria) this;
        }

        public Criteria andBorrowingOvertimeNotLike(String value) {
            addCriterion("borrowing_overtime not like", value, "borrowingOvertime");
            return (Criteria) this;
        }

        public Criteria andBorrowingOvertimeIn(List<String> values) {
            addCriterion("borrowing_overtime in", values, "borrowingOvertime");
            return (Criteria) this;
        }

        public Criteria andBorrowingOvertimeNotIn(List<String> values) {
            addCriterion("borrowing_overtime not in", values, "borrowingOvertime");
            return (Criteria) this;
        }

        public Criteria andBorrowingOvertimeBetween(String value1, String value2) {
            addCriterion("borrowing_overtime between", value1, value2, "borrowingOvertime");
            return (Criteria) this;
        }

        public Criteria andBorrowingOvertimeNotBetween(String value1, String value2) {
            addCriterion("borrowing_overtime not between", value1, value2, "borrowingOvertime");
            return (Criteria) this;
        }

        public Criteria andBorrowingReasonIsNull() {
            addCriterion("borrowing_reason is null");
            return (Criteria) this;
        }

        public Criteria andBorrowingReasonIsNotNull() {
            addCriterion("borrowing_reason is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowingReasonEqualTo(String value) {
            addCriterion("borrowing_reason =", value, "borrowingReason");
            return (Criteria) this;
        }

        public Criteria andBorrowingReasonNotEqualTo(String value) {
            addCriterion("borrowing_reason <>", value, "borrowingReason");
            return (Criteria) this;
        }

        public Criteria andBorrowingReasonGreaterThan(String value) {
            addCriterion("borrowing_reason >", value, "borrowingReason");
            return (Criteria) this;
        }

        public Criteria andBorrowingReasonGreaterThanOrEqualTo(String value) {
            addCriterion("borrowing_reason >=", value, "borrowingReason");
            return (Criteria) this;
        }

        public Criteria andBorrowingReasonLessThan(String value) {
            addCriterion("borrowing_reason <", value, "borrowingReason");
            return (Criteria) this;
        }

        public Criteria andBorrowingReasonLessThanOrEqualTo(String value) {
            addCriterion("borrowing_reason <=", value, "borrowingReason");
            return (Criteria) this;
        }

        public Criteria andBorrowingReasonLike(String value) {
            addCriterion("borrowing_reason like", value, "borrowingReason");
            return (Criteria) this;
        }

        public Criteria andBorrowingReasonNotLike(String value) {
            addCriterion("borrowing_reason not like", value, "borrowingReason");
            return (Criteria) this;
        }

        public Criteria andBorrowingReasonIn(List<String> values) {
            addCriterion("borrowing_reason in", values, "borrowingReason");
            return (Criteria) this;
        }

        public Criteria andBorrowingReasonNotIn(List<String> values) {
            addCriterion("borrowing_reason not in", values, "borrowingReason");
            return (Criteria) this;
        }

        public Criteria andBorrowingReasonBetween(String value1, String value2) {
            addCriterion("borrowing_reason between", value1, value2, "borrowingReason");
            return (Criteria) this;
        }

        public Criteria andBorrowingReasonNotBetween(String value1, String value2) {
            addCriterion("borrowing_reason not between", value1, value2, "borrowingReason");
            return (Criteria) this;
        }

        public Criteria andBorrowingIsdeleteIsNull() {
            addCriterion("borrowing_isdelete is null");
            return (Criteria) this;
        }

        public Criteria andBorrowingIsdeleteIsNotNull() {
            addCriterion("borrowing_isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowingIsdeleteEqualTo(Integer value) {
            addCriterion("borrowing_isdelete =", value, "borrowingIsdelete");
            return (Criteria) this;
        }

        public Criteria andBorrowingIsdeleteNotEqualTo(Integer value) {
            addCriterion("borrowing_isdelete <>", value, "borrowingIsdelete");
            return (Criteria) this;
        }

        public Criteria andBorrowingIsdeleteGreaterThan(Integer value) {
            addCriterion("borrowing_isdelete >", value, "borrowingIsdelete");
            return (Criteria) this;
        }

        public Criteria andBorrowingIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("borrowing_isdelete >=", value, "borrowingIsdelete");
            return (Criteria) this;
        }

        public Criteria andBorrowingIsdeleteLessThan(Integer value) {
            addCriterion("borrowing_isdelete <", value, "borrowingIsdelete");
            return (Criteria) this;
        }

        public Criteria andBorrowingIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("borrowing_isdelete <=", value, "borrowingIsdelete");
            return (Criteria) this;
        }

        public Criteria andBorrowingIsdeleteIn(List<Integer> values) {
            addCriterion("borrowing_isdelete in", values, "borrowingIsdelete");
            return (Criteria) this;
        }

        public Criteria andBorrowingIsdeleteNotIn(List<Integer> values) {
            addCriterion("borrowing_isdelete not in", values, "borrowingIsdelete");
            return (Criteria) this;
        }

        public Criteria andBorrowingIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("borrowing_isdelete between", value1, value2, "borrowingIsdelete");
            return (Criteria) this;
        }

        public Criteria andBorrowingIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("borrowing_isdelete not between", value1, value2, "borrowingIsdelete");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 
     * 
     * @author wcyong
     * 
     * @date 2018-06-10
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}