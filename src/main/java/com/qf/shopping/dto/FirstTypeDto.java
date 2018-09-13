package com.qf.shopping.dto;

import java.util.ArrayList;
import java.util.List;

import com.qf.shopping.pojo.FirstType;

public class FirstTypeDto {

	private Integer firstTypeId;

    private String firstTypeName;
    
    

	public FirstTypeDto() {
	}
	
	public FirstTypeDto(FirstType po) {
		this.firstTypeId=po.getFirstTypeId();
		this.firstTypeName=po.getFirstTypeName();
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
