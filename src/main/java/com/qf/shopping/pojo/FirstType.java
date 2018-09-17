package com.qf.shopping.pojo;

import java.util.ArrayList;
import java.util.List;

public class FirstType {
    private Integer firstTypeId;

    private String firstTypeName;
    
    private List<SecondType> secondTypes = new ArrayList<SecondType>();
    
    

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