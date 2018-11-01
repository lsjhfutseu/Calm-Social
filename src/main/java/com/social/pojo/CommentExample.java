package com.social.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andCmtuseridIsNull() {
            addCriterion("cmtUserId is null");
            return (Criteria) this;
        }

        public Criteria andCmtuseridIsNotNull() {
            addCriterion("cmtUserId is not null");
            return (Criteria) this;
        }

        public Criteria andCmtuseridEqualTo(Integer value) {
            addCriterion("cmtUserId =", value, "cmtuserid");
            return (Criteria) this;
        }

        public Criteria andCmtuseridNotEqualTo(Integer value) {
            addCriterion("cmtUserId <>", value, "cmtuserid");
            return (Criteria) this;
        }

        public Criteria andCmtuseridGreaterThan(Integer value) {
            addCriterion("cmtUserId >", value, "cmtuserid");
            return (Criteria) this;
        }

        public Criteria andCmtuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("cmtUserId >=", value, "cmtuserid");
            return (Criteria) this;
        }

        public Criteria andCmtuseridLessThan(Integer value) {
            addCriterion("cmtUserId <", value, "cmtuserid");
            return (Criteria) this;
        }

        public Criteria andCmtuseridLessThanOrEqualTo(Integer value) {
            addCriterion("cmtUserId <=", value, "cmtuserid");
            return (Criteria) this;
        }

        public Criteria andCmtuseridIn(List<Integer> values) {
            addCriterion("cmtUserId in", values, "cmtuserid");
            return (Criteria) this;
        }

        public Criteria andCmtuseridNotIn(List<Integer> values) {
            addCriterion("cmtUserId not in", values, "cmtuserid");
            return (Criteria) this;
        }

        public Criteria andCmtuseridBetween(Integer value1, Integer value2) {
            addCriterion("cmtUserId between", value1, value2, "cmtuserid");
            return (Criteria) this;
        }

        public Criteria andCmtuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("cmtUserId not between", value1, value2, "cmtuserid");
            return (Criteria) this;
        }

        public Criteria andThingsidIsNull() {
            addCriterion("thingsId is null");
            return (Criteria) this;
        }

        public Criteria andThingsidIsNotNull() {
            addCriterion("thingsId is not null");
            return (Criteria) this;
        }

        public Criteria andThingsidEqualTo(Integer value) {
            addCriterion("thingsId =", value, "thingsid");
            return (Criteria) this;
        }

        public Criteria andThingsidNotEqualTo(Integer value) {
            addCriterion("thingsId <>", value, "thingsid");
            return (Criteria) this;
        }

        public Criteria andThingsidGreaterThan(Integer value) {
            addCriterion("thingsId >", value, "thingsid");
            return (Criteria) this;
        }

        public Criteria andThingsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("thingsId >=", value, "thingsid");
            return (Criteria) this;
        }

        public Criteria andThingsidLessThan(Integer value) {
            addCriterion("thingsId <", value, "thingsid");
            return (Criteria) this;
        }

        public Criteria andThingsidLessThanOrEqualTo(Integer value) {
            addCriterion("thingsId <=", value, "thingsid");
            return (Criteria) this;
        }

        public Criteria andThingsidIn(List<Integer> values) {
            addCriterion("thingsId in", values, "thingsid");
            return (Criteria) this;
        }

        public Criteria andThingsidNotIn(List<Integer> values) {
            addCriterion("thingsId not in", values, "thingsid");
            return (Criteria) this;
        }

        public Criteria andThingsidBetween(Integer value1, Integer value2) {
            addCriterion("thingsId between", value1, value2, "thingsid");
            return (Criteria) this;
        }

        public Criteria andThingsidNotBetween(Integer value1, Integer value2) {
            addCriterion("thingsId not between", value1, value2, "thingsid");
            return (Criteria) this;
        }

        public Criteria andCmtteduseridIsNull() {
            addCriterion("cmttedUserId is null");
            return (Criteria) this;
        }

        public Criteria andCmtteduseridIsNotNull() {
            addCriterion("cmttedUserId is not null");
            return (Criteria) this;
        }

        public Criteria andCmtteduseridEqualTo(Integer value) {
            addCriterion("cmttedUserId =", value, "cmtteduserid");
            return (Criteria) this;
        }

        public Criteria andCmtteduseridNotEqualTo(Integer value) {
            addCriterion("cmttedUserId <>", value, "cmtteduserid");
            return (Criteria) this;
        }

        public Criteria andCmtteduseridGreaterThan(Integer value) {
            addCriterion("cmttedUserId >", value, "cmtteduserid");
            return (Criteria) this;
        }

        public Criteria andCmtteduseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("cmttedUserId >=", value, "cmtteduserid");
            return (Criteria) this;
        }

        public Criteria andCmtteduseridLessThan(Integer value) {
            addCriterion("cmttedUserId <", value, "cmtteduserid");
            return (Criteria) this;
        }

        public Criteria andCmtteduseridLessThanOrEqualTo(Integer value) {
            addCriterion("cmttedUserId <=", value, "cmtteduserid");
            return (Criteria) this;
        }

        public Criteria andCmtteduseridIn(List<Integer> values) {
            addCriterion("cmttedUserId in", values, "cmtteduserid");
            return (Criteria) this;
        }

        public Criteria andCmtteduseridNotIn(List<Integer> values) {
            addCriterion("cmttedUserId not in", values, "cmtteduserid");
            return (Criteria) this;
        }

        public Criteria andCmtteduseridBetween(Integer value1, Integer value2) {
            addCriterion("cmttedUserId between", value1, value2, "cmtteduserid");
            return (Criteria) this;
        }

        public Criteria andCmtteduseridNotBetween(Integer value1, Integer value2) {
            addCriterion("cmttedUserId not between", value1, value2, "cmtteduserid");
            return (Criteria) this;
        }

        public Criteria andPosttimeIsNull() {
            addCriterion("posttime is null");
            return (Criteria) this;
        }

        public Criteria andPosttimeIsNotNull() {
            addCriterion("posttime is not null");
            return (Criteria) this;
        }

        public Criteria andPosttimeEqualTo(Date value) {
            addCriterion("posttime =", value, "posttime");
            return (Criteria) this;
        }

        public Criteria andPosttimeNotEqualTo(Date value) {
            addCriterion("posttime <>", value, "posttime");
            return (Criteria) this;
        }

        public Criteria andPosttimeGreaterThan(Date value) {
            addCriterion("posttime >", value, "posttime");
            return (Criteria) this;
        }

        public Criteria andPosttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("posttime >=", value, "posttime");
            return (Criteria) this;
        }

        public Criteria andPosttimeLessThan(Date value) {
            addCriterion("posttime <", value, "posttime");
            return (Criteria) this;
        }

        public Criteria andPosttimeLessThanOrEqualTo(Date value) {
            addCriterion("posttime <=", value, "posttime");
            return (Criteria) this;
        }

        public Criteria andPosttimeIn(List<Date> values) {
            addCriterion("posttime in", values, "posttime");
            return (Criteria) this;
        }

        public Criteria andPosttimeNotIn(List<Date> values) {
            addCriterion("posttime not in", values, "posttime");
            return (Criteria) this;
        }

        public Criteria andPosttimeBetween(Date value1, Date value2) {
            addCriterion("posttime between", value1, value2, "posttime");
            return (Criteria) this;
        }

        public Criteria andPosttimeNotBetween(Date value1, Date value2) {
            addCriterion("posttime not between", value1, value2, "posttime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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