package com.kcsj.gwglxt.entity;

import java.util.ArrayList;
import java.util.List;

public class DocumentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DocumentExample() {
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

        public Criteria andDocumentIdIsNull() {
            addCriterion("document_id is null");
            return (Criteria) this;
        }

        public Criteria andDocumentIdIsNotNull() {
            addCriterion("document_id is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentIdEqualTo(String value) {
            addCriterion("document_id =", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotEqualTo(String value) {
            addCriterion("document_id <>", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdGreaterThan(String value) {
            addCriterion("document_id >", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdGreaterThanOrEqualTo(String value) {
            addCriterion("document_id >=", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLessThan(String value) {
            addCriterion("document_id <", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLessThanOrEqualTo(String value) {
            addCriterion("document_id <=", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdLike(String value) {
            addCriterion("document_id like", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotLike(String value) {
            addCriterion("document_id not like", value, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdIn(List<String> values) {
            addCriterion("document_id in", values, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotIn(List<String> values) {
            addCriterion("document_id not in", values, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdBetween(String value1, String value2) {
            addCriterion("document_id between", value1, value2, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentIdNotBetween(String value1, String value2) {
            addCriterion("document_id not between", value1, value2, "documentId");
            return (Criteria) this;
        }

        public Criteria andDocumentTitleIsNull() {
            addCriterion("document_title is null");
            return (Criteria) this;
        }

        public Criteria andDocumentTitleIsNotNull() {
            addCriterion("document_title is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentTitleEqualTo(String value) {
            addCriterion("document_title =", value, "documentTitle");
            return (Criteria) this;
        }

        public Criteria andDocumentTitleNotEqualTo(String value) {
            addCriterion("document_title <>", value, "documentTitle");
            return (Criteria) this;
        }

        public Criteria andDocumentTitleGreaterThan(String value) {
            addCriterion("document_title >", value, "documentTitle");
            return (Criteria) this;
        }

        public Criteria andDocumentTitleGreaterThanOrEqualTo(String value) {
            addCriterion("document_title >=", value, "documentTitle");
            return (Criteria) this;
        }

        public Criteria andDocumentTitleLessThan(String value) {
            addCriterion("document_title <", value, "documentTitle");
            return (Criteria) this;
        }

        public Criteria andDocumentTitleLessThanOrEqualTo(String value) {
            addCriterion("document_title <=", value, "documentTitle");
            return (Criteria) this;
        }

        public Criteria andDocumentTitleLike(String value) {
            addCriterion("document_title like", value, "documentTitle");
            return (Criteria) this;
        }

        public Criteria andDocumentTitleNotLike(String value) {
            addCriterion("document_title not like", value, "documentTitle");
            return (Criteria) this;
        }

        public Criteria andDocumentTitleIn(List<String> values) {
            addCriterion("document_title in", values, "documentTitle");
            return (Criteria) this;
        }

        public Criteria andDocumentTitleNotIn(List<String> values) {
            addCriterion("document_title not in", values, "documentTitle");
            return (Criteria) this;
        }

        public Criteria andDocumentTitleBetween(String value1, String value2) {
            addCriterion("document_title between", value1, value2, "documentTitle");
            return (Criteria) this;
        }

        public Criteria andDocumentTitleNotBetween(String value1, String value2) {
            addCriterion("document_title not between", value1, value2, "documentTitle");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeIsNull() {
            addCriterion("document_type is null");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeIsNotNull() {
            addCriterion("document_type is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeEqualTo(String value) {
            addCriterion("document_type =", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeNotEqualTo(String value) {
            addCriterion("document_type <>", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeGreaterThan(String value) {
            addCriterion("document_type >", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("document_type >=", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeLessThan(String value) {
            addCriterion("document_type <", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeLessThanOrEqualTo(String value) {
            addCriterion("document_type <=", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeLike(String value) {
            addCriterion("document_type like", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeNotLike(String value) {
            addCriterion("document_type not like", value, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeIn(List<String> values) {
            addCriterion("document_type in", values, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeNotIn(List<String> values) {
            addCriterion("document_type not in", values, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeBetween(String value1, String value2) {
            addCriterion("document_type between", value1, value2, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentTypeNotBetween(String value1, String value2) {
            addCriterion("document_type not between", value1, value2, "documentType");
            return (Criteria) this;
        }

        public Criteria andDocumentNoIsNull() {
            addCriterion("document_no is null");
            return (Criteria) this;
        }

        public Criteria andDocumentNoIsNotNull() {
            addCriterion("document_no is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentNoEqualTo(String value) {
            addCriterion("document_no =", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoNotEqualTo(String value) {
            addCriterion("document_no <>", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoGreaterThan(String value) {
            addCriterion("document_no >", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoGreaterThanOrEqualTo(String value) {
            addCriterion("document_no >=", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoLessThan(String value) {
            addCriterion("document_no <", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoLessThanOrEqualTo(String value) {
            addCriterion("document_no <=", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoLike(String value) {
            addCriterion("document_no like", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoNotLike(String value) {
            addCriterion("document_no not like", value, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoIn(List<String> values) {
            addCriterion("document_no in", values, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoNotIn(List<String> values) {
            addCriterion("document_no not in", values, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoBetween(String value1, String value2) {
            addCriterion("document_no between", value1, value2, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentNoNotBetween(String value1, String value2) {
            addCriterion("document_no not between", value1, value2, "documentNo");
            return (Criteria) this;
        }

        public Criteria andDocumentDeptIsNull() {
            addCriterion("document_dept is null");
            return (Criteria) this;
        }

        public Criteria andDocumentDeptIsNotNull() {
            addCriterion("document_dept is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentDeptEqualTo(String value) {
            addCriterion("document_dept =", value, "documentDept");
            return (Criteria) this;
        }

        public Criteria andDocumentDeptNotEqualTo(String value) {
            addCriterion("document_dept <>", value, "documentDept");
            return (Criteria) this;
        }

        public Criteria andDocumentDeptGreaterThan(String value) {
            addCriterion("document_dept >", value, "documentDept");
            return (Criteria) this;
        }

        public Criteria andDocumentDeptGreaterThanOrEqualTo(String value) {
            addCriterion("document_dept >=", value, "documentDept");
            return (Criteria) this;
        }

        public Criteria andDocumentDeptLessThan(String value) {
            addCriterion("document_dept <", value, "documentDept");
            return (Criteria) this;
        }

        public Criteria andDocumentDeptLessThanOrEqualTo(String value) {
            addCriterion("document_dept <=", value, "documentDept");
            return (Criteria) this;
        }

        public Criteria andDocumentDeptLike(String value) {
            addCriterion("document_dept like", value, "documentDept");
            return (Criteria) this;
        }

        public Criteria andDocumentDeptNotLike(String value) {
            addCriterion("document_dept not like", value, "documentDept");
            return (Criteria) this;
        }

        public Criteria andDocumentDeptIn(List<String> values) {
            addCriterion("document_dept in", values, "documentDept");
            return (Criteria) this;
        }

        public Criteria andDocumentDeptNotIn(List<String> values) {
            addCriterion("document_dept not in", values, "documentDept");
            return (Criteria) this;
        }

        public Criteria andDocumentDeptBetween(String value1, String value2) {
            addCriterion("document_dept between", value1, value2, "documentDept");
            return (Criteria) this;
        }

        public Criteria andDocumentDeptNotBetween(String value1, String value2) {
            addCriterion("document_dept not between", value1, value2, "documentDept");
            return (Criteria) this;
        }

        public Criteria andDocumentUserIsNull() {
            addCriterion("document_user is null");
            return (Criteria) this;
        }

        public Criteria andDocumentUserIsNotNull() {
            addCriterion("document_user is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentUserEqualTo(String value) {
            addCriterion("document_user =", value, "documentUser");
            return (Criteria) this;
        }

        public Criteria andDocumentUserNotEqualTo(String value) {
            addCriterion("document_user <>", value, "documentUser");
            return (Criteria) this;
        }

        public Criteria andDocumentUserGreaterThan(String value) {
            addCriterion("document_user >", value, "documentUser");
            return (Criteria) this;
        }

        public Criteria andDocumentUserGreaterThanOrEqualTo(String value) {
            addCriterion("document_user >=", value, "documentUser");
            return (Criteria) this;
        }

        public Criteria andDocumentUserLessThan(String value) {
            addCriterion("document_user <", value, "documentUser");
            return (Criteria) this;
        }

        public Criteria andDocumentUserLessThanOrEqualTo(String value) {
            addCriterion("document_user <=", value, "documentUser");
            return (Criteria) this;
        }

        public Criteria andDocumentUserLike(String value) {
            addCriterion("document_user like", value, "documentUser");
            return (Criteria) this;
        }

        public Criteria andDocumentUserNotLike(String value) {
            addCriterion("document_user not like", value, "documentUser");
            return (Criteria) this;
        }

        public Criteria andDocumentUserIn(List<String> values) {
            addCriterion("document_user in", values, "documentUser");
            return (Criteria) this;
        }

        public Criteria andDocumentUserNotIn(List<String> values) {
            addCriterion("document_user not in", values, "documentUser");
            return (Criteria) this;
        }

        public Criteria andDocumentUserBetween(String value1, String value2) {
            addCriterion("document_user between", value1, value2, "documentUser");
            return (Criteria) this;
        }

        public Criteria andDocumentUserNotBetween(String value1, String value2) {
            addCriterion("document_user not between", value1, value2, "documentUser");
            return (Criteria) this;
        }

        public Criteria andDocumentConfidentialIsNull() {
            addCriterion("document_confidential is null");
            return (Criteria) this;
        }

        public Criteria andDocumentConfidentialIsNotNull() {
            addCriterion("document_confidential is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentConfidentialEqualTo(Integer value) {
            addCriterion("document_confidential =", value, "documentConfidential");
            return (Criteria) this;
        }

        public Criteria andDocumentConfidentialNotEqualTo(Integer value) {
            addCriterion("document_confidential <>", value, "documentConfidential");
            return (Criteria) this;
        }

        public Criteria andDocumentConfidentialGreaterThan(Integer value) {
            addCriterion("document_confidential >", value, "documentConfidential");
            return (Criteria) this;
        }

        public Criteria andDocumentConfidentialGreaterThanOrEqualTo(Integer value) {
            addCriterion("document_confidential >=", value, "documentConfidential");
            return (Criteria) this;
        }

        public Criteria andDocumentConfidentialLessThan(Integer value) {
            addCriterion("document_confidential <", value, "documentConfidential");
            return (Criteria) this;
        }

        public Criteria andDocumentConfidentialLessThanOrEqualTo(Integer value) {
            addCriterion("document_confidential <=", value, "documentConfidential");
            return (Criteria) this;
        }

        public Criteria andDocumentConfidentialIn(List<Integer> values) {
            addCriterion("document_confidential in", values, "documentConfidential");
            return (Criteria) this;
        }

        public Criteria andDocumentConfidentialNotIn(List<Integer> values) {
            addCriterion("document_confidential not in", values, "documentConfidential");
            return (Criteria) this;
        }

        public Criteria andDocumentConfidentialBetween(Integer value1, Integer value2) {
            addCriterion("document_confidential between", value1, value2, "documentConfidential");
            return (Criteria) this;
        }

        public Criteria andDocumentConfidentialNotBetween(Integer value1, Integer value2) {
            addCriterion("document_confidential not between", value1, value2, "documentConfidential");
            return (Criteria) this;
        }

        public Criteria andDoucmentContentIsNull() {
            addCriterion("doucment_content is null");
            return (Criteria) this;
        }

        public Criteria andDoucmentContentIsNotNull() {
            addCriterion("doucment_content is not null");
            return (Criteria) this;
        }

        public Criteria andDoucmentContentEqualTo(String value) {
            addCriterion("doucment_content =", value, "doucmentContent");
            return (Criteria) this;
        }

        public Criteria andDoucmentContentNotEqualTo(String value) {
            addCriterion("doucment_content <>", value, "doucmentContent");
            return (Criteria) this;
        }

        public Criteria andDoucmentContentGreaterThan(String value) {
            addCriterion("doucment_content >", value, "doucmentContent");
            return (Criteria) this;
        }

        public Criteria andDoucmentContentGreaterThanOrEqualTo(String value) {
            addCriterion("doucment_content >=", value, "doucmentContent");
            return (Criteria) this;
        }

        public Criteria andDoucmentContentLessThan(String value) {
            addCriterion("doucment_content <", value, "doucmentContent");
            return (Criteria) this;
        }

        public Criteria andDoucmentContentLessThanOrEqualTo(String value) {
            addCriterion("doucment_content <=", value, "doucmentContent");
            return (Criteria) this;
        }

        public Criteria andDoucmentContentLike(String value) {
            addCriterion("doucment_content like", value, "doucmentContent");
            return (Criteria) this;
        }

        public Criteria andDoucmentContentNotLike(String value) {
            addCriterion("doucment_content not like", value, "doucmentContent");
            return (Criteria) this;
        }

        public Criteria andDoucmentContentIn(List<String> values) {
            addCriterion("doucment_content in", values, "doucmentContent");
            return (Criteria) this;
        }

        public Criteria andDoucmentContentNotIn(List<String> values) {
            addCriterion("doucment_content not in", values, "doucmentContent");
            return (Criteria) this;
        }

        public Criteria andDoucmentContentBetween(String value1, String value2) {
            addCriterion("doucment_content between", value1, value2, "doucmentContent");
            return (Criteria) this;
        }

        public Criteria andDoucmentContentNotBetween(String value1, String value2) {
            addCriterion("doucment_content not between", value1, value2, "doucmentContent");
            return (Criteria) this;
        }

        public Criteria andDocumentRemarkIsNull() {
            addCriterion("document_remark is null");
            return (Criteria) this;
        }

        public Criteria andDocumentRemarkIsNotNull() {
            addCriterion("document_remark is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentRemarkEqualTo(String value) {
            addCriterion("document_remark =", value, "documentRemark");
            return (Criteria) this;
        }

        public Criteria andDocumentRemarkNotEqualTo(String value) {
            addCriterion("document_remark <>", value, "documentRemark");
            return (Criteria) this;
        }

        public Criteria andDocumentRemarkGreaterThan(String value) {
            addCriterion("document_remark >", value, "documentRemark");
            return (Criteria) this;
        }

        public Criteria andDocumentRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("document_remark >=", value, "documentRemark");
            return (Criteria) this;
        }

        public Criteria andDocumentRemarkLessThan(String value) {
            addCriterion("document_remark <", value, "documentRemark");
            return (Criteria) this;
        }

        public Criteria andDocumentRemarkLessThanOrEqualTo(String value) {
            addCriterion("document_remark <=", value, "documentRemark");
            return (Criteria) this;
        }

        public Criteria andDocumentRemarkLike(String value) {
            addCriterion("document_remark like", value, "documentRemark");
            return (Criteria) this;
        }

        public Criteria andDocumentRemarkNotLike(String value) {
            addCriterion("document_remark not like", value, "documentRemark");
            return (Criteria) this;
        }

        public Criteria andDocumentRemarkIn(List<String> values) {
            addCriterion("document_remark in", values, "documentRemark");
            return (Criteria) this;
        }

        public Criteria andDocumentRemarkNotIn(List<String> values) {
            addCriterion("document_remark not in", values, "documentRemark");
            return (Criteria) this;
        }

        public Criteria andDocumentRemarkBetween(String value1, String value2) {
            addCriterion("document_remark between", value1, value2, "documentRemark");
            return (Criteria) this;
        }

        public Criteria andDocumentRemarkNotBetween(String value1, String value2) {
            addCriterion("document_remark not between", value1, value2, "documentRemark");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessIsNull() {
            addCriterion("document_process is null");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessIsNotNull() {
            addCriterion("document_process is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessEqualTo(String value) {
            addCriterion("document_process =", value, "documentProcess");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessNotEqualTo(String value) {
            addCriterion("document_process <>", value, "documentProcess");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessGreaterThan(String value) {
            addCriterion("document_process >", value, "documentProcess");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessGreaterThanOrEqualTo(String value) {
            addCriterion("document_process >=", value, "documentProcess");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessLessThan(String value) {
            addCriterion("document_process <", value, "documentProcess");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessLessThanOrEqualTo(String value) {
            addCriterion("document_process <=", value, "documentProcess");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessLike(String value) {
            addCriterion("document_process like", value, "documentProcess");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessNotLike(String value) {
            addCriterion("document_process not like", value, "documentProcess");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessIn(List<String> values) {
            addCriterion("document_process in", values, "documentProcess");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessNotIn(List<String> values) {
            addCriterion("document_process not in", values, "documentProcess");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessBetween(String value1, String value2) {
            addCriterion("document_process between", value1, value2, "documentProcess");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessNotBetween(String value1, String value2) {
            addCriterion("document_process not between", value1, value2, "documentProcess");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessBeginIsNull() {
            addCriterion("document_process_begin is null");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessBeginIsNotNull() {
            addCriterion("document_process_begin is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessBeginEqualTo(String value) {
            addCriterion("document_process_begin =", value, "documentProcessBegin");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessBeginNotEqualTo(String value) {
            addCriterion("document_process_begin <>", value, "documentProcessBegin");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessBeginGreaterThan(String value) {
            addCriterion("document_process_begin >", value, "documentProcessBegin");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessBeginGreaterThanOrEqualTo(String value) {
            addCriterion("document_process_begin >=", value, "documentProcessBegin");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessBeginLessThan(String value) {
            addCriterion("document_process_begin <", value, "documentProcessBegin");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessBeginLessThanOrEqualTo(String value) {
            addCriterion("document_process_begin <=", value, "documentProcessBegin");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessBeginLike(String value) {
            addCriterion("document_process_begin like", value, "documentProcessBegin");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessBeginNotLike(String value) {
            addCriterion("document_process_begin not like", value, "documentProcessBegin");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessBeginIn(List<String> values) {
            addCriterion("document_process_begin in", values, "documentProcessBegin");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessBeginNotIn(List<String> values) {
            addCriterion("document_process_begin not in", values, "documentProcessBegin");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessBeginBetween(String value1, String value2) {
            addCriterion("document_process_begin between", value1, value2, "documentProcessBegin");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessBeginNotBetween(String value1, String value2) {
            addCriterion("document_process_begin not between", value1, value2, "documentProcessBegin");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessFinishIsNull() {
            addCriterion("document_process_finish is null");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessFinishIsNotNull() {
            addCriterion("document_process_finish is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessFinishEqualTo(String value) {
            addCriterion("document_process_finish =", value, "documentProcessFinish");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessFinishNotEqualTo(String value) {
            addCriterion("document_process_finish <>", value, "documentProcessFinish");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessFinishGreaterThan(String value) {
            addCriterion("document_process_finish >", value, "documentProcessFinish");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessFinishGreaterThanOrEqualTo(String value) {
            addCriterion("document_process_finish >=", value, "documentProcessFinish");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessFinishLessThan(String value) {
            addCriterion("document_process_finish <", value, "documentProcessFinish");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessFinishLessThanOrEqualTo(String value) {
            addCriterion("document_process_finish <=", value, "documentProcessFinish");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessFinishLike(String value) {
            addCriterion("document_process_finish like", value, "documentProcessFinish");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessFinishNotLike(String value) {
            addCriterion("document_process_finish not like", value, "documentProcessFinish");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessFinishIn(List<String> values) {
            addCriterion("document_process_finish in", values, "documentProcessFinish");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessFinishNotIn(List<String> values) {
            addCriterion("document_process_finish not in", values, "documentProcessFinish");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessFinishBetween(String value1, String value2) {
            addCriterion("document_process_finish between", value1, value2, "documentProcessFinish");
            return (Criteria) this;
        }

        public Criteria andDocumentProcessFinishNotBetween(String value1, String value2) {
            addCriterion("document_process_finish not between", value1, value2, "documentProcessFinish");
            return (Criteria) this;
        }

        public Criteria andDocumentStateIsNull() {
            addCriterion("document_state is null");
            return (Criteria) this;
        }

        public Criteria andDocumentStateIsNotNull() {
            addCriterion("document_state is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentStateEqualTo(Integer value) {
            addCriterion("document_state =", value, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentStateNotEqualTo(Integer value) {
            addCriterion("document_state <>", value, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentStateGreaterThan(Integer value) {
            addCriterion("document_state >", value, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("document_state >=", value, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentStateLessThan(Integer value) {
            addCriterion("document_state <", value, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentStateLessThanOrEqualTo(Integer value) {
            addCriterion("document_state <=", value, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentStateIn(List<Integer> values) {
            addCriterion("document_state in", values, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentStateNotIn(List<Integer> values) {
            addCriterion("document_state not in", values, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentStateBetween(Integer value1, Integer value2) {
            addCriterion("document_state between", value1, value2, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentStateNotBetween(Integer value1, Integer value2) {
            addCriterion("document_state not between", value1, value2, "documentState");
            return (Criteria) this;
        }

        public Criteria andDocumentSpeedIsNull() {
            addCriterion("document_speed is null");
            return (Criteria) this;
        }

        public Criteria andDocumentSpeedIsNotNull() {
            addCriterion("document_speed is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentSpeedEqualTo(Integer value) {
            addCriterion("document_speed =", value, "documentSpeed");
            return (Criteria) this;
        }

        public Criteria andDocumentSpeedNotEqualTo(Integer value) {
            addCriterion("document_speed <>", value, "documentSpeed");
            return (Criteria) this;
        }

        public Criteria andDocumentSpeedGreaterThan(Integer value) {
            addCriterion("document_speed >", value, "documentSpeed");
            return (Criteria) this;
        }

        public Criteria andDocumentSpeedGreaterThanOrEqualTo(Integer value) {
            addCriterion("document_speed >=", value, "documentSpeed");
            return (Criteria) this;
        }

        public Criteria andDocumentSpeedLessThan(Integer value) {
            addCriterion("document_speed <", value, "documentSpeed");
            return (Criteria) this;
        }

        public Criteria andDocumentSpeedLessThanOrEqualTo(Integer value) {
            addCriterion("document_speed <=", value, "documentSpeed");
            return (Criteria) this;
        }

        public Criteria andDocumentSpeedIn(List<Integer> values) {
            addCriterion("document_speed in", values, "documentSpeed");
            return (Criteria) this;
        }

        public Criteria andDocumentSpeedNotIn(List<Integer> values) {
            addCriterion("document_speed not in", values, "documentSpeed");
            return (Criteria) this;
        }

        public Criteria andDocumentSpeedBetween(Integer value1, Integer value2) {
            addCriterion("document_speed between", value1, value2, "documentSpeed");
            return (Criteria) this;
        }

        public Criteria andDocumentSpeedNotBetween(Integer value1, Integer value2) {
            addCriterion("document_speed not between", value1, value2, "documentSpeed");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNull() {
            addCriterion("creation_time is null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNotNull() {
            addCriterion("creation_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeEqualTo(String value) {
            addCriterion("creation_time =", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotEqualTo(String value) {
            addCriterion("creation_time <>", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThan(String value) {
            addCriterion("creation_time >", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThanOrEqualTo(String value) {
            addCriterion("creation_time >=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThan(String value) {
            addCriterion("creation_time <", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThanOrEqualTo(String value) {
            addCriterion("creation_time <=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLike(String value) {
            addCriterion("creation_time like", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotLike(String value) {
            addCriterion("creation_time not like", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIn(List<String> values) {
            addCriterion("creation_time in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotIn(List<String> values) {
            addCriterion("creation_time not in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeBetween(String value1, String value2) {
            addCriterion("creation_time between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotBetween(String value1, String value2) {
            addCriterion("creation_time not between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andDocumentIsdeleteIsNull() {
            addCriterion("document_isdelete is null");
            return (Criteria) this;
        }

        public Criteria andDocumentIsdeleteIsNotNull() {
            addCriterion("document_isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentIsdeleteEqualTo(Integer value) {
            addCriterion("document_isdelete =", value, "documentIsdelete");
            return (Criteria) this;
        }

        public Criteria andDocumentIsdeleteNotEqualTo(Integer value) {
            addCriterion("document_isdelete <>", value, "documentIsdelete");
            return (Criteria) this;
        }

        public Criteria andDocumentIsdeleteGreaterThan(Integer value) {
            addCriterion("document_isdelete >", value, "documentIsdelete");
            return (Criteria) this;
        }

        public Criteria andDocumentIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("document_isdelete >=", value, "documentIsdelete");
            return (Criteria) this;
        }

        public Criteria andDocumentIsdeleteLessThan(Integer value) {
            addCriterion("document_isdelete <", value, "documentIsdelete");
            return (Criteria) this;
        }

        public Criteria andDocumentIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("document_isdelete <=", value, "documentIsdelete");
            return (Criteria) this;
        }

        public Criteria andDocumentIsdeleteIn(List<Integer> values) {
            addCriterion("document_isdelete in", values, "documentIsdelete");
            return (Criteria) this;
        }

        public Criteria andDocumentIsdeleteNotIn(List<Integer> values) {
            addCriterion("document_isdelete not in", values, "documentIsdelete");
            return (Criteria) this;
        }

        public Criteria andDocumentIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("document_isdelete between", value1, value2, "documentIsdelete");
            return (Criteria) this;
        }

        public Criteria andDocumentIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("document_isdelete not between", value1, value2, "documentIsdelete");
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