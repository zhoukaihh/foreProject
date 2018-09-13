package com.qf.shopping.dto;

import java.util.ArrayList;
import java.util.List;

import com.qf.shopping.pojo.Role;

public class RoleDto {

	private Integer id;

	private String name;

	private String des;

	
	public RoleDto() {
	}

	public RoleDto(Role r) {
		this.id = r.getId();
		this.name = r.getName();
		this.des = r.getDes();
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public static List<RoleDto> getDtos (List<Role> pos) {
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		for (Role po : pos) {
			dtos.add(new RoleDto (po));
		}
		return dtos;
	}
}
