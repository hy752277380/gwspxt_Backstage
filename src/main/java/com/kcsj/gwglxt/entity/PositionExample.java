package com.kcsj.gwglxt.entity;

import java.util.ArrayList;
import java.util.List;

public class PositionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PositionExample() {
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

        public Criteria andPositionIdIsNull() {
            addCriterion("position_id is null");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNotNull() {
            addCriterion("position_id is not null");
            return (Criteria) this;
        }

        public Criteria andPositionIdEqualTo(String value) {
            addCriterion("position_id =", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotEqualTo(String value) {
            addCriterion("position_id <>", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThan(String value) {
            addCriterion("position_id >", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThanOrEqualTo(String value) {
            addCriterion("position_id >=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThan(String value) {
            addCriterion("position_id <", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThanOrEqualTo(String value) {
            addCriterion("position_id <=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLike(String value) {
            addCriterion("position_id like", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotLike(String value) {
            addCriterion("position_id not like", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIn(List<String> values) {
            addCriterion("position_id in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotIn(List<String> values) {
            addCriterion("position_id not in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdBetween(String value1, String value2) {
            addCriterion("position_id between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotBetween(String value1, String value2) {
            addCriterion("position_id not between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionDeptIsNull() {
            addCriterion("position_dept is null");
            return (Criteria) this;
        }

        public Criteria andPositionDeptIsNotNull() {
            addCriterion("position_dept is not null");
            return (Criteria) this;
        }

        public Criteria andPositionDeptEqualTo(String value) {
            addCriterion("position_dept =", value, "positionDept");
            return (Criteria) this;
        }

        public Criteria andPositionDeptNotEqualTo(String value) {
            addCriterion("position_dept <>", value, "positionDept");
            return (Criteria) this;
        }

        public Criteria andPositionDeptGreaterThan(String value) {
            addCriterion("position_dept >", value, "positionDept");
            return (Criteria) this;
        }

        public Criteria andPositionDeptGreaterThanOrEqualTo(String value) {
            addCriterion("position_dept >=", value, "positionDept");
            return (Criteria) this;
        }

        public Criteria andPositionDeptLessThan(String value) {
            addCriterion("position_dept <", value, "positionDept");
            return (Criteria) this;
        }

        public Criteria andPositionDeptLessThanOrEqualTo(String value) {
            addCriterion("position_dept <=", value, "positionDept");
            return (Criteria) this;
        }

        public Criteria andPositionDeptLike(String value) {
            addCriterion("position_dept like", value, "positionDept");
            return (Criteria) this;
        }

        public Criteria andPositionDeptNotLike(String value) {
            addCriterion("position_dept not like", value, "positionDept");
            return (Criteria) this;
        }

        public Criteria andPositionDeptIn(List<String> values) {
            addCriterion("position_dept in", values, "positionDept");
            return (Criteria) this;
        }

        public Criteria andPositionDeptNotIn(List<String> values) {
            addCriterion("position_dept not in", values, "positionDept");
            return (Criteria) this;
        }

        public Criteria andPositionDeptBetween(String value1, String value2) {
            addCriterion("position_dept between", value1, value2, "positionDept");
            return (Criteria) this;
        }

        public Criteria andPositionDeptNotBetween(String value1, String value2) {
            addCriterion("position_dept not between", value1, value2, "positionDept");
            return (Criteria) this;
        }

        public Criteria andPositionPermissionIsNull() {
            addCriterion("position_permission is null");
            return (Criteria) this;
        }

        public Criteria andPositionPermissionIsNotNull() {
            addCriterion("position_permission is not null");
            return (Criteria) this;
        }

        public Criteria andPositionPermissionEqualTo(String value) {
            addCriterion("position_permission =", value, "positionPermission");
            return (Criteria) this;
        }

        public Criteria andPositionPermissionNotEqualTo(String value) {
            addCriterion("position_permission <>", value, "positionPermission");
            return (Criteria) this;
        }

        public Criteria andPositionPermissionGreaterThan(String value) {
            addCriterion("position_permission >", value, "positionPermission");
            return (Criteria) this;
        }

        public Criteria andPositionPermissionGreaterThanOrEqualTo(String value) {
            addCriterion("position_permission >=", value, "positionPermission");
            return (Criteria) this;
        }

        public Criteria andPositionPermissionLessThan(String value) {
            addCriterion("position_permission <", value, "positionPermission");
            return (Criteria) this;
        }

        public Criteria andPositionPermissionLessThanOrEqualTo(String value) {
            addCriterion("position_permission <=", value, "positionPermission");
            return (Criteria) this;
        }

        public Criteria andPositionPermissionLike(String value) {
            addCriterion("position_permission like", value, "positionPermission");
            return (Criteria) this;
        }

        public Criteria andPositionPermissionNotLike(String value) {
            addCriterion("position_permission not like", value, "positionPermission");
            return (Criteria) this;
        }

        public Criteria andPositionPermissionIn(List<String> values) {
            addCriterion("position_permission in", values, "positionPermission");
            return (Criteria) this;
        }

        public Criteria andPositionPermissionNotIn(List<String> values) {
            addCriterion("position_permission not in", values, "positionPermission");
            return (Criteria) this;
        }

        public Criteria andPositionPermissionBetween(String value1, String value2) {
            addCriterion("position_permission between", value1, value2, "positionPermission");
            return (Criteria) this;
        }

        public Criteria andPositionPermissionNotBetween(String value1, String value2) {
            addCriterion("position_permission not between", value1, value2, "positionPermission");
            return (Criteria) this;
        }

        public Criteria andPositionNameIsNull() {
            addCriterion("position_name is null");
            return (Criteria) this;
        }

        public Criteria andPositionNameIsNotNull() {
            addCriterion("position_name is not null");
            return (Criteria) this;
        }

        public Criteria andPositionNameEqualTo(String value) {
            addCriterion("position_name =", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotEqualTo(String value) {
            addCriterion("position_name <>", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameGreaterThan(String value) {
            addCriterion("position_name >", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameGreaterThanOrEqualTo(String value) {
            addCriterion("position_name >=", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLessThan(String value) {
            addCriterion("position_name <", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLessThanOrEqualTo(String value) {
            addCriterion("position_name <=", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLike(String value) {
            addCriterion("position_name like", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotLike(String value) {
            addCriterion("position_name not like", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameIn(List<String> values) {
            addCriterion("position_name in", values, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotIn(List<String> values) {
            addCriterion("position_name not in", values, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameBetween(String value1, String value2) {
            addCriterion("position_name between", value1, value2, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotBetween(String value1, String value2) {
            addCriterion("position_name not between", value1, value2, "positionName");
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