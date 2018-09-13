package com.qf.shopping.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qf.shopping.pojo.Order;
import com.qf.shopping.pojo.OrderItem;
import com.qf.shopping.pojo.User;

public class OrderDto {

	 private Integer orderId;

	    private String orderNum;

	    private String state;

	    private Date orderTime;

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

		public OrderDto() {
		}

		public OrderDto(Order o) {
			this.flag=o.getFlag();
			this.oderShTel=o.getOderShTel();
			this.orderId=o.getOrderId();
			this.orderNum=o.getOrderNum();
			this.orderPayType=o.getOrderPayType();
			this.orderSendType=o.getOrderSendType();
			this.orderShAddress=o.getOrderShAddress();
			this.orderShPeople=o.getOrderShPeople();
			this.orderTime=o.getOrderTime();
			this.orderTotalMoney=o.getOrderTotalMoney();
			this.state=o.getState();
			this.user=o.getUser();
			this.usreId=o.getUsreId();
			this.orderItems=o.getOrderItems();
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
			this.orderNum = orderNum;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public Date getOrderTime() {
			return orderTime;
		}

		public void setOrderTime(Date orderTime) {
			this.orderTime = orderTime;
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
			this.orderSendType = orderSendType;
		}

		public String getOrderPayType() {
			return orderPayType;
		}

		public void setOrderPayType(String orderPayType) {
			this.orderPayType = orderPayType;
		}

		public String getOrderShAddress() {
			return orderShAddress;
		}

		public void setOrderShAddress(String orderShAddress) {
			this.orderShAddress = orderShAddress;
		}

		public String getOrderShPeople() {
			return orderShPeople;
		}

		public void setOrderShPeople(String orderShPeople) {
			this.orderShPeople = orderShPeople;
		}

		public String getOderShTel() {
			return oderShTel;
		}

		public void setOderShTel(String oderShTel) {
			this.oderShTel = oderShTel;
		}

		public Integer getFlag() {
			return flag;
		}

		public void setFlag(Integer flag) {
			this.flag = flag;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
	    
		public static List<OrderDto> getDtos(List<Order> pos){
			ArrayList<OrderDto> dtos = new ArrayList<OrderDto>();
			for (Order po : pos) {
				dtos.add(new OrderDto(po));
			}
			return dtos;
		}
}
