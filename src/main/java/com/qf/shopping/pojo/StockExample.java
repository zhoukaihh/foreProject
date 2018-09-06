package com.qf.shopping.pojo;

import java.util.ArrayList;
import java.util.List;

public class StockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockExample() {
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

        public Criteria andStockIdIsNull() {
            addCriterion("stockId is null");
            return (Criteria) this;
        }

        public Criteria andStockIdIsNotNull() {
            addCriterion("stockId is not null");
            return (Criteria) this;
        }

        public Criteria andStockIdEqualTo(Integer value) {
            addCriterion("stockId =", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotEqualTo(Integer value) {
            addCriterion("stockId <>", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdGreaterThan(Integer value) {
            addCriterion("stockId >", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stockId >=", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdLessThan(Integer value) {
            addCriterion("stockId <", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdLessThanOrEqualTo(Integer value) {
            addCriterion("stockId <=", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdIn(List<Integer> values) {
            addCriterion("stockId in", values, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotIn(List<Integer> values) {
            addCriterion("stockId not in", values, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdBetween(Integer value1, Integer value2) {
            addCriterion("stockId between", value1, value2, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stockId not between", value1, value2, "stockId");
            return (Criteria) this;
        }

        public Criteria andGoodIdIsNull() {
            addCriterion("goodId is null");
            return (Criteria) this;
        }

        public Criteria andGoodIdIsNotNull() {
            addCriterion("goodId is not null");
            return (Criteria) this;
        }

        public Criteria andGoodIdEqualTo(Integer value) {
            addCriterion("goodId =", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotEqualTo(Integer value) {
            addCriterion("goodId <>", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdGreaterThan(Integer value) {
            addCriterion("goodId >", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodId >=", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLessThan(Integer value) {
            addCriterion("goodId <", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdLessThanOrEqualTo(Integer value) {
            addCriterion("goodId <=", value, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdIn(List<Integer> values) {
            addCriterion("goodId in", values, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotIn(List<Integer> values) {
            addCriterion("goodId not in", values, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdBetween(Integer value1, Integer value2) {
            addCriterion("goodId between", value1, value2, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goodId not between", value1, value2, "goodId");
            return (Criteria) this;
        }

        public Criteria andGoodStockNumIsNull() {
            addCriterion("goodStockNum is null");
            return (Criteria) this;
        }

        public Criteria andGoodStockNumIsNotNull() {
            addCriterion("goodStockNum is not null");
            return (Criteria) this;
        }

        public Criteria andGoodStockNumEqualTo(Integer value) {
            addCriterion("goodStockNum =", value, "goodStockNum");
            return (Criteria) this;
        }

        public Criteria andGoodStockNumNotEqualTo(Integer value) {
            addCriterion("goodStockNum <>", value, "goodStockNum");
            return (Criteria) this;
        }

        public Criteria andGoodStockNumGreaterThan(Integer value) {
            addCriterion("goodStockNum >", value, "goodStockNum");
            return (Criteria) this;
        }

        public Criteria andGoodStockNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodStockNum >=", value, "goodStockNum");
            return (Criteria) this;
        }

        public Criteria andGoodStockNumLessThan(Integer value) {
            addCriterion("goodStockNum <", value, "goodStockNum");
            return (Criteria) this;
        }

        public Criteria andGoodStockNumLessThanOrEqualTo(Integer value) {
            addCriterion("goodStockNum <=", value, "goodStockNum");
            return (Criteria) this;
        }

        public Criteria andGoodStockNumIn(List<Integer> values) {
            addCriterion("goodStockNum in", values, "goodStockNum");
            return (Criteria) this;
        }

        public Criteria andGoodStockNumNotIn(List<Integer> values) {
            addCriterion("goodStockNum not in", values, "goodStockNum");
            return (Criteria) this;
        }

        public Criteria andGoodStockNumBetween(Integer value1, Integer value2) {
            addCriterion("goodStockNum between", value1, value2, "goodStockNum");
            return (Criteria) this;
        }

        public Criteria andGoodStockNumNotBetween(Integer value1, Integer value2) {
            addCriterion("goodStockNum not between", value1, value2, "goodStockNum");
            return (Criteria) this;
        }

        public Criteria andGoodLockNumIsNull() {
            addCriterion("goodLockNum is null");
            return (Criteria) this;
        }

        public Criteria andGoodLockNumIsNotNull() {
            addCriterion("goodLockNum is not null");
            return (Criteria) this;
        }

        public Criteria andGoodLockNumEqualTo(Integer value) {
            addCriterion("goodLockNum =", value, "goodLockNum");
            return (Criteria) this;
        }

        public Criteria andGoodLockNumNotEqualTo(Integer value) {
            addCriterion("goodLockNum <>", value, "goodLockNum");
            return (Criteria) this;
        }

        public Criteria andGoodLockNumGreaterThan(Integer value) {
            addCriterion("goodLockNum >", value, "goodLockNum");
            return (Criteria) this;
        }

        public Criteria andGoodLockNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodLockNum >=", value, "goodLockNum");
            return (Criteria) this;
        }

        public Criteria andGoodLockNumLessThan(Integer value) {
            addCriterion("goodLockNum <", value, "goodLockNum");
            return (Criteria) this;
        }

        public Criteria andGoodLockNumLessThanOrEqualTo(Integer value) {
            addCriterion("goodLockNum <=", value, "goodLockNum");
            return (Criteria) this;
        }

        public Criteria andGoodLockNumIn(List<Integer> values) {
            addCriterion("goodLockNum in", values, "goodLockNum");
            return (Criteria) this;
        }

        public Criteria andGoodLockNumNotIn(List<Integer> values) {
            addCriterion("goodLockNum not in", values, "goodLockNum");
            return (Criteria) this;
        }

        public Criteria andGoodLockNumBetween(Integer value1, Integer value2) {
            addCriterion("goodLockNum between", value1, value2, "goodLockNum");
            return (Criteria) this;
        }

        public Criteria andGoodLockNumNotBetween(Integer value1, Integer value2) {
            addCriterion("goodLockNum not between", value1, value2, "goodLockNum");
            return (Criteria) this;
        }

        public Criteria andGoodWarnNumIsNull() {
            addCriterion("goodWarnNum is null");
            return (Criteria) this;
        }

        public Criteria andGoodWarnNumIsNotNull() {
            addCriterion("goodWarnNum is not null");
            return (Criteria) this;
        }

        public Criteria andGoodWarnNumEqualTo(Integer value) {
            addCriterion("goodWarnNum =", value, "goodWarnNum");
            return (Criteria) this;
        }

        public Criteria andGoodWarnNumNotEqualTo(Integer value) {
            addCriterion("goodWarnNum <>", value, "goodWarnNum");
            return (Criteria) this;
        }

        public Criteria andGoodWarnNumGreaterThan(Integer value) {
            addCriterion("goodWarnNum >", value, "goodWarnNum");
            return (Criteria) this;
        }

        public Criteria andGoodWarnNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodWarnNum >=", value, "goodWarnNum");
            return (Criteria) this;
        }

        public Criteria andGoodWarnNumLessThan(Integer value) {
            addCriterion("goodWarnNum <", value, "goodWarnNum");
            return (Criteria) this;
        }

        public Criteria andGoodWarnNumLessThanOrEqualTo(Integer value) {
            addCriterion("goodWarnNum <=", value, "goodWarnNum");
            return (Criteria) this;
        }

        public Criteria andGoodWarnNumIn(List<Integer> values) {
            addCriterion("goodWarnNum in", values, "goodWarnNum");
            return (Criteria) this;
        }

        public Criteria andGoodWarnNumNotIn(List<Integer> values) {
            addCriterion("goodWarnNum not in", values, "goodWarnNum");
            return (Criteria) this;
        }

        public Criteria andGoodWarnNumBetween(Integer value1, Integer value2) {
            addCriterion("goodWarnNum between", value1, value2, "goodWarnNum");
            return (Criteria) this;
        }

        public Criteria andGoodWarnNumNotBetween(Integer value1, Integer value2) {
            addCriterion("goodWarnNum not between", value1, value2, "goodWarnNum");
            return (Criteria) this;
        }

        public Criteria and_versionIsNull() {
            addCriterion("_version is null");
            return (Criteria) this;
        }

        public Criteria and_versionIsNotNull() {
            addCriterion("_version is not null");
            return (Criteria) this;
        }

        public Criteria and_versionEqualTo(String value) {
            addCriterion("_version =", value, "_version");
            return (Criteria) this;
        }

        public Criteria and_versionNotEqualTo(String value) {
            addCriterion("_version <>", value, "_version");
            return (Criteria) this;
        }

        public Criteria and_versionGreaterThan(String value) {
            addCriterion("_version >", value, "_version");
            return (Criteria) this;
        }

        public Criteria and_versionGreaterThanOrEqualTo(String value) {
            addCriterion("_version >=", value, "_version");
            return (Criteria) this;
        }

        public Criteria and_versionLessThan(String value) {
            addCriterion("_version <", value, "_version");
            return (Criteria) this;
        }

        public Criteria and_versionLessThanOrEqualTo(String value) {
            addCriterion("_version <=", value, "_version");
            return (Criteria) this;
        }

        public Criteria and_versionLike(String value) {
            addCriterion("_version like", value, "_version");
            return (Criteria) this;
        }

        public Criteria and_versionNotLike(String value) {
            addCriterion("_version not like", value, "_version");
            return (Criteria) this;
        }

        public Criteria and_versionIn(List<String> values) {
            addCriterion("_version in", values, "_version");
            return (Criteria) this;
        }

        public Criteria and_versionNotIn(List<String> values) {
            addCriterion("_version not in", values, "_version");
            return (Criteria) this;
        }

        public Criteria and_versionBetween(String value1, String value2) {
            addCriterion("_version between", value1, value2, "_version");
            return (Criteria) this;
        }

        public Criteria and_versionNotBetween(String value1, String value2) {
            addCriterion("_version not between", value1, value2, "_version");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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