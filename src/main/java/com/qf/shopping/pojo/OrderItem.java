package com.qf.shopping.pojo;

public class OrderItem {
    private Integer orderItemId;

    private Integer goodId;

    private String goodName;

    private String goodDes;

    private String goodNums;

    private String goodPrice;

    private String goodImage;

    private Integer buyNum;

    private String itemTotal;

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

    public String getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(String goodPrice) {
        this.goodPrice = goodPrice == null ? null : goodPrice.trim();
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
}