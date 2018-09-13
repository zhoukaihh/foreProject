package com.qf.shopping.dto;

import java.util.ArrayList;
import java.util.List;

import com.qf.shopping.pojo.SecondType;
import com.qf.shopping.pojo.Ware;

public class WareDto {

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

    public WareDto() {
	}
	
	public WareDto(Ware g){
		
		this.goodId=g.getGoodId();
		this.goodDes=g.getGoodDes();
		this.goodwNum=g.getGoodwNum();
		this.goodDiscountPrice=g.getGoodDiscountPrice();
		this.goodImage=g.getGoodImage();
		this.goodName=g.getGoodName();
		this.goodNums=g.getGoodNums();
		this.goodPrice=g.getGoodPrice();
		this.secondTypeId=g.getSecondTypeId();
		this.gams=g.getGams();
		this.gewNum=g.getGewNum();
		this.glNum=g.getGlNum();
		this.gms=g.getGms();
		this.gnum=g.getGnum();
		this.version=g.getVersion();
		this.secondType=g.getSecondType();
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

	public Integer getSecondTypeId() {
		return secondTypeId;
	}

	public void setSecondTypeId(Integer secondTypeId) {
		this.secondTypeId = secondTypeId;
	}

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

	public String getGoodDiscountPrice() {
		return goodDiscountPrice;
	}

	public void setGoodDiscountPrice(String goodDiscountPrice) {
		this.goodDiscountPrice = goodDiscountPrice;
	}

	public String getGoodImage() {
		return goodImage;
	}

	public void setGoodImage(String goodImage) {
		this.goodImage = goodImage;
	}

	public String getGoodwNum() {
		return goodwNum;
	}

	public void setGoodwNum(String goodwNum) {
		this.goodwNum = goodwNum;
	}

	public String getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(String goodPrice) {
		this.goodPrice = goodPrice;
	}
    
    public static List<WareDto> getWareDtos(List<Ware> wares){
    	ArrayList<WareDto> dtos = new ArrayList<WareDto>();
    	for (Ware ware : wares) {
			dtos.add(new WareDto(ware));
		}
    	return dtos;
    }
}
