package com.kcsj.gwglxt.entity;

import java.util.ArrayList;
import java.util.List;

public class ProcessNodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProcessNodeExample() {
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

        public Criteria andProcessNodeIdIsNull() {
            addCriterion("process_node_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdIsNotNull() {
            addCriterion("process_node_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdEqualTo(String value) {
            addCriterion("process_node_id =", value, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdNotEqualTo(String value) {
            addCriterion("process_node_id <>", value, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdGreaterThan(String value) {
            addCriterion("process_node_id >", value, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdGreaterThanOrEqualTo(String value) {
            addCriterion("process_node_id >=", value, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdLessThan(String value) {
            addCriterion("process_node_id <", value, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdLessThanOrEqualTo(String value) {
            addCriterion("process_node_id <=", value, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdLike(String value) {
            addCriterion("process_node_id like", value, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdNotLike(String value) {
            addCriterion("process_node_id not like", value, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdIn(List<String> values) {
            addCriterion("process_node_id in", values, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdNotIn(List<String> values) {
            addCriterion("process_node_id not in", values, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdBetween(String value1, String value2) {
            addCriterion("process_node_id between", value1, value2, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIdNotBetween(String value1, String value2) {
            addCriterion("process_node_id not between", value1, value2, "processNodeId");
            return (Criteria) this;
        }

        public Criteria andProcessNodeProcessIsNull() {
            addCriterion("process_node_process is null");
            return (Criteria) this;
        }

        public Criteria andProcessNodeProcessIsNotNull() {
            addCriterion("process_node_process is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNodeProcessEqualTo(String value) {
            addCriterion("process_node_process =", value, "processNodeProcess");
            return (Criteria) this;
        }

        public Criteria andProcessNodeProcessNotEqualTo(String value) {
            addCriterion("process_node_process <>", value, "processNodeProcess");
            return (Criteria) this;
        }

        public Criteria andProcessNodeProcessGreaterThan(String value) {
            addCriterion("process_node_process >", value, "processNodeProcess");
            return (Criteria) this;
        }

        public Criteria andProcessNodeProcessGreaterThanOrEqualTo(String value) {
            addCriterion("process_node_process >=", value, "processNodeProcess");
            return (Criteria) this;
        }

        public Criteria andProcessNodeProcessLessThan(String value) {
            addCriterion("process_node_process <", value, "processNodeProcess");
            return (Criteria) this;
        }

        public Criteria andProcessNodeProcessLessThanOrEqualTo(String value) {
            addCriterion("process_node_process <=", value, "processNodeProcess");
            return (Criteria) this;
        }

        public Criteria andProcessNodeProcessLike(String value) {
            addCriterion("process_node_process like", value, "processNodeProcess");
            return (Criteria) this;
        }

        public Criteria andProcessNodeProcessNotLike(String value) {
            addCriterion("process_node_process not like", value, "processNodeProcess");
            return (Criteria) this;
        }

        public Criteria andProcessNodeProcessIn(List<String> values) {
            addCriterion("process_node_process in", values, "processNodeProcess");
            return (Criteria) this;
        }

        public Criteria andProcessNodeProcessNotIn(List<String> values) {
            addCriterion("process_node_process not in", values, "processNodeProcess");
            return (Criteria) this;
        }

        public Criteria andProcessNodeProcessBetween(String value1, String value2) {
            addCriterion("process_node_process between", value1, value2, "processNodeProcess");
            return (Criteria) this;
        }

        public Criteria andProcessNodeProcessNotBetween(String value1, String value2) {
            addCriterion("process_node_process not between", value1, value2, "processNodeProcess");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameIsNull() {
            addCriterion("process_node_name is null");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameIsNotNull() {
            addCriterion("process_node_name is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameEqualTo(String value) {
            addCriterion("process_node_name =", value, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameNotEqualTo(String value) {
            addCriterion("process_node_name <>", value, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameGreaterThan(String value) {
            addCriterion("process_node_name >", value, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("process_node_name >=", value, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameLessThan(String value) {
            addCriterion("process_node_name <", value, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameLessThanOrEqualTo(String value) {
            addCriterion("process_node_name <=", value, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameLike(String value) {
            addCriterion("process_node_name like", value, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameNotLike(String value) {
            addCriterion("process_node_name not like", value, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameIn(List<String> values) {
            addCriterion("process_node_name in", values, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameNotIn(List<String> values) {
            addCriterion("process_node_name not in", values, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameBetween(String value1, String value2) {
            addCriterion("process_node_name between", value1, value2, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeNameNotBetween(String value1, String value2) {
            addCriterion("process_node_name not between", value1, value2, "processNodeName");
            return (Criteria) this;
        }

        public Criteria andProcessNodeDepartmentIsNull() {
            addCriterion("process_node_department is null");
            return (Criteria) this;
        }

        public Criteria andProcessNodeDepartmentIsNotNull() {
            addCriterion("process_node_department is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNodeDepartmentEqualTo(String value) {
            addCriterion("process_node_department =", value, "processNodeDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessNodeDepartmentNotEqualTo(String value) {
            addCriterion("process_node_department <>", value, "processNodeDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessNodeDepartmentGreaterThan(String value) {
            addCriterion("process_node_department >", value, "processNodeDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessNodeDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("process_node_department >=", value, "processNodeDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessNodeDepartmentLessThan(String value) {
            addCriterion("process_node_department <", value, "processNodeDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessNodeDepartmentLessThanOrEqualTo(String value) {
            addCriterion("process_node_department <=", value, "processNodeDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessNodeDepartmentLike(String value) {
            addCriterion("process_node_department like", value, "processNodeDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessNodeDepartmentNotLike(String value) {
            addCriterion("process_node_department not like", value, "processNodeDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessNodeDepartmentIn(List<String> values) {
            addCriterion("process_node_department in", values, "processNodeDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessNodeDepartmentNotIn(List<String> values) {
            addCriterion("process_node_department not in", values, "processNodeDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessNodeDepartmentBetween(String value1, String value2) {
            addCriterion("process_node_department between", value1, value2, "processNodeDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessNodeDepartmentNotBetween(String value1, String value2) {
            addCriterion("process_node_department not between", value1, value2, "processNodeDepartment");
            return (Criteria) this;
        }

        public Criteria andProcessNodePositionIsNull() {
            addCriterion("process_node_position is null");
            return (Criteria) this;
        }

        public Criteria andProcessNodePositionIsNotNull() {
            addCriterion("process_node_position is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNodePositionEqualTo(String value) {
            addCriterion("process_node_position =", value, "processNodePosition");
            return (Criteria) this;
        }

        public Criteria andProcessNodePositionNotEqualTo(String value) {
            addCriterion("process_node_position <>", value, "processNodePosition");
            return (Criteria) this;
        }

        public Criteria andProcessNodePositionGreaterThan(String value) {
            addCriterion("process_node_position >", value, "processNodePosition");
            return (Criteria) this;
        }

        public Criteria andProcessNodePositionGreaterThanOrEqualTo(String value) {
            addCriterion("process_node_position >=", value, "processNodePosition");
            return (Criteria) this;
        }

        public Criteria andProcessNodePositionLessThan(String value) {
            addCriterion("process_node_position <", value, "processNodePosition");
            return (Criteria) this;
        }

        public Criteria andProcessNodePositionLessThanOrEqualTo(String value) {
            addCriterion("process_node_position <=", value, "processNodePosition");
            return (Criteria) this;
        }

        public Criteria andProcessNodePositionLike(String value) {
            addCriterion("process_node_position like", value, "processNodePosition");
            return (Criteria) this;
        }

        public Criteria andProcessNodePositionNotLike(String value) {
            addCriterion("process_node_position not like", value, "processNodePosition");
            return (Criteria) this;
        }

        public Criteria andProcessNodePositionIn(List<String> values) {
            addCriterion("process_node_position in", values, "processNodePosition");
            return (Criteria) this;
        }

        public Criteria andProcessNodePositionNotIn(List<String> values) {
            addCriterion("process_node_position not in", values, "processNodePosition");
            return (Criteria) this;
        }

        public Criteria andProcessNodePositionBetween(String value1, String value2) {
            addCriterion("process_node_position between", value1, value2, "processNodePosition");
            return (Criteria) this;
        }

        public Criteria andProcessNodePositionNotBetween(String value1, String value2) {
            addCriterion("process_node_position not between", value1, value2, "processNodePosition");
            return (Criteria) this;
        }

        public Criteria andProcessNodeStepIsNull() {
            addCriterion("process_node_step is null");
            return (Criteria) this;
        }

        public Criteria andProcessNodeStepIsNotNull() {
            addCriterion("process_node_step is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNodeStepEqualTo(Integer value) {
            addCriterion("process_node_step =", value, "processNodeStep");
            return (Criteria) this;
        }

        public Criteria andProcessNodeStepNotEqualTo(Integer value) {
            addCriterion("process_node_step <>", value, "processNodeStep");
            return (Criteria) this;
        }

        public Criteria andProcessNodeStepGreaterThan(Integer value) {
            addCriterion("process_node_step >", value, "processNodeStep");
            return (Criteria) this;
        }

        public Criteria andProcessNodeStepGreaterThanOrEqualTo(Integer value) {
            addCriterion("process_node_step >=", value, "processNodeStep");
            return (Criteria) this;
        }

        public Criteria andProcessNodeStepLessThan(Integer value) {
            addCriterion("process_node_step <", value, "processNodeStep");
            return (Criteria) this;
        }

        public Criteria andProcessNodeStepLessThanOrEqualTo(Integer value) {
            addCriterion("process_node_step <=", value, "processNodeStep");
            return (Criteria) this;
        }

        public Criteria andProcessNodeStepIn(List<Integer> values) {
            addCriterion("process_node_step in", values, "processNodeStep");
            return (Criteria) this;
        }

        public Criteria andProcessNodeStepNotIn(List<Integer> values) {
            addCriterion("process_node_step not in", values, "processNodeStep");
            return (Criteria) this;
        }

        public Criteria andProcessNodeStepBetween(Integer value1, Integer value2) {
            addCriterion("process_node_step between", value1, value2, "processNodeStep");
            return (Criteria) this;
        }

        public Criteria andProcessNodeStepNotBetween(Integer value1, Integer value2) {
            addCriterion("process_node_step not between", value1, value2, "processNodeStep");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIsdeleteIsNull() {
            addCriterion("process_node_isdelete is null");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIsdeleteIsNotNull() {
            addCriterion("process_node_isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIsdeleteEqualTo(Integer value) {
            addCriterion("process_node_isdelete =", value, "processNodeIsdelete");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIsdeleteNotEqualTo(Integer value) {
            addCriterion("process_node_isdelete <>", value, "processNodeIsdelete");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIsdeleteGreaterThan(Integer value) {
            addCriterion("process_node_isdelete >", value, "processNodeIsdelete");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("process_node_isdelete >=", value, "processNodeIsdelete");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIsdeleteLessThan(Integer value) {
            addCriterion("process_node_isdelete <", value, "processNodeIsdelete");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("process_node_isdelete <=", value, "processNodeIsdelete");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIsdeleteIn(List<Integer> values) {
            addCriterion("process_node_isdelete in", values, "processNodeIsdelete");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIsdeleteNotIn(List<Integer> values) {
            addCriterion("process_node_isdelete not in", values, "processNodeIsdelete");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("process_node_isdelete between", value1, value2, "processNodeIsdelete");
            return (Criteria) this;
        }

        public Criteria andProcessNodeIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("process_node_isdelete not between", value1, value2, "processNodeIsdelete");
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