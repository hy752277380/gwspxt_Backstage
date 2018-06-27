package com.kcsj.gwglxt.entity;

import java.util.ArrayList;
import java.util.List;

public class MobjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MobjectExample() {
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

        public Criteria andMobjectIdIsNull() {
            addCriterion("mobject_id is null");
            return (Criteria) this;
        }

        public Criteria andMobjectIdIsNotNull() {
            addCriterion("mobject_id is not null");
            return (Criteria) this;
        }

        public Criteria andMobjectIdEqualTo(String value) {
            addCriterion("mobject_id =", value, "mobjectId");
            return (Criteria) this;
        }

        public Criteria andMobjectIdNotEqualTo(String value) {
            addCriterion("mobject_id <>", value, "mobjectId");
            return (Criteria) this;
        }

        public Criteria andMobjectIdGreaterThan(String value) {
            addCriterion("mobject_id >", value, "mobjectId");
            return (Criteria) this;
        }

        public Criteria andMobjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("mobject_id >=", value, "mobjectId");
            return (Criteria) this;
        }

        public Criteria andMobjectIdLessThan(String value) {
            addCriterion("mobject_id <", value, "mobjectId");
            return (Criteria) this;
        }

        public Criteria andMobjectIdLessThanOrEqualTo(String value) {
            addCriterion("mobject_id <=", value, "mobjectId");
            return (Criteria) this;
        }

        public Criteria andMobjectIdLike(String value) {
            addCriterion("mobject_id like", value, "mobjectId");
            return (Criteria) this;
        }

        public Criteria andMobjectIdNotLike(String value) {
            addCriterion("mobject_id not like", value, "mobjectId");
            return (Criteria) this;
        }

        public Criteria andMobjectIdIn(List<String> values) {
            addCriterion("mobject_id in", values, "mobjectId");
            return (Criteria) this;
        }

        public Criteria andMobjectIdNotIn(List<String> values) {
            addCriterion("mobject_id not in", values, "mobjectId");
            return (Criteria) this;
        }

        public Criteria andMobjectIdBetween(String value1, String value2) {
            addCriterion("mobject_id between", value1, value2, "mobjectId");
            return (Criteria) this;
        }

        public Criteria andMobjectIdNotBetween(String value1, String value2) {
            addCriterion("mobject_id not between", value1, value2, "mobjectId");
            return (Criteria) this;
        }

        public Criteria andMobjectUserIsNull() {
            addCriterion("mobject_user is null");
            return (Criteria) this;
        }

        public Criteria andMobjectUserIsNotNull() {
            addCriterion("mobject_user is not null");
            return (Criteria) this;
        }

        public Criteria andMobjectUserEqualTo(String value) {
            addCriterion("mobject_user =", value, "mobjectUser");
            return (Criteria) this;
        }

        public Criteria andMobjectUserNotEqualTo(String value) {
            addCriterion("mobject_user <>", value, "mobjectUser");
            return (Criteria) this;
        }

        public Criteria andMobjectUserGreaterThan(String value) {
            addCriterion("mobject_user >", value, "mobjectUser");
            return (Criteria) this;
        }

        public Criteria andMobjectUserGreaterThanOrEqualTo(String value) {
            addCriterion("mobject_user >=", value, "mobjectUser");
            return (Criteria) this;
        }

        public Criteria andMobjectUserLessThan(String value) {
            addCriterion("mobject_user <", value, "mobjectUser");
            return (Criteria) this;
        }

        public Criteria andMobjectUserLessThanOrEqualTo(String value) {
            addCriterion("mobject_user <=", value, "mobjectUser");
            return (Criteria) this;
        }

        public Criteria andMobjectUserLike(String value) {
            addCriterion("mobject_user like", value, "mobjectUser");
            return (Criteria) this;
        }

        public Criteria andMobjectUserNotLike(String value) {
            addCriterion("mobject_user not like", value, "mobjectUser");
            return (Criteria) this;
        }

        public Criteria andMobjectUserIn(List<String> values) {
            addCriterion("mobject_user in", values, "mobjectUser");
            return (Criteria) this;
        }

        public Criteria andMobjectUserNotIn(List<String> values) {
            addCriterion("mobject_user not in", values, "mobjectUser");
            return (Criteria) this;
        }

        public Criteria andMobjectUserBetween(String value1, String value2) {
            addCriterion("mobject_user between", value1, value2, "mobjectUser");
            return (Criteria) this;
        }

        public Criteria andMobjectUserNotBetween(String value1, String value2) {
            addCriterion("mobject_user not between", value1, value2, "mobjectUser");
            return (Criteria) this;
        }

        public Criteria andMobjectMessageIsNull() {
            addCriterion("mobject_message is null");
            return (Criteria) this;
        }

        public Criteria andMobjectMessageIsNotNull() {
            addCriterion("mobject_message is not null");
            return (Criteria) this;
        }

        public Criteria andMobjectMessageEqualTo(String value) {
            addCriterion("mobject_message =", value, "mobjectMessage");
            return (Criteria) this;
        }

        public Criteria andMobjectMessageNotEqualTo(String value) {
            addCriterion("mobject_message <>", value, "mobjectMessage");
            return (Criteria) this;
        }

        public Criteria andMobjectMessageGreaterThan(String value) {
            addCriterion("mobject_message >", value, "mobjectMessage");
            return (Criteria) this;
        }

        public Criteria andMobjectMessageGreaterThanOrEqualTo(String value) {
            addCriterion("mobject_message >=", value, "mobjectMessage");
            return (Criteria) this;
        }

        public Criteria andMobjectMessageLessThan(String value) {
            addCriterion("mobject_message <", value, "mobjectMessage");
            return (Criteria) this;
        }

        public Criteria andMobjectMessageLessThanOrEqualTo(String value) {
            addCriterion("mobject_message <=", value, "mobjectMessage");
            return (Criteria) this;
        }

        public Criteria andMobjectMessageLike(String value) {
            addCriterion("mobject_message like", value, "mobjectMessage");
            return (Criteria) this;
        }

        public Criteria andMobjectMessageNotLike(String value) {
            addCriterion("mobject_message not like", value, "mobjectMessage");
            return (Criteria) this;
        }

        public Criteria andMobjectMessageIn(List<String> values) {
            addCriterion("mobject_message in", values, "mobjectMessage");
            return (Criteria) this;
        }

        public Criteria andMobjectMessageNotIn(List<String> values) {
            addCriterion("mobject_message not in", values, "mobjectMessage");
            return (Criteria) this;
        }

        public Criteria andMobjectMessageBetween(String value1, String value2) {
            addCriterion("mobject_message between", value1, value2, "mobjectMessage");
            return (Criteria) this;
        }

        public Criteria andMobjectMessageNotBetween(String value1, String value2) {
            addCriterion("mobject_message not between", value1, value2, "mobjectMessage");
            return (Criteria) this;
        }

        public Criteria andMobjectIsreadIsNull() {
            addCriterion("mobject_isread is null");
            return (Criteria) this;
        }

        public Criteria andMobjectIsreadIsNotNull() {
            addCriterion("mobject_isread is not null");
            return (Criteria) this;
        }

        public Criteria andMobjectIsreadEqualTo(Integer value) {
            addCriterion("mobject_isread =", value, "mobjectIsread");
            return (Criteria) this;
        }

        public Criteria andMobjectIsreadNotEqualTo(Integer value) {
            addCriterion("mobject_isread <>", value, "mobjectIsread");
            return (Criteria) this;
        }

        public Criteria andMobjectIsreadGreaterThan(Integer value) {
            addCriterion("mobject_isread >", value, "mobjectIsread");
            return (Criteria) this;
        }

        public Criteria andMobjectIsreadGreaterThanOrEqualTo(Integer value) {
            addCriterion("mobject_isread >=", value, "mobjectIsread");
            return (Criteria) this;
        }

        public Criteria andMobjectIsreadLessThan(Integer value) {
            addCriterion("mobject_isread <", value, "mobjectIsread");
            return (Criteria) this;
        }

        public Criteria andMobjectIsreadLessThanOrEqualTo(Integer value) {
            addCriterion("mobject_isread <=", value, "mobjectIsread");
            return (Criteria) this;
        }

        public Criteria andMobjectIsreadIn(List<Integer> values) {
            addCriterion("mobject_isread in", values, "mobjectIsread");
            return (Criteria) this;
        }

        public Criteria andMobjectIsreadNotIn(List<Integer> values) {
            addCriterion("mobject_isread not in", values, "mobjectIsread");
            return (Criteria) this;
        }

        public Criteria andMobjectIsreadBetween(Integer value1, Integer value2) {
            addCriterion("mobject_isread between", value1, value2, "mobjectIsread");
            return (Criteria) this;
        }

        public Criteria andMobjectIsreadNotBetween(Integer value1, Integer value2) {
            addCriterion("mobject_isread not between", value1, value2, "mobjectIsread");
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