package com.qf.shopping.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdvertismentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdvertismentExample() {
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

        public Criteria andAdTypeIsNull() {
            addCriterion("adType is null");
            return (Criteria) this;
        }

        public Criteria andAdTypeIsNotNull() {
            addCriterion("adType is not null");
            return (Criteria) this;
        }

        public Criteria andAdTypeEqualTo(String value) {
            addCriterion("adType =", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeNotEqualTo(String value) {
            addCriterion("adType <>", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeGreaterThan(String value) {
            addCriterion("adType >", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("adType >=", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeLessThan(String value) {
            addCriterion("adType <", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeLessThanOrEqualTo(String value) {
            addCriterion("adType <=", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeLike(String value) {
            addCriterion("adType like", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeNotLike(String value) {
            addCriterion("adType not like", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeIn(List<String> values) {
            addCriterion("adType in", values, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeNotIn(List<String> values) {
            addCriterion("adType not in", values, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeBetween(String value1, String value2) {
            addCriterion("adType between", value1, value2, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeNotBetween(String value1, String value2) {
            addCriterion("adType not between", value1, value2, "adType");
            return (Criteria) this;
        }

        public Criteria andActionUrlIsNull() {
            addCriterion("actionUrl is null");
            return (Criteria) this;
        }

        public Criteria andActionUrlIsNotNull() {
            addCriterion("actionUrl is not null");
            return (Criteria) this;
        }

        public Criteria andActionUrlEqualTo(String value) {
            addCriterion("actionUrl =", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlNotEqualTo(String value) {
            addCriterion("actionUrl <>", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlGreaterThan(String value) {
            addCriterion("actionUrl >", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlGreaterThanOrEqualTo(String value) {
            addCriterion("actionUrl >=", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlLessThan(String value) {
            addCriterion("actionUrl <", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlLessThanOrEqualTo(String value) {
            addCriterion("actionUrl <=", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlLike(String value) {
            addCriterion("actionUrl like", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlNotLike(String value) {
            addCriterion("actionUrl not like", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlIn(List<String> values) {
            addCriterion("actionUrl in", values, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlNotIn(List<String> values) {
            addCriterion("actionUrl not in", values, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlBetween(String value1, String value2) {
            addCriterion("actionUrl between", value1, value2, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlNotBetween(String value1, String value2) {
            addCriterion("actionUrl not between", value1, value2, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andImgPathIsNull() {
            addCriterion("imgPath is null");
            return (Criteria) this;
        }

        public Criteria andImgPathIsNotNull() {
            addCriterion("imgPath is not null");
            return (Criteria) this;
        }

        public Criteria andImgPathEqualTo(String value) {
            addCriterion("imgPath =", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathNotEqualTo(String value) {
            addCriterion("imgPath <>", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathGreaterThan(String value) {
            addCriterion("imgPath >", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathGreaterThanOrEqualTo(String value) {
            addCriterion("imgPath >=", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathLessThan(String value) {
            addCriterion("imgPath <", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathLessThanOrEqualTo(String value) {
            addCriterion("imgPath <=", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathLike(String value) {
            addCriterion("imgPath like", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathNotLike(String value) {
            addCriterion("imgPath not like", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathIn(List<String> values) {
            addCriterion("imgPath in", values, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathNotIn(List<String> values) {
            addCriterion("imgPath not in", values, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathBetween(String value1, String value2) {
            addCriterion("imgPath between", value1, value2, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathNotBetween(String value1, String value2) {
            addCriterion("imgPath not between", value1, value2, "imgPath");
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
            addCriterion("adStartTime =", value, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeNotEqualTo(Date value) {
            addCriterion("adStartTime <>", value, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeGreaterThan(Date value) {
            addCriterion("adStartTime >", value, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("adStartTime >=", value, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeLessThan(Date value) {
            addCriterion("adStartTime <", value, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("adStartTime <=", value, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeIn(List<Date> values) {
            addCriterion("adStartTime in", values, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeNotIn(List<Date> values) {
            addCriterion("adStartTime not in", values, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeBetween(Date value1, Date value2) {
            addCriterion("adStartTime between", value1, value2, "adStartTime");
            return (Criteria) this;
        }

        public Criteria andAdStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("adStartTime not between", value1, value2, "adStartTime");
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