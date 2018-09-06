package com.qf.shopping.pojo;

import java.util.ArrayList;
import java.util.List;

public class FirstTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FirstTypeExample() {
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

        public Criteria andFirstTypeIdIsNull() {
            addCriterion("firstTypeId is null");
            return (Criteria) this;
        }

        public Criteria andFirstTypeIdIsNotNull() {
            addCriterion("firstTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andFirstTypeIdEqualTo(Integer value) {
            addCriterion("firstTypeId =", value, "firstTypeId");
            return (Criteria) this;
        }

        public Criteria andFirstTypeIdNotEqualTo(Integer value) {
            addCriterion("firstTypeId <>", value, "firstTypeId");
            return (Criteria) this;
        }

        public Criteria andFirstTypeIdGreaterThan(Integer value) {
            addCriterion("firstTypeId >", value, "firstTypeId");
            return (Criteria) this;
        }

        public Criteria andFirstTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("firstTypeId >=", value, "firstTypeId");
            return (Criteria) this;
        }

        public Criteria andFirstTypeIdLessThan(Integer value) {
            addCriterion("firstTypeId <", value, "firstTypeId");
            return (Criteria) this;
        }

        public Criteria andFirstTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("firstTypeId <=", value, "firstTypeId");
            return (Criteria) this;
        }

        public Criteria andFirstTypeIdIn(List<Integer> values) {
            addCriterion("firstTypeId in", values, "firstTypeId");
            return (Criteria) this;
        }

        public Criteria andFirstTypeIdNotIn(List<Integer> values) {
            addCriterion("firstTypeId not in", values, "firstTypeId");
            return (Criteria) this;
        }

        public Criteria andFirstTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("firstTypeId between", value1, value2, "firstTypeId");
            return (Criteria) this;
        }

        public Criteria andFirstTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("firstTypeId not between", value1, value2, "firstTypeId");
            return (Criteria) this;
        }

        public Criteria andFirstTypeNameIsNull() {
            addCriterion("firstTypeName is null");
            return (Criteria) this;
        }

        public Criteria andFirstTypeNameIsNotNull() {
            addCriterion("firstTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andFirstTypeNameEqualTo(String value) {
            addCriterion("firstTypeName =", value, "firstTypeName");
            return (Criteria) this;
        }

        public Criteria andFirstTypeNameNotEqualTo(String value) {
            addCriterion("firstTypeName <>", value, "firstTypeName");
            return (Criteria) this;
        }

        public Criteria andFirstTypeNameGreaterThan(String value) {
            addCriterion("firstTypeName >", value, "firstTypeName");
            return (Criteria) this;
        }

        public Criteria andFirstTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("firstTypeName >=", value, "firstTypeName");
            return (Criteria) this;
        }

        public Criteria andFirstTypeNameLessThan(String value) {
            addCriterion("firstTypeName <", value, "firstTypeName");
            return (Criteria) this;
        }

        public Criteria andFirstTypeNameLessThanOrEqualTo(String value) {
            addCriterion("firstTypeName <=", value, "firstTypeName");
            return (Criteria) this;
        }

        public Criteria andFirstTypeNameLike(String value) {
            addCriterion("firstTypeName like", value, "firstTypeName");
            return (Criteria) this;
        }

        public Criteria andFirstTypeNameNotLike(String value) {
            addCriterion("firstTypeName not like", value, "firstTypeName");
            return (Criteria) this;
        }

        public Criteria andFirstTypeNameIn(List<String> values) {
            addCriterion("firstTypeName in", values, "firstTypeName");
            return (Criteria) this;
        }

        public Criteria andFirstTypeNameNotIn(List<String> values) {
            addCriterion("firstTypeName not in", values, "firstTypeName");
            return (Criteria) this;
        }

        public Criteria andFirstTypeNameBetween(String value1, String value2) {
            addCriterion("firstTypeName between", value1, value2, "firstTypeName");
            return (Criteria) this;
        }

        public Criteria andFirstTypeNameNotBetween(String value1, String value2) {
            addCriterion("firstTypeName not between", value1, value2, "firstTypeName");
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