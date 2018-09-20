package com.qf.shopping.pojo;

import java.util.ArrayList;
import java.util.List;

public class FirstType {
    private Integer firstTypeId;

    private String firstTypeName;
    
    private Integer nowPage;
    
    private Integer allPage;
    
    private List<Ware> goods = new ArrayList<Ware>();
    
    
    private List<SecondType> secondTypes = new ArrayList<SecondType>();
    
    

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
        this.firstTypeName = firstTypeName == null ? null : firstTypeName.trim();
    }

	@Override
	public String toString() {
		return "FirstType [firstTypeId=" + firstTypeId + ", firstTypeName=" + firstTypeName + "]";
	}
    
    
}