package com.qf.shopping.dto;

import java.util.ArrayList;
import java.util.List;

import com.qf.shopping.pojo.Role;

public class RoleDto {

	private Integer rId;

	private String rName;

	private String rDes;

	
	public RoleDto() {
	}

	public RoleDto(Role r) {
		this.rId = r.getrId();
		this.rName = r.getrName();
		this.rDes = r.getrDes();
	}

	public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getrDes() {
		return rDes;
	}

	public void setrDes(String rDes) {
		this.rDes = rDes;
	}
	
	public static List<RoleDto> getDtos (List<Role> pos) {
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		for (Role po : pos) {
			dtos.add(new RoleDto (po));
		}
		return dtos;
	}
}
