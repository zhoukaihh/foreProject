package com.qf.shopping.pojo;

public class OrderItem {
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

    private String _version;
    
    private Ware ware;
    
    private Order order;

    
    
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
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public String getGoodDes() {
        return goodDes;
    }

    public void setGoodDes(String goodDes) {
        this.goodDes = goodDes == null ? null : goodDes.trim();
    }

    public String getGoodNums() {
        return goodNums;
    }

    public void setGoodNums(String goodNums) {
        this.goodNums = goodNums == null ? null : goodNums.trim();
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
        this.goodImage = goodImage == null ? null : goodImage.trim();
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
        this.itemTotal = itemTotal == null ? null : itemTotal.trim();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String get_version() {
        return _version;
    }

    public void set_version(String _version) {
        this._version = _version == null ? null : _version.trim();
    }
}