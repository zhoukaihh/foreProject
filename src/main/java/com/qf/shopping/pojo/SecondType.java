package com.qf.shopping.pojo;

import java.util.ArrayList;
import java.util.List;

public class SecondType {
    private Integer secondTypeId;

    private String secondTypeName;

    private Integer firstTypeId;

    private FirstType firstType;
    
    private List<Ware> wares = new ArrayList<Ware>();
    
    
    
    public List<Ware> getWares() {
		return wares;
	}

	public void setWares(List<Ware> wares) {
		this.wares = wares;
	}

	public FirstType getFirstType() {
		return firstType;
	}

	public void setFirstType(FirstType firstType) {
		this.firstType = firstType;
	}

	public Integer getSecondTypeId() {
        return secondTypeId;
    }

    public void setSecondTypeId(Integer secondTypeId) {
        this.secondTypeId = secondTypeId;
    }

    public String getSecondTypeName() {
        return secondTypeName;
    }

    public void setSecondTypeName(String secondTypeName) {
        this.secondTypeName = secondTypeName == null ? null : secondTypeName.trim();
    }

    public Integer getFirstTypeId() {
        return firstTypeId;
    }

    public void setFirstTypeId(Integer firstTypeId) {
        this.firstTypeId = firstTypeId;
    }
}