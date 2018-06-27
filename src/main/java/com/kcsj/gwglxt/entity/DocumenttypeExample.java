package com.kcsj.gwglxt.entity;

import java.util.ArrayList;
import java.util.List;

public class DocumenttypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DocumenttypeExample() {
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

        public Criteria andDocumenttypeIdIsNull() {
            addCriterion("documenttype_id is null");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIdIsNotNull() {
            addCriterion("documenttype_id is not null");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIdEqualTo(String value) {
            addCriterion("documenttype_id =", value, "documenttypeId");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIdNotEqualTo(String value) {
            addCriterion("documenttype_id <>", value, "documenttypeId");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIdGreaterThan(String value) {
            addCriterion("documenttype_id >", value, "documenttypeId");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("documenttype_id >=", value, "documenttypeId");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIdLessThan(String value) {
            addCriterion("documenttype_id <", value, "documenttypeId");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIdLessThanOrEqualTo(String value) {
            addCriterion("documenttype_id <=", value, "documenttypeId");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIdLike(String value) {
            addCriterion("documenttype_id like", value, "documenttypeId");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIdNotLike(String value) {
            addCriterion("documenttype_id not like", value, "documenttypeId");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIdIn(List<String> values) {
            addCriterion("documenttype_id in", values, "documenttypeId");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIdNotIn(List<String> values) {
            addCriterion("documenttype_id not in", values, "documenttypeId");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIdBetween(String value1, String value2) {
            addCriterion("documenttype_id between", value1, value2, "documenttypeId");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIdNotBetween(String value1, String value2) {
            addCriterion("documenttype_id not between", value1, value2, "documenttypeId");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNameIsNull() {
            addCriterion("documenttype_name is null");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNameIsNotNull() {
            addCriterion("documenttype_name is not null");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNameEqualTo(String value) {
            addCriterion("documenttype_name =", value, "documenttypeName");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNameNotEqualTo(String value) {
            addCriterion("documenttype_name <>", value, "documenttypeName");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNameGreaterThan(String value) {
            addCriterion("documenttype_name >", value, "documenttypeName");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("documenttype_name >=", value, "documenttypeName");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNameLessThan(String value) {
            addCriterion("documenttype_name <", value, "documenttypeName");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNameLessThanOrEqualTo(String value) {
            addCriterion("documenttype_name <=", value, "documenttypeName");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNameLike(String value) {
            addCriterion("documenttype_name like", value, "documenttypeName");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNameNotLike(String value) {
            addCriterion("documenttype_name not like", value, "documenttypeName");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNameIn(List<String> values) {
            addCriterion("documenttype_name in", values, "documenttypeName");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNameNotIn(List<String> values) {
            addCriterion("documenttype_name not in", values, "documenttypeName");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNameBetween(String value1, String value2) {
            addCriterion("documenttype_name between", value1, value2, "documenttypeName");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNameNotBetween(String value1, String value2) {
            addCriterion("documenttype_name not between", value1, value2, "documenttypeName");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeRemarkIsNull() {
            addCriterion("documenttype_remark is null");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeRemarkIsNotNull() {
            addCriterion("documenttype_remark is not null");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeRemarkEqualTo(String value) {
            addCriterion("documenttype_remark =", value, "documenttypeRemark");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeRemarkNotEqualTo(String value) {
            addCriterion("documenttype_remark <>", value, "documenttypeRemark");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeRemarkGreaterThan(String value) {
            addCriterion("documenttype_remark >", value, "documenttypeRemark");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("documenttype_remark >=", value, "documenttypeRemark");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeRemarkLessThan(String value) {
            addCriterion("documenttype_remark <", value, "documenttypeRemark");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeRemarkLessThanOrEqualTo(String value) {
            addCriterion("documenttype_remark <=", value, "documenttypeRemark");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeRemarkLike(String value) {
            addCriterion("documenttype_remark like", value, "documenttypeRemark");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeRemarkNotLike(String value) {
            addCriterion("documenttype_remark not like", value, "documenttypeRemark");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeRemarkIn(List<String> values) {
            addCriterion("documenttype_remark in", values, "documenttypeRemark");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeRemarkNotIn(List<String> values) {
            addCriterion("documenttype_remark not in", values, "documenttypeRemark");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeRemarkBetween(String value1, String value2) {
            addCriterion("documenttype_remark between", value1, value2, "documenttypeRemark");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeRemarkNotBetween(String value1, String value2) {
            addCriterion("documenttype_remark not between", value1, value2, "documenttypeRemark");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIsdeleteIsNull() {
            addCriterion("documenttype_isdelete is null");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIsdeleteIsNotNull() {
            addCriterion("documenttype_isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIsdeleteEqualTo(Integer value) {
            addCriterion("documenttype_isdelete =", value, "documenttypeIsdelete");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIsdeleteNotEqualTo(Integer value) {
            addCriterion("documenttype_isdelete <>", value, "documenttypeIsdelete");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIsdeleteGreaterThan(Integer value) {
            addCriterion("documenttype_isdelete >", value, "documenttypeIsdelete");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("documenttype_isdelete >=", value, "documenttypeIsdelete");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIsdeleteLessThan(Integer value) {
            addCriterion("documenttype_isdelete <", value, "documenttypeIsdelete");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("documenttype_isdelete <=", value, "documenttypeIsdelete");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIsdeleteIn(List<Integer> values) {
            addCriterion("documenttype_isdelete in", values, "documenttypeIsdelete");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIsdeleteNotIn(List<Integer> values) {
            addCriterion("documenttype_isdelete not in", values, "documenttypeIsdelete");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("documenttype_isdelete between", value1, value2, "documenttypeIsdelete");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("documenttype_isdelete not between", value1, value2, "documenttypeIsdelete");
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