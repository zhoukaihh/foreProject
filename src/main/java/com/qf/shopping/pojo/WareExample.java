package com.qf.shopping.pojo;

import java.util.ArrayList;
import java.util.List;

public class WareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WareExample() {
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

        public Criteria andGoodNameIsNull() {
            addCriterion("goodName is null");
            return (Criteria) this;
        }

        public Criteria andGoodNameIsNotNull() {
            addCriterion("goodName is not null");
            return (Criteria) this;
        }

        public Criteria andGoodNameEqualTo(String value) {
            addCriterion("goodName =", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotEqualTo(String value) {
            addCriterion("goodName <>", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameGreaterThan(String value) {
            addCriterion("goodName >", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameGreaterThanOrEqualTo(String value) {
            addCriterion("goodName >=", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLessThan(String value) {
            addCriterion("goodName <", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLessThanOrEqualTo(String value) {
            addCriterion("goodName <=", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameLike(String value) {
            addCriterion("goodName like", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotLike(String value) {
            addCriterion("goodName not like", value, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameIn(List<String> values) {
            addCriterion("goodName in", values, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotIn(List<String> values) {
            addCriterion("goodName not in", values, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameBetween(String value1, String value2) {
            addCriterion("goodName between", value1, value2, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodNameNotBetween(String value1, String value2) {
            addCriterion("goodName not between", value1, value2, "goodName");
            return (Criteria) this;
        }

        public Criteria andGoodDesIsNull() {
            addCriterion("goodDes is null");
            return (Criteria) this;
        }

        public Criteria andGoodDesIsNotNull() {
            addCriterion("goodDes is not null");
            return (Criteria) this;
        }

        public Criteria andGoodDesEqualTo(String value) {
            addCriterion("goodDes =", value, "goodDes");
            return (Criteria) this;
        }

        public Criteria andGoodDesNotEqualTo(String value) {
            addCriterion("goodDes <>", value, "goodDes");
            return (Criteria) this;
        }

        public Criteria andGoodDesGreaterThan(String value) {
            addCriterion("goodDes >", value, "goodDes");
            return (Criteria) this;
        }

        public Criteria andGoodDesGreaterThanOrEqualTo(String value) {
            addCriterion("goodDes >=", value, "goodDes");
            return (Criteria) this;
        }

        public Criteria andGoodDesLessThan(String value) {
            addCriterion("goodDes <", value, "goodDes");
            return (Criteria) this;
        }

        public Criteria andGoodDesLessThanOrEqualTo(String value) {
            addCriterion("goodDes <=", value, "goodDes");
            return (Criteria) this;
        }

        public Criteria andGoodDesLike(String value) {
            addCriterion("goodDes like", value, "goodDes");
            return (Criteria) this;
        }

        public Criteria andGoodDesNotLike(String value) {
            addCriterion("goodDes not like", value, "goodDes");
            return (Criteria) this;
        }

        public Criteria andGoodDesIn(List<String> values) {
            addCriterion("goodDes in", values, "goodDes");
            return (Criteria) this;
        }

        public Criteria andGoodDesNotIn(List<String> values) {
            addCriterion("goodDes not in", values, "goodDes");
            return (Criteria) this;
        }

        public Criteria andGoodDesBetween(String value1, String value2) {
            addCriterion("goodDes between", value1, value2, "goodDes");
            return (Criteria) this;
        }

        public Criteria andGoodDesNotBetween(String value1, String value2) {
            addCriterion("goodDes not between", value1, value2, "goodDes");
            return (Criteria) this;
        }

        public Criteria andGoodNumsIsNull() {
            addCriterion("goodNums is null");
            return (Criteria) this;
        }

        public Criteria andGoodNumsIsNotNull() {
            addCriterion("goodNums is not null");
            return (Criteria) this;
        }

        public Criteria andGoodNumsEqualTo(String value) {
            addCriterion("goodNums =", value, "goodNums");
            return (Criteria) this;
        }

        public Criteria andGoodNumsNotEqualTo(String value) {
            addCriterion("goodNums <>", value, "goodNums");
            return (Criteria) this;
        }

        public Criteria andGoodNumsGreaterThan(String value) {
            addCriterion("goodNums >", value, "goodNums");
            return (Criteria) this;
        }

        public Criteria andGoodNumsGreaterThanOrEqualTo(String value) {
            addCriterion("goodNums >=", value, "goodNums");
            return (Criteria) this;
        }

        public Criteria andGoodNumsLessThan(String value) {
            addCriterion("goodNums <", value, "goodNums");
            return (Criteria) this;
        }

        public Criteria andGoodNumsLessThanOrEqualTo(String value) {
            addCriterion("goodNums <=", value, "goodNums");
            return (Criteria) this;
        }

        public Criteria andGoodNumsLike(String value) {
            addCriterion("goodNums like", value, "goodNums");
            return (Criteria) this;
        }

        public Criteria andGoodNumsNotLike(String value) {
            addCriterion("goodNums not like", value, "goodNums");
            return (Criteria) this;
        }

        public Criteria andGoodNumsIn(List<String> values) {
            addCriterion("goodNums in", values, "goodNums");
            return (Criteria) this;
        }

        public Criteria andGoodNumsNotIn(List<String> values) {
            addCriterion("goodNums not in", values, "goodNums");
            return (Criteria) this;
        }

        public Criteria andGoodNumsBetween(String value1, String value2) {
            addCriterion("goodNums between", value1, value2, "goodNums");
            return (Criteria) this;
        }

        public Criteria andGoodNumsNotBetween(String value1, String value2) {
            addCriterion("goodNums not between", value1, value2, "goodNums");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountPriceIsNull() {
            addCriterion("goodDiscountPrice is null");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountPriceIsNotNull() {
            addCriterion("goodDiscountPrice is not null");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountPriceEqualTo(String value) {
            addCriterion("goodDiscountPrice =", value, "goodDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountPriceNotEqualTo(String value) {
            addCriterion("goodDiscountPrice <>", value, "goodDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountPriceGreaterThan(String value) {
            addCriterion("goodDiscountPrice >", value, "goodDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountPriceGreaterThanOrEqualTo(String value) {
            addCriterion("goodDiscountPrice >=", value, "goodDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountPriceLessThan(String value) {
            addCriterion("goodDiscountPrice <", value, "goodDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountPriceLessThanOrEqualTo(String value) {
            addCriterion("goodDiscountPrice <=", value, "goodDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountPriceLike(String value) {
            addCriterion("goodDiscountPrice like", value, "goodDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountPriceNotLike(String value) {
            addCriterion("goodDiscountPrice not like", value, "goodDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountPriceIn(List<String> values) {
            addCriterion("goodDiscountPrice in", values, "goodDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountPriceNotIn(List<String> values) {
            addCriterion("goodDiscountPrice not in", values, "goodDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountPriceBetween(String value1, String value2) {
            addCriterion("goodDiscountPrice between", value1, value2, "goodDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountPriceNotBetween(String value1, String value2) {
            addCriterion("goodDiscountPrice not between", value1, value2, "goodDiscountPrice");
            return (Criteria) this;
        }

        public Criteria andGoodImageIsNull() {
            addCriterion("goodImage is null");
            return (Criteria) this;
        }

        public Criteria andGoodImageIsNotNull() {
            addCriterion("goodImage is not null");
            return (Criteria) this;
        }

        public Criteria andGoodImageEqualTo(String value) {
            addCriterion("goodImage =", value, "goodImage");
            return (Criteria) this;
        }

        public Criteria andGoodImageNotEqualTo(String value) {
            addCriterion("goodImage <>", value, "goodImage");
            return (Criteria) this;
        }

        public Criteria andGoodImageGreaterThan(String value) {
            addCriterion("goodImage >", value, "goodImage");
            return (Criteria) this;
        }

        public Criteria andGoodImageGreaterThanOrEqualTo(String value) {
            addCriterion("goodImage >=", value, "goodImage");
            return (Criteria) this;
        }

        public Criteria andGoodImageLessThan(String value) {
            addCriterion("goodImage <", value, "goodImage");
            return (Criteria) this;
        }

        public Criteria andGoodImageLessThanOrEqualTo(String value) {
            addCriterion("goodImage <=", value, "goodImage");
            return (Criteria) this;
        }

        public Criteria andGoodImageLike(String value) {
            addCriterion("goodImage like", value, "goodImage");
            return (Criteria) this;
        }

        public Criteria andGoodImageNotLike(String value) {
            addCriterion("goodImage not like", value, "goodImage");
            return (Criteria) this;
        }

        public Criteria andGoodImageIn(List<String> values) {
            addCriterion("goodImage in", values, "goodImage");
            return (Criteria) this;
        }

        public Criteria andGoodImageNotIn(List<String> values) {
            addCriterion("goodImage not in", values, "goodImage");
            return (Criteria) this;
        }

        public Criteria andGoodImageBetween(String value1, String value2) {
            addCriterion("goodImage between", value1, value2, "goodImage");
            return (Criteria) this;
        }

        public Criteria andGoodImageNotBetween(String value1, String value2) {
            addCriterion("goodImage not between", value1, value2, "goodImage");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountIsNull() {
            addCriterion("goodDiscount is null");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountIsNotNull() {
            addCriterion("goodDiscount is not null");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountEqualTo(String value) {
            addCriterion("goodDiscount =", value, "goodDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountNotEqualTo(String value) {
            addCriterion("goodDiscount <>", value, "goodDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountGreaterThan(String value) {
            addCriterion("goodDiscount >", value, "goodDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountGreaterThanOrEqualTo(String value) {
            addCriterion("goodDiscount >=", value, "goodDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountLessThan(String value) {
            addCriterion("goodDiscount <", value, "goodDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountLessThanOrEqualTo(String value) {
            addCriterion("goodDiscount <=", value, "goodDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountLike(String value) {
            addCriterion("goodDiscount like", value, "goodDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountNotLike(String value) {
            addCriterion("goodDiscount not like", value, "goodDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountIn(List<String> values) {
            addCriterion("goodDiscount in", values, "goodDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountNotIn(List<String> values) {
            addCriterion("goodDiscount not in", values, "goodDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountBetween(String value1, String value2) {
            addCriterion("goodDiscount between", value1, value2, "goodDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodDiscountNotBetween(String value1, String value2) {
            addCriterion("goodDiscount not between", value1, value2, "goodDiscount");
            return (Criteria) this;
        }

        public Criteria andGoodPriceIsNull() {
            addCriterion("goodPrice is null");
            return (Criteria) this;
        }

        public Criteria andGoodPriceIsNotNull() {
            addCriterion("goodPrice is not null");
            return (Criteria) this;
        }

        public Criteria andGoodPriceEqualTo(String value) {
            addCriterion("goodPrice =", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotEqualTo(String value) {
            addCriterion("goodPrice <>", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceGreaterThan(String value) {
            addCriterion("goodPrice >", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceGreaterThanOrEqualTo(String value) {
            addCriterion("goodPrice >=", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceLessThan(String value) {
            addCriterion("goodPrice <", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceLessThanOrEqualTo(String value) {
            addCriterion("goodPrice <=", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceLike(String value) {
            addCriterion("goodPrice like", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotLike(String value) {
            addCriterion("goodPrice not like", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceIn(List<String> values) {
            addCriterion("goodPrice in", values, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotIn(List<String> values) {
            addCriterion("goodPrice not in", values, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceBetween(String value1, String value2) {
            addCriterion("goodPrice between", value1, value2, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotBetween(String value1, String value2) {
            addCriterion("goodPrice not between", value1, value2, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andSecondTypeIdIsNull() {
            addCriterion("secondTypeId is null");
            return (Criteria) this;
        }

        public Criteria andSecondTypeIdIsNotNull() {
            addCriterion("secondTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andSecondTypeIdEqualTo(Integer value) {
            addCriterion("secondTypeId =", value, "secondTypeId");
            return (Criteria) this;
        }

        public Criteria andSecondTypeIdNotEqualTo(Integer value) {
            addCriterion("secondTypeId <>", value, "secondTypeId");
            return (Criteria) this;
        }

        public Criteria andSecondTypeIdGreaterThan(Integer value) {
            addCriterion("secondTypeId >", value, "secondTypeId");
            return (Criteria) this;
        }

        public Criteria andSecondTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("secondTypeId >=", value, "secondTypeId");
            return (Criteria) this;
        }

        public Criteria andSecondTypeIdLessThan(Integer value) {
            addCriterion("secondTypeId <", value, "secondTypeId");
            return (Criteria) this;
        }

        public Criteria andSecondTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("secondTypeId <=", value, "secondTypeId");
            return (Criteria) this;
        }

        public Criteria andSecondTypeIdIn(List<Integer> values) {
            addCriterion("secondTypeId in", values, "secondTypeId");
            return (Criteria) this;
        }

        public Criteria andSecondTypeIdNotIn(List<Integer> values) {
            addCriterion("secondTypeId not in", values, "secondTypeId");
            return (Criteria) this;
        }

        public Criteria andSecondTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("secondTypeId between", value1, value2, "secondTypeId");
            return (Criteria) this;
        }

        public Criteria andSecondTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("secondTypeId not between", value1, value2, "secondTypeId");
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