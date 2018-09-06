package com.qf.shopping.pojo;

public class Ware {
    private Integer goodId;

    private String goodName;

    private String goodDes;

    private String goodNums;

    private String goodDiscountPrice;

    private String goodImage;

    private String goodDiscount;

    private String goodPrice;

    private Integer secondTypeId;
    
    private SecondType secondType;

    
    public SecondType getSecondType() {
		return secondType;
	}

	public void setSecondType(SecondType secondType) {
		this.secondType = secondType;
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

    public String getGoodDiscountPrice() {
        return goodDiscountPrice;
    }

    public void setGoodDiscountPrice(String goodDiscountPrice) {
        this.goodDiscountPrice = goodDiscountPrice == null ? null : goodDiscountPrice.trim();
    }

    public String getGoodImage() {
        return goodImage;
    }

    public void setGoodImage(String goodImage) {
        this.goodImage = goodImage == null ? null : goodImage.trim();
    }

    public String getGoodDiscount() {
        return goodDiscount;
    }

    public void setGoodDiscount(String goodDiscount) {
        this.goodDiscount = goodDiscount == null ? null : goodDiscount.trim();
    }

    public String getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(String goodPrice) {
        this.goodPrice = goodPrice == null ? null : goodPrice.trim();
    }

    public Integer getSecondTypeId() {
        return secondTypeId;
    }

    public void setSecondTypeId(Integer secondTypeId) {
        this.secondTypeId = secondTypeId;
    }
}