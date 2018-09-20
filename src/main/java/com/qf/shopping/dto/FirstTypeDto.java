package com.qf.shopping.dto;

import java.util.ArrayList;
import java.util.List;

import com.qf.shopping.pojo.FirstType;
import com.qf.shopping.pojo.SecondType;
import com.qf.shopping.pojo.Ware;

public class FirstTypeDto {

	private Integer firstTypeId;

    private String firstTypeName;
    
    private Integer nowPage;
    
    private Integer allPage;
    
    private List<Ware> goods = new ArrayList<Ware>();
    
    private List<SecondType> secondTypes = new ArrayList<SecondType>();
    

    public FirstTypeDto() {
	}
	
	public FirstTypeDto(FirstType po) {
		this.firstTypeId=po.getFirstTypeId();
		this.firstTypeName=po.getFirstTypeName();
		this.secondTypes=po.getSecondTypes();
		this.allPage=po.getAllPage();
		this.goods=po.getGoods();
		this.nowPage=po.getNowPage();
	}
    
	public Integer getNowPage() {
		return nowPage;
	}

	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}

	public Integer getAllPage() {
		return allPage;
	}

	public void setAllPage(Integer allPage) {
		this.allPage = allPage;
	}

	public List<Ware> getGoods() {
		return goods;
	}

	public void setGoods(List<Ware> goods) {
		this.goods = goods;
	}

	public List<SecondType> getSecondTypes() {
		return secondTypes;
	}

	public void setSecondTypes(List<SecondType> secondTypes) {
		this.secondTypes = secondTypes;
	}
	
	public Integer getFirstTypeId() {
		return firstTypeId;
	}

	public void setFirstTypeId(Integer firstTypeId) {
		this.firstTypeId = firstTypeId;
	}

	public String getFirstTypeName() {
		return firstTypeName;
	}

	public void setFirstTypeName(String firstTypeName) {
		this.firstTypeName = firstTypeName;
	}
    
    public static List<FirstTypeDto> getDtos(List<FirstType> pos){
    	ArrayList<FirstTypeDto> dtos = new ArrayList<FirstTypeDto>();
    	for (FirstType po : pos) {
			dtos.add(new FirstTypeDto(po));
		}
    	return dtos;
    }
}
