package com.qf.shopping.pojo;

import java.util.ArrayList;
import java.util.List;

public class AddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AddressExample() {
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

        public Criteria andAddIdIsNull() {
            addCriterion("addId is null");
            return (Criteria) this;
        }

        public Criteria andAddIdIsNotNull() {
            addCriterion("addId is not null");
            return (Criteria) this;
        }

        public Criteria andAddIdEqualTo(Integer value) {
            addCriterion("addId =", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotEqualTo(Integer value) {
            addCriterion("addId <>", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdGreaterThan(Integer value) {
            addCriterion("addId >", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("addId >=", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLessThan(Integer value) {
            addCriterion("addId <", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdLessThanOrEqualTo(Integer value) {
            addCriterion("addId <=", value, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdIn(List<Integer> values) {
            addCriterion("addId in", values, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotIn(List<Integer> values) {
            addCriterion("addId not in", values, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdBetween(Integer value1, Integer value2) {
            addCriterion("addId between", value1, value2, "addId");
            return (Criteria) this;
        }

        public Criteria andAddIdNotBetween(Integer value1, Integer value2) {
            addCriterion("addId not between", value1, value2, "addId");
            return (Criteria) this;
        }

        public Criteria andAddDetailIsNull() {
            addCriterion("addDetail is null");
            return (Criteria) this;
        }

        public Criteria andAddDetailIsNotNull() {
            addCriterion("addDetail is not null");
            return (Criteria) this;
        }

        public Criteria andAddDetailEqualTo(String value) {
            addCriterion("addDetail =", value, "addDetail");
            return (Criteria) this;
        }

        public Criteria andAddDetailNotEqualTo(String value) {
            addCriterion("addDetail <>", value, "addDetail");
            return (Criteria) this;
        }

        public Criteria andAddDetailGreaterThan(String value) {
            addCriterion("addDetail >", value, "addDetail");
            return (Criteria) this;
        }

        public Criteria andAddDetailGreaterThanOrEqualTo(String value) {
            addCriterion("addDetail >=", value, "addDetail");
            return (Criteria) this;
        }

        public Criteria andAddDetailLessThan(String value) {
            addCriterion("addDetail <", value, "addDetail");
            return (Criteria) this;
        }

        public Criteria andAddDetailLessThanOrEqualTo(String value) {
            addCriterion("addDetail <=", value, "addDetail");
            return (Criteria) this;
        }

        public Criteria andAddDetailLike(String value) {
            addCriterion("addDetail like", value, "addDetail");
            return (Criteria) this;
        }

        public Criteria andAddDetailNotLike(String value) {
            addCriterion("addDetail not like", value, "addDetail");
            return (Criteria) this;
        }

        public Criteria andAddDetailIn(List<String> values) {
            addCriterion("addDetail in", values, "addDetail");
            return (Criteria) this;
        }

        public Criteria andAddDetailNotIn(List<String> values) {
            addCriterion("addDetail not in", values, "addDetail");
            return (Criteria) this;
        }

        public Criteria andAddDetailBetween(String value1, String value2) {
            addCriterion("addDetail between", value1, value2, "addDetail");
            return (Criteria) this;
        }

        public Criteria andAddDetailNotBetween(String value1, String value2) {
            addCriterion("addDetail not between", value1, value2, "addDetail");
            return (Criteria) this;
        }

        public Criteria andAddContactPhoneIsNull() {
            addCriterion("addContactPhone is null");
            return (Criteria) this;
        }

        public Criteria andAddContactPhoneIsNotNull() {
            addCriterion("addContactPhone is not null");
            return (Criteria) this;
        }

        public Criteria andAddContactPhoneEqualTo(String value) {
            addCriterion("addContactPhone =", value, "addContactPhone");
            return (Criteria) this;
        }

        public Criteria andAddContactPhoneNotEqualTo(String value) {
            addCriterion("addContactPhone <>", value, "addContactPhone");
            return (Criteria) this;
        }

        public Criteria andAddContactPhoneGreaterThan(String value) {
            addCriterion("addContactPhone >", value, "addContactPhone");
            return (Criteria) this;
        }

        public Criteria andAddContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("addContactPhone >=", value, "addContactPhone");
            return (Criteria) this;
        }

        public Criteria andAddContactPhoneLessThan(String value) {
            addCriterion("addContactPhone <", value, "addContactPhone");
            return (Criteria) this;
        }

        public Criteria andAddContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("addContactPhone <=", value, "addContactPhone");
            return (Criteria) this;
        }

        public Criteria andAddContactPhoneLike(String value) {
            addCriterion("addContactPhone like", value, "addContactPhone");
            return (Criteria) this;
        }

        public Criteria andAddContactPhoneNotLike(String value) {
            addCriterion("addContactPhone not like", value, "addContactPhone");
            return (Criteria) this;
        }

        public Criteria andAddContactPhoneIn(List<String> values) {
            addCriterion("addContactPhone in", values, "addContactPhone");
            return (Criteria) this;
        }

        public Criteria andAddContactPhoneNotIn(List<String> values) {
            addCriterion("addContactPhone not in", values, "addContactPhone");
            return (Criteria) this;
        }

        public Criteria andAddContactPhoneBetween(String value1, String value2) {
            addCriterion("addContactPhone between", value1, value2, "addContactPhone");
            return (Criteria) this;
        }

        public Criteria andAddContactPhoneNotBetween(String value1, String value2) {
            addCriterion("addContactPhone not between", value1, value2, "addContactPhone");
            return (Criteria) this;
        }

        public Criteria andAddContactNameIsNull() {
            addCriterion("addContactName is null");
            return (Criteria) this;
        }

        public Criteria andAddContactNameIsNotNull() {
            addCriterion("addContactName is not null");
            return (Criteria) this;
        }

        public Criteria andAddContactNameEqualTo(String value) {
            addCriterion("addContactName =", value, "addContactName");
            return (Criteria) this;
        }

        public Criteria andAddContactNameNotEqualTo(String value) {
            addCriterion("addContactName <>", value, "addContactName");
            return (Criteria) this;
        }

        public Criteria andAddContactNameGreaterThan(String value) {
            addCriterion("addContactName >", value, "addContactName");
            return (Criteria) this;
        }

        public Criteria andAddContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("addContactName >=", value, "addContactName");
            return (Criteria) this;
        }

        public Criteria andAddContactNameLessThan(String value) {
            addCriterion("addContactName <", value, "addContactName");
            return (Criteria) this;
        }

        public Criteria andAddContactNameLessThanOrEqualTo(String value) {
            addCriterion("addContactName <=", value, "addContactName");
            return (Criteria) this;
        }

        public Criteria andAddContactNameLike(String value) {
            addCriterion("addContactName like", value, "addContactName");
            return (Criteria) this;
        }

        public Criteria andAddContactNameNotLike(String value) {
            addCriterion("addContactName not like", value, "addContactName");
            return (Criteria) this;
        }

        public Criteria andAddContactNameIn(List<String> values) {
            addCriterion("addContactName in", values, "addContactName");
            return (Criteria) this;
        }

        public Criteria andAddContactNameNotIn(List<String> values) {
            addCriterion("addContactName not in", values, "addContactName");
            return (Criteria) this;
        }

        public Criteria andAddContactNameBetween(String value1, String value2) {
            addCriterion("addContactName between", value1, value2, "addContactName");
            return (Criteria) this;
        }

        public Criteria andAddContactNameNotBetween(String value1, String value2) {
            addCriterion("addContactName not between", value1, value2, "addContactName");
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