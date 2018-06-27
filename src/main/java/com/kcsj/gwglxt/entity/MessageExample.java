package com.kcsj.gwglxt.entity;

import java.util.ArrayList;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andMessageIdIsNull() {
            addCriterion("message_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageIdIsNotNull() {
            addCriterion("message_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageIdEqualTo(String value) {
            addCriterion("message_id =", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotEqualTo(String value) {
            addCriterion("message_id <>", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThan(String value) {
            addCriterion("message_id >", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThanOrEqualTo(String value) {
            addCriterion("message_id >=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThan(String value) {
            addCriterion("message_id <", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThanOrEqualTo(String value) {
            addCriterion("message_id <=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLike(String value) {
            addCriterion("message_id like", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotLike(String value) {
            addCriterion("message_id not like", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdIn(List<String> values) {
            addCriterion("message_id in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotIn(List<String> values) {
            addCriterion("message_id not in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdBetween(String value1, String value2) {
            addCriterion("message_id between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotBetween(String value1, String value2) {
            addCriterion("message_id not between", value1, value2, "messageId");
            return (Criteria) this;
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

        public Criteria andMessageContentIsNull() {
            addCriterion("message_content is null");
            return (Criteria) this;
        }

        public Criteria andMessageContentIsNotNull() {
            addCriterion("message_content is not null");
            return (Criteria) this;
        }

        public Criteria andMessageContentEqualTo(String value) {
            addCriterion("message_content =", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotEqualTo(String value) {
            addCriterion("message_content <>", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentGreaterThan(String value) {
            addCriterion("message_content >", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentGreaterThanOrEqualTo(String value) {
            addCriterion("message_content >=", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLessThan(String value) {
            addCriterion("message_content <", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLessThanOrEqualTo(String value) {
            addCriterion("message_content <=", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLike(String value) {
            addCriterion("message_content like", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotLike(String value) {
            addCriterion("message_content not like", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentIn(List<String> values) {
            addCriterion("message_content in", values, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotIn(List<String> values) {
            addCriterion("message_content not in", values, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentBetween(String value1, String value2) {
            addCriterion("message_content between", value1, value2, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotBetween(String value1, String value2) {
            addCriterion("message_content not between", value1, value2, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageTimeIsNull() {
            addCriterion("message_time is null");
            return (Criteria) this;
        }

        public Criteria andMessageTimeIsNotNull() {
            addCriterion("message_time is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTimeEqualTo(String value) {
            addCriterion("message_time =", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeNotEqualTo(String value) {
            addCriterion("message_time <>", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeGreaterThan(String value) {
            addCriterion("message_time >", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeGreaterThanOrEqualTo(String value) {
            addCriterion("message_time >=", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeLessThan(String value) {
            addCriterion("message_time <", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeLessThanOrEqualTo(String value) {
            addCriterion("message_time <=", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeLike(String value) {
            addCriterion("message_time like", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeNotLike(String value) {
            addCriterion("message_time not like", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeIn(List<String> values) {
            addCriterion("message_time in", values, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeNotIn(List<String> values) {
            addCriterion("message_time not in", values, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeBetween(String value1, String value2) {
            addCriterion("message_time between", value1, value2, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeNotBetween(String value1, String value2) {
            addCriterion("message_time not between", value1, value2, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageIsdeleteIsNull() {
            addCriterion("message_isdelete is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsdeleteIsNotNull() {
            addCriterion("message_isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andMessageIsdeleteEqualTo(Integer value) {
            addCriterion("message_isdelete =", value, "messageIsdelete");
            return (Criteria) this;
        }

        public Criteria andMessageIsdeleteNotEqualTo(Integer value) {
            addCriterion("message_isdelete <>", value, "messageIsdelete");
            return (Criteria) this;
        }

        public Criteria andMessageIsdeleteGreaterThan(Integer value) {
            addCriterion("message_isdelete >", value, "messageIsdelete");
            return (Criteria) this;
        }

        public Criteria andMessageIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_isdelete >=", value, "messageIsdelete");
            return (Criteria) this;
        }

        public Criteria andMessageIsdeleteLessThan(Integer value) {
            addCriterion("message_isdelete <", value, "messageIsdelete");
            return (Criteria) this;
        }

        public Criteria andMessageIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("message_isdelete <=", value, "messageIsdelete");
            return (Criteria) this;
        }

        public Criteria andMessageIsdeleteIn(List<Integer> values) {
            addCriterion("message_isdelete in", values, "messageIsdelete");
            return (Criteria) this;
        }

        public Criteria andMessageIsdeleteNotIn(List<Integer> values) {
            addCriterion("message_isdelete not in", values, "messageIsdelete");
            return (Criteria) this;
        }

        public Criteria andMessageIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("message_isdelete between", value1, value2, "messageIsdelete");
            return (Criteria) this;
        }

        public Criteria andMessageIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("message_isdelete not between", value1, value2, "messageIsdelete");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIsNull() {
            addCriterion("message_type is null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIsNotNull() {
            addCriterion("message_type is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTypeEqualTo(Integer value) {
            addCriterion("message_type =", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotEqualTo(Integer value) {
            addCriterion("message_type <>", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeGreaterThan(Integer value) {
            addCriterion("message_type >", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_type >=", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLessThan(Integer value) {
            addCriterion("message_type <", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeLessThanOrEqualTo(Integer value) {
            addCriterion("message_type <=", value, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeIn(List<Integer> values) {
            addCriterion("message_type in", values, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotIn(List<Integer> values) {
            addCriterion("message_type not in", values, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeBetween(Integer value1, Integer value2) {
            addCriterion("message_type between", value1, value2, "messageType");
            return (Criteria) this;
        }

        public Criteria andMessageTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("message_type not between", value1, value2, "messageType");
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