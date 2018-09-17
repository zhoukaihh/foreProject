package com.qf.shopping.dto;

import java.util.ArrayList;
import java.util.List;

import com.qf.shopping.pojo.FirstType;
import com.qf.shopping.pojo.SecondType;
import com.qf.shopping.pojo.Ware;

public class SecondTypeDto {

	private Integer secondTypeId;

    private String secondTypeName;

    private Integer firstTypeId;
    
    private FirstType firstType;
    
    private List<Ware> wares = new ArrayList<Ware>();
    

	public SecondTypeDto() {
	}

	public SecondTypeDto(SecondType po){
		this.secondTypeId=po.getSecondTypeId();
		this.secondTypeName=po.getSecondTypeName();
		this.firstTypeId=po.getFirstTypeId();
		this.firstType=po.getFirstType();
		this.wares=po.getWares();
	}
	
	
	
	public List<Ware> getWares() {
		return wares;
	}

	public void setWares(List<Ware> wares) {
		this.wares = wares;
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
		this.secondTypeName = secondTypeName;
	}

	public Integer getFirstTypeId() {
		return firstTypeId;
	}

	public void setFirstTypeId(Integer firstTypeId) {
		this.firstTypeId = firstTypeId;
	}

	public FirstType getFirstType() {
		return firstType;
	}

	public void setFirstType(FirstType firstType) {
		this.firstType = firstType;
	}
    
    public static List<SecondTypeDto> getDtos(List<SecondType> pos){
    	ArrayList<SecondTypeDto> dtos = new ArrayList<SecondTypeDto>();
    	for (SecondType po : pos) {
			dtos.add(new SecondTypeDto(po));
		}
    	return dtos;
    }
    
    
}
