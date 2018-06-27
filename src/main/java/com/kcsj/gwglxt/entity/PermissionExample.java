package com.kcsj.gwglxt.entity;

import java.util.ArrayList;
import java.util.List;

public class PermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PermissionExample() {
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
     * @date 2018-06-08
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

        public Criteria andPermissionIdIsNull() {
            addCriterion("permission_id is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIsNotNull() {
            addCriterion("permission_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionIdEqualTo(String value) {
            addCriterion("permission_id =", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotEqualTo(String value) {
            addCriterion("permission_id <>", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThan(String value) {
            addCriterion("permission_id >", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdGreaterThanOrEqualTo(String value) {
            addCriterion("permission_id >=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThan(String value) {
            addCriterion("permission_id <", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLessThanOrEqualTo(String value) {
            addCriterion("permission_id <=", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdLike(String value) {
            addCriterion("permission_id like", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotLike(String value) {
            addCriterion("permission_id not like", value, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdIn(List<String> values) {
            addCriterion("permission_id in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotIn(List<String> values) {
            addCriterion("permission_id not in", values, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdBetween(String value1, String value2) {
            addCriterion("permission_id between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionIdNotBetween(String value1, String value2) {
            addCriterion("permission_id not between", value1, value2, "permissionId");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelIsNull() {
            addCriterion("permission_level is null");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelIsNotNull() {
            addCriterion("permission_level is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelEqualTo(Integer value) {
            addCriterion("permission_level =", value, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelNotEqualTo(Integer value) {
            addCriterion("permission_level <>", value, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelGreaterThan(Integer value) {
            addCriterion("permission_level >", value, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("permission_level >=", value, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelLessThan(Integer value) {
            addCriterion("permission_level <", value, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelLessThanOrEqualTo(Integer value) {
            addCriterion("permission_level <=", value, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelIn(List<Integer> values) {
            addCriterion("permission_level in", values, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelNotIn(List<Integer> values) {
            addCriterion("permission_level not in", values, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelBetween(Integer value1, Integer value2) {
            addCriterion("permission_level between", value1, value2, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("permission_level not between", value1, value2, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionRemarkIsNull() {
            addCriterion("permission_remark is null");
            return (Criteria) this;
        }

        public Criteria andPermissionRemarkIsNotNull() {
            addCriterion("permission_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionRemarkEqualTo(String value) {
            addCriterion("permission_remark =", value, "permissionRemark");
            return (Criteria) this;
        }

        public Criteria andPermissionRemarkNotEqualTo(String value) {
            addCriterion("permission_remark <>", value, "permissionRemark");
            return (Criteria) this;
        }

        public Criteria andPermissionRemarkGreaterThan(String value) {
            addCriterion("permission_remark >", value, "permissionRemark");
            return (Criteria) this;
        }

        public Criteria andPermissionRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("permission_remark >=", value, "permissionRemark");
            return (Criteria) this;
        }

        public Criteria andPermissionRemarkLessThan(String value) {
            addCriterion("permission_remark <", value, "permissionRemark");
            return (Criteria) this;
        }

        public Criteria andPermissionRemarkLessThanOrEqualTo(String value) {
            addCriterion("permission_remark <=", value, "permissionRemark");
            return (Criteria) this;
        }

        public Criteria andPermissionRemarkLike(String value) {
            addCriterion("permission_remark like", value, "permissionRemark");
            return (Criteria) this;
        }

        public Criteria andPermissionRemarkNotLike(String value) {
            addCriterion("permission_remark not like", value, "permissionRemark");
            return (Criteria) this;
        }

        public Criteria andPermissionRemarkIn(List<String> values) {
            addCriterion("permission_remark in", values, "permissionRemark");
            return (Criteria) this;
        }

        public Criteria andPermissionRemarkNotIn(List<String> values) {
            addCriterion("permission_remark not in", values, "permissionRemark");
            return (Criteria) this;
        }

        public Criteria andPermissionRemarkBetween(String value1, String value2) {
            addCriterion("permission_remark between", value1, value2, "permissionRemark");
            return (Criteria) this;
        }

        public Criteria andPermissionRemarkNotBetween(String value1, String value2) {
            addCriterion("permission_remark not between", value1, value2, "permissionRemark");
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
     * @date 2018-06-08
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