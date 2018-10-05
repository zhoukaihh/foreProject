package com.qf.shopping.pojo;

import java.util.ArrayList;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("orderId is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("orderId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("orderId =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("orderId <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("orderId >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderId >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("orderId <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("orderId <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("orderId in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("orderId not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("orderId between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("orderId not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("orderNum is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("orderNum is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(String value) {
            addCriterion("orderNum =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(String value) {
            addCriterion("orderNum <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(String value) {
            addCriterion("orderNum >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("orderNum >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(String value) {
            addCriterion("orderNum <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(String value) {
            addCriterion("orderNum <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLike(String value) {
            addCriterion("orderNum like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotLike(String value) {
            addCriterion("orderNum not like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<String> values) {
            addCriterion("orderNum in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<String> values) {
            addCriterion("orderNum not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(String value1, String value2) {
            addCriterion("orderNum between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(String value1, String value2) {
            addCriterion("orderNum not between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("orderTime is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("orderTime is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(String value) {
            addCriterion("orderTime =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(String value) {
            addCriterion("orderTime <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(String value) {
            addCriterion("orderTime >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(String value) {
            addCriterion("orderTime >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(String value) {
            addCriterion("orderTime <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(String value) {
            addCriterion("orderTime <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLike(String value) {
            addCriterion("orderTime like", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotLike(String value) {
            addCriterion("orderTime not like", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<String> values) {
            addCriterion("orderTime in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<String> values) {
            addCriterion("orderTime not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(String value1, String value2) {
            addCriterion("orderTime between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(String value1, String value2) {
            addCriterion("orderTime not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTotalMoneyIsNull() {
            addCriterion("orderTotalMoney is null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalMoneyIsNotNull() {
            addCriterion("orderTotalMoney is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalMoneyEqualTo(Float value) {
            addCriterion("orderTotalMoney =", value, "orderTotalMoney");
            return (Criteria) this;
        }

        public Criteria andOrderTotalMoneyNotEqualTo(Float value) {
            addCriterion("orderTotalMoney <>", value, "orderTotalMoney");
            return (Criteria) this;
        }

        public Criteria andOrderTotalMoneyGreaterThan(Float value) {
            addCriterion("orderTotalMoney >", value, "orderTotalMoney");
            return (Criteria) this;
        }

        public Criteria andOrderTotalMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("orderTotalMoney >=", value, "orderTotalMoney");
            return (Criteria) this;
        }

        public Criteria andOrderTotalMoneyLessThan(Float value) {
            addCriterion("orderTotalMoney <", value, "orderTotalMoney");
            return (Criteria) this;
        }

        public Criteria andOrderTotalMoneyLessThanOrEqualTo(Float value) {
            addCriterion("orderTotalMoney <=", value, "orderTotalMoney");
            return (Criteria) this;
        }

        public Criteria andOrderTotalMoneyIn(List<Float> values) {
            addCriterion("orderTotalMoney in", values, "orderTotalMoney");
            return (Criteria) this;
        }

        public Criteria andOrderTotalMoneyNotIn(List<Float> values) {
            addCriterion("orderTotalMoney not in", values, "orderTotalMoney");
            return (Criteria) this;
        }

        public Criteria andOrderTotalMoneyBetween(Float value1, Float value2) {
            addCriterion("orderTotalMoney between", value1, value2, "orderTotalMoney");
            return (Criteria) this;
        }

        public Criteria andOrderTotalMoneyNotBetween(Float value1, Float value2) {
            addCriterion("orderTotalMoney not between", value1, value2, "orderTotalMoney");
            return (Criteria) this;
        }

        public Criteria andUsreIdIsNull() {
            addCriterion("usreId is null");
            return (Criteria) this;
        }

        public Criteria andUsreIdIsNotNull() {
            addCriterion("usreId is not null");
            return (Criteria) this;
        }

        public Criteria andUsreIdEqualTo(Integer value) {
            addCriterion("usreId =", value, "usreId");
            return (Criteria) this;
        }

        public Criteria andUsreIdNotEqualTo(Integer value) {
            addCriterion("usreId <>", value, "usreId");
            return (Criteria) this;
        }

        public Criteria andUsreIdGreaterThan(Integer value) {
            addCriterion("usreId >", value, "usreId");
            return (Criteria) this;
        }

        public Criteria andUsreIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("usreId >=", value, "usreId");
            return (Criteria) this;
        }

        public Criteria andUsreIdLessThan(Integer value) {
            addCriterion("usreId <", value, "usreId");
            return (Criteria) this;
        }

        public Criteria andUsreIdLessThanOrEqualTo(Integer value) {
            addCriterion("usreId <=", value, "usreId");
            return (Criteria) this;
        }

        public Criteria andUsreIdIn(List<Integer> values) {
            addCriterion("usreId in", values, "usreId");
            return (Criteria) this;
        }

        public Criteria andUsreIdNotIn(List<Integer> values) {
            addCriterion("usreId not in", values, "usreId");
            return (Criteria) this;
        }

        public Criteria andUsreIdBetween(Integer value1, Integer value2) {
            addCriterion("usreId between", value1, value2, "usreId");
            return (Criteria) this;
        }

        public Criteria andUsreIdNotBetween(Integer value1, Integer value2) {
            addCriterion("usreId not between", value1, value2, "usreId");
            return (Criteria) this;
        }

        public Criteria andOrderSendTypeIsNull() {
            addCriterion("orderSendType is null");
            return (Criteria) this;
        }

        public Criteria andOrderSendTypeIsNotNull() {
            addCriterion("orderSendType is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSendTypeEqualTo(String value) {
            addCriterion("orderSendType =", value, "orderSendType");
            return (Criteria) this;
        }

        public Criteria andOrderSendTypeNotEqualTo(String value) {
            addCriterion("orderSendType <>", value, "orderSendType");
            return (Criteria) this;
        }

        public Criteria andOrderSendTypeGreaterThan(String value) {
            addCriterion("orderSendType >", value, "orderSendType");
            return (Criteria) this;
        }

        public Criteria andOrderSendTypeGreaterThanOrEqualTo(String value) {
            addCriterion("orderSendType >=", value, "orderSendType");
            return (Criteria) this;
        }

        public Criteria andOrderSendTypeLessThan(String value) {
            addCriterion("orderSendType <", value, "orderSendType");
            return (Criteria) this;
        }

        public Criteria andOrderSendTypeLessThanOrEqualTo(String value) {
            addCriterion("orderSendType <=", value, "orderSendType");
            return (Criteria) this;
        }

        public Criteria andOrderSendTypeLike(String value) {
            addCriterion("orderSendType like", value, "orderSendType");
            return (Criteria) this;
        }

        public Criteria andOrderSendTypeNotLike(String value) {
            addCriterion("orderSendType not like", value, "orderSendType");
            return (Criteria) this;
        }

        public Criteria andOrderSendTypeIn(List<String> values) {
            addCriterion("orderSendType in", values, "orderSendType");
            return (Criteria) this;
        }

        public Criteria andOrderSendTypeNotIn(List<String> values) {
            addCriterion("orderSendType not in", values, "orderSendType");
            return (Criteria) this;
        }

        public Criteria andOrderSendTypeBetween(String value1, String value2) {
            addCriterion("orderSendType between", value1, value2, "orderSendType");
            return (Criteria) this;
        }

        public Criteria andOrderSendTypeNotBetween(String value1, String value2) {
            addCriterion("orderSendType not between", value1, value2, "orderSendType");
            return (Criteria) this;
        }

        public Criteria andOrderPayTypeIsNull() {
            addCriterion("orderPayType is null");
            return (Criteria) this;
        }

        public Criteria andOrderPayTypeIsNotNull() {
            addCriterion("orderPayType is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPayTypeEqualTo(String value) {
            addCriterion("orderPayType =", value, "orderPayType");
            return (Criteria) this;
        }

        public Criteria andOrderPayTypeNotEqualTo(String value) {
            addCriterion("orderPayType <>", value, "orderPayType");
            return (Criteria) this;
        }

        public Criteria andOrderPayTypeGreaterThan(String value) {
            addCriterion("orderPayType >", value, "orderPayType");
            return (Criteria) this;
        }

        public Criteria andOrderPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("orderPayType >=", value, "orderPayType");
            return (Criteria) this;
        }

        public Criteria andOrderPayTypeLessThan(String value) {
            addCriterion("orderPayType <", value, "orderPayType");
            return (Criteria) this;
        }

        public Criteria andOrderPayTypeLessThanOrEqualTo(String value) {
            addCriterion("orderPayType <=", value, "orderPayType");
            return (Criteria) this;
        }

        public Criteria andOrderPayTypeLike(String value) {
            addCriterion("orderPayType like", value, "orderPayType");
            return (Criteria) this;
        }

        public Criteria andOrderPayTypeNotLike(String value) {
            addCriterion("orderPayType not like", value, "orderPayType");
            return (Criteria) this;
        }

        public Criteria andOrderPayTypeIn(List<String> values) {
            addCriterion("orderPayType in", values, "orderPayType");
            return (Criteria) this;
        }

        public Criteria andOrderPayTypeNotIn(List<String> values) {
            addCriterion("orderPayType not in", values, "orderPayType");
            return (Criteria) this;
        }

        public Criteria andOrderPayTypeBetween(String value1, String value2) {
            addCriterion("orderPayType between", value1, value2, "orderPayType");
            return (Criteria) this;
        }

        public Criteria andOrderPayTypeNotBetween(String value1, String value2) {
            addCriterion("orderPayType not between", value1, value2, "orderPayType");
            return (Criteria) this;
        }

        public Criteria andOrderShAddressIsNull() {
            addCriterion("orderShAddress is null");
            return (Criteria) this;
        }

        public Criteria andOrderShAddressIsNotNull() {
            addCriterion("orderShAddress is not null");
            return (Criteria) this;
        }

        public Criteria andOrderShAddressEqualTo(String value) {
            addCriterion("orderShAddress =", value, "orderShAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShAddressNotEqualTo(String value) {
            addCriterion("orderShAddress <>", value, "orderShAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShAddressGreaterThan(String value) {
            addCriterion("orderShAddress >", value, "orderShAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShAddressGreaterThanOrEqualTo(String value) {
            addCriterion("orderShAddress >=", value, "orderShAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShAddressLessThan(String value) {
            addCriterion("orderShAddress <", value, "orderShAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShAddressLessThanOrEqualTo(String value) {
            addCriterion("orderShAddress <=", value, "orderShAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShAddressLike(String value) {
            addCriterion("orderShAddress like", value, "orderShAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShAddressNotLike(String value) {
            addCriterion("orderShAddress not like", value, "orderShAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShAddressIn(List<String> values) {
            addCriterion("orderShAddress in", values, "orderShAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShAddressNotIn(List<String> values) {
            addCriterion("orderShAddress not in", values, "orderShAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShAddressBetween(String value1, String value2) {
            addCriterion("orderShAddress between", value1, value2, "orderShAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShAddressNotBetween(String value1, String value2) {
            addCriterion("orderShAddress not between", value1, value2, "orderShAddress");
            return (Criteria) this;
        }

        public Criteria andOrderShPeopleIsNull() {
            addCriterion("orderShPeople is null");
            return (Criteria) this;
        }

        public Criteria andOrderShPeopleIsNotNull() {
            addCriterion("orderShPeople is not null");
            return (Criteria) this;
        }

        public Criteria andOrderShPeopleEqualTo(String value) {
            addCriterion("orderShPeople =", value, "orderShPeople");
            return (Criteria) this;
        }

        public Criteria andOrderShPeopleNotEqualTo(String value) {
            addCriterion("orderShPeople <>", value, "orderShPeople");
            return (Criteria) this;
        }

        public Criteria andOrderShPeopleGreaterThan(String value) {
            addCriterion("orderShPeople >", value, "orderShPeople");
            return (Criteria) this;
        }

        public Criteria andOrderShPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("orderShPeople >=", value, "orderShPeople");
            return (Criteria) this;
        }

        public Criteria andOrderShPeopleLessThan(String value) {
            addCriterion("orderShPeople <", value, "orderShPeople");
            return (Criteria) this;
        }

        public Criteria andOrderShPeopleLessThanOrEqualTo(String value) {
            addCriterion("orderShPeople <=", value, "orderShPeople");
            return (Criteria) this;
        }

        public Criteria andOrderShPeopleLike(String value) {
            addCriterion("orderShPeople like", value, "orderShPeople");
            return (Criteria) this;
        }

        public Criteria andOrderShPeopleNotLike(String value) {
            addCriterion("orderShPeople not like", value, "orderShPeople");
            return (Criteria) this;
        }

        public Criteria andOrderShPeopleIn(List<String> values) {
            addCriterion("orderShPeople in", values, "orderShPeople");
            return (Criteria) this;
        }

        public Criteria andOrderShPeopleNotIn(List<String> values) {
            addCriterion("orderShPeople not in", values, "orderShPeople");
            return (Criteria) this;
        }

        public Criteria andOrderShPeopleBetween(String value1, String value2) {
            addCriterion("orderShPeople between", value1, value2, "orderShPeople");
            return (Criteria) this;
        }

        public Criteria andOrderShPeopleNotBetween(String value1, String value2) {
            addCriterion("orderShPeople not between", value1, value2, "orderShPeople");
            return (Criteria) this;
        }

        public Criteria andOderShTelIsNull() {
            addCriterion("oderShTel is null");
            return (Criteria) this;
        }

        public Criteria andOderShTelIsNotNull() {
            addCriterion("oderShTel is not null");
            return (Criteria) this;
        }

        public Criteria andOderShTelEqualTo(String value) {
            addCriterion("oderShTel =", value, "oderShTel");
            return (Criteria) this;
        }

        public Criteria andOderShTelNotEqualTo(String value) {
            addCriterion("oderShTel <>", value, "oderShTel");
            return (Criteria) this;
        }

        public Criteria andOderShTelGreaterThan(String value) {
            addCriterion("oderShTel >", value, "oderShTel");
            return (Criteria) this;
        }

        public Criteria andOderShTelGreaterThanOrEqualTo(String value) {
            addCriterion("oderShTel >=", value, "oderShTel");
            return (Criteria) this;
        }

        public Criteria andOderShTelLessThan(String value) {
            addCriterion("oderShTel <", value, "oderShTel");
            return (Criteria) this;
        }

        public Criteria andOderShTelLessThanOrEqualTo(String value) {
            addCriterion("oderShTel <=", value, "oderShTel");
            return (Criteria) this;
        }

        public Criteria andOderShTelLike(String value) {
            addCriterion("oderShTel like", value, "oderShTel");
            return (Criteria) this;
        }

        public Criteria andOderShTelNotLike(String value) {
            addCriterion("oderShTel not like", value, "oderShTel");
            return (Criteria) this;
        }

        public Criteria andOderShTelIn(List<String> values) {
            addCriterion("oderShTel in", values, "oderShTel");
            return (Criteria) this;
        }

        public Criteria andOderShTelNotIn(List<String> values) {
            addCriterion("oderShTel not in", values, "oderShTel");
            return (Criteria) this;
        }

        public Criteria andOderShTelBetween(String value1, String value2) {
            addCriterion("oderShTel between", value1, value2, "oderShTel");
            return (Criteria) this;
        }

        public Criteria andOderShTelNotBetween(String value1, String value2) {
            addCriterion("oderShTel not between", value1, value2, "oderShTel");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
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