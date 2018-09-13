package com.qf.shopping.dto;

import java.util.ArrayList;
import java.util.List;

import com.qf.shopping.pojo.Order;
import com.qf.shopping.pojo.OrderItem;
import com.qf.shopping.pojo.Ware;

public class OrderItemDto {

	private Integer orderItemId;

    private Integer goodId;

    private String goodName;

    private String goodDes;

    private String goodNums;

    private Float goodPrice;

    private String goodImage;

    private Integer buyNum;

    private String itemTotal;

    private Integer orderId;
    
    private Ware ware;
    
    private Order order;
    
    

	public OrderItemDto() {
	}
	
	public OrderItemDto(OrderItem po) {
		this.buyNum=po.getBuyNum();
		this.goodDes=po.getGoodDes();
		this.goodId=po.getGoodId();
		this.goodImage=po.getGoodImage();
		this.goodName=po.getGoodName();
		this.goodNums=po.getGoodNums();
		this.goodPrice=po.getGoodPrice();
		this.itemTotal=po.getItemTotal();
		this.order=po.getOrder();
		this.orderId=po.getOrderId();
		this.orderItemId=po.getOrderItemId();
		this.ware=po.getWare();
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Integer getGoodId() {
		return goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getGoodDes() {
		return goodDes;
	}

	public void setGoodDes(String goodDes) {
		this.goodDes = goodDes;
	}

	public String getGoodNums() {
		return goodNums;
	}

	public void setGoodNums(String goodNums) {
		this.goodNums = goodNums;
	}

	public Float getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(Float goodPrice) {
		this.goodPrice = goodPrice;
	}

	public String getGoodImage() {
		return goodImage;
	}

	public void setGoodImage(String goodImage) {
		this.goodImage = goodImage;
	}

	public Integer getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}

	public String getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(String itemTotal) {
		this.itemTotal = itemTotal;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Ware getWare() {
		return ware;
	}

	public void setWare(Ware ware) {
		this.ware = ware;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

    public static List<OrderItemDto> getDtos(List<OrderItem> pos){
    	ArrayList<OrderItemDto> dtos = new ArrayList<OrderItemDto>();
    	for (OrderItem po : pos) {
			dtos.add(new OrderItemDto(po));
		}
    	return dtos;
    }
    
}
