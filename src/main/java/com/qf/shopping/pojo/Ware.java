package com.qf.shopping.pojo;

public class Ware {
    private Integer goodId;

    private String goodName;

    private String goodDes;

    private String goodNums;

    private String goodDiscountPrice;

    private String goodImage;

    private String goodwNum;

    private String goodPrice;

    private Integer secondTypeId;

    private Integer gms;

    private Integer gams;

    private Integer gnum;

    private Integer glNum;

    private Integer gewNum;

    private Integer version;
    
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

    public String getGoodwNum() {
        return goodwNum;
    }

    public void setGoodwNum(String goodwNum) {
        this.goodwNum = goodwNum == null ? null : goodwNum.trim();
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

    public Integer getGms() {
        return gms;
    }

    public void setGms(Integer gms) {
        this.gms = gms;
    }

    public Integer getGams() {
        return gams;
    }

    public void setGams(Integer gams) {
        this.gams = gams;
    }

    public Integer getGnum() {
        return gnum;
    }

    public void setGnum(Integer gnum) {
        this.gnum = gnum;
    }

    public Integer getGlNum() {
        return glNum;
    }

    public void setGlNum(Integer glNum) {
        this.glNum = glNum;
    }

    public Integer getGewNum() {
        return gewNum;
    }

    public void setGewNum(Integer gewNum) {
        this.gewNum = gewNum;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}