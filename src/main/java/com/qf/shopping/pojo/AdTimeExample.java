package com.qf.shopping.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AdTimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdTimeExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andAdIdIsNull() {
            addCriterion("adId is null");
            return (Criteria) this;
        }

        public Criteria andAdIdIsNotNull() {
            addCriterion("adId is not null");
            return (Criteria) this;
        }

        public Criteria andAdIdEqualTo(Integer value) {
            addCriterion("adId =", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotEqualTo(Integer value) {
            addCriterion("adId <>", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdGreaterThan(Integer value) {
            addCriterion("adId >", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("adId >=", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdLessThan(Integer value) {
            addCriterion("adId <", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdLessThanOrEqualTo(Integer value) {
            addCriterion("adId <=", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdIn(List<Integer> values) {
            addCriterion("adId in", values, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotIn(List<Integer> values) {
            addCriterion("adId not in", values, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdBetween(Integer value1, Integer value2) {
            addCriterion("adId between", value1, value2, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("adId not between", value1, value2, "adId");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeIsNull() {
            addCriterion("adStartTime is null");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeIsNotNull() {
            addCriterion("adStartTime is not null");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("adStartTime =", value, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("adStartTime <>", value, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("adStartTime >", value, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("adStartTime >=", value, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeLessThan(Date value) {
            addCriterionForJDBCDate("adStartTime <", value, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("adStartTime <=", value, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("adStartTime in", values, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("adStartTime not in", values, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("adStartTime between", value1, value2, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("adStartTime not between", value1, value2, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeIsNull() {
            addCriterion("adEndTime is null");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeIsNotNull() {
            addCriterion("adEndTime is not null");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("adEndTime =", value, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("adEndTime <>", value, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("adEndTime >", value, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("adEndTime >=", value, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("adEndTime <", value, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("adEndTime <=", value, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("adEndTime in", values, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("adEndTime not in", values, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("adEndTime between", value1, value2, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("adEndTime not between", value1, value2, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdDetailIsNull() {
            addCriterion("adDetail is null");
            return (Criteria) this;
        }

        public Criteria andAdDetailIsNotNull() {
            addCriterion("adDetail is not null");
            return (Criteria) this;
        }

        public Criteria andAdDetailEqualTo(String value) {
            addCriterion("adDetail =", value, "adDetail");
            return (Criteria) this;
        }

        public Criteria andAdDetailNotEqualTo(String value) {
            addCriterion("adDetail <>", value, "adDetail");
            return (Criteria) this;
        }

        public Criteria andAdDetailGreaterThan(String value) {
            addCriterion("adDetail >", value, "adDetail");
            return (Criteria) this;
        }

        public Criteria andAdDetailGreaterThanOrEqualTo(String value) {
            addCriterion("adDetail >=", value, "adDetail");
            return (Criteria) this;
        }

        public Criteria andAdDetailLessThan(String value) {
            addCriterion("adDetail <", value, "adDetail");
            return (Criteria) this;
        }

        public Criteria andAdDetailLessThanOrEqualTo(String value) {
            addCriterion("adDetail <=", value, "adDetail");
            return (Criteria) this;
        }

        public Criteria andAdDetailLike(String value) {
            addCriterion("adDetail like", value, "adDetail");
            return (Criteria) this;
        }

        public Criteria andAdDetailNotLike(String value) {
            addCriterion("adDetail not like", value, "adDetail");
            return (Criteria) this;
        }

        public Criteria andAdDetailIn(List<String> values) {
            addCriterion("adDetail in", values, "adDetail");
            return (Criteria) this;
        }

        public Criteria andAdDetailNotIn(List<String> values) {
            addCriterion("adDetail not in", values, "adDetail");
            return (Criteria) this;
        }

        public Criteria andAdDetailBetween(String value1, String value2) {
            addCriterion("adDetail between", value1, value2, "adDetail");
            return (Criteria) this;
        }

        public Criteria andAdDetailNotBetween(String value1, String value2) {
            addCriterion("adDetail not between", value1, value2, "adDetail");
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