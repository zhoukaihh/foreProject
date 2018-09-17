package com.qf.shopping.dto;

import java.util.ArrayList;
import java.util.List;

import com.qf.shopping.pojo.FirstType;
import com.qf.shopping.pojo.SecondType;

public class FirstTypeDto {

	private Integer firstTypeId;

    private String firstTypeName;
    
    private List<SecondType> secondTypes = new ArrayList<SecondType>();
    
    

	

	public FirstTypeDto() {
	}
	
	public FirstTypeDto(FirstType po) {
		this.firstTypeId=po.getFirstTypeId();
		this.firstTypeName=po.getFirstTypeName();
		this.secondTypes=po.getSecondTypes();
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
