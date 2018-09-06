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

    private String goodDiscount;

    private String goodPrice;
    
    private Integer secondTypeId;
    
    private SecondType secondType;

    

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

	public WareDto() {
	}
	
	public WareDto(Ware g){
		
		this.goodId=g.getGoodId();
		this.goodDes=g.getGoodDes();
		this.goodDiscount=g.getGoodDiscount();
		this.goodDiscountPrice=g.getGoodDiscountPrice();
		this.goodImage=g.getGoodImage();
		this.goodName=g.getGoodName();
		this.goodNums=g.getGoodNums();
		this.goodPrice=g.getGoodPrice();
		this.secondTypeId=g.getSecondTypeId();
		this.secondType=g.getSecondType();
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

	public String getGoodDiscount() {
		return goodDiscount;
	}

	public void setGoodDiscount(String goodDiscount) {
		this.goodDiscount = goodDiscount;
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
