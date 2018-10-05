package com.qf.shopping.pojo;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Integer orderId;

    private String orderNum;

    private String state;

    private String orderTime;

    private Float orderTotalMoney;

    private Integer usreId;

    private String orderSendType;

    private String orderPayType;

    private String orderShAddress;

    private String orderShPeople;

    private String oderShTel;

    private Integer flag;
    
    
    private User user;
	
	private List<OrderItem> orderItems= new ArrayList<OrderItem>();
	
	

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime == null ? null : orderTime.trim();
    }

    public Float getOrderTotalMoney() {
        return orderTotalMoney;
    }

    public void setOrderTotalMoney(Float orderTotalMoney) {
        this.orderTotalMoney = orderTotalMoney;
    }

    public Integer getUsreId() {
        return usreId;
    }

    public void setUsreId(Integer usreId) {
        this.usreId = usreId;
    }

    public String getOrderSendType() {
        return orderSendType;
    }

    public void setOrderSendType(String orderSendType) {
        this.orderSendType = orderSendType == null ? null : orderSendType.trim();
    }

    public String getOrderPayType() {
        return orderPayType;
    }

    public void setOrderPayType(String orderPayType) {
        this.orderPayType = orderPayType == null ? null : orderPayType.trim();
    }

    public String getOrderShAddress() {
        return orderShAddress;
    }

    public void setOrderShAddress(String orderShAddress) {
        this.orderShAddress = orderShAddress == null ? null : orderShAddress.trim();
    }

    public String getOrderShPeople() {
        return orderShPeople;
    }

    public void setOrderShPeople(String orderShPeople) {
        this.orderShPeople = orderShPeople == null ? null : orderShPeople.trim();
    }

    public String getOderShTel() {
        return oderShTel;
    }

    public void setOderShTel(String oderShTel) {
        this.oderShTel = oderShTel == null ? null : oderShTel.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}