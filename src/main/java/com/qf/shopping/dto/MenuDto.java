package com.qf.shopping.dto;

import java.util.ArrayList;
import java.util.List;

import com.qf.shopping.pojo.Menu;
import com.qf.shopping.pojo.User;

public class MenuDto {

	private Integer perId;

	private String perName;

	private String perDes;

	private String type;

	private String path;

	private String resName;
	
	private User user;
	

	public MenuDto() {
	}

	public MenuDto(Menu po) {
		this.path=po.getPath();
		this.perDes=po.getPerDes();
		this.perId=po.getPerId();
		this.perName=po.getPerName();
		this.resName=po.getResName();
		this.type=po.getType();
		this.user=po.getUser();
	
	}
	
	public Integer getPerId() {
		return perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public String getPerDes() {
		return perDes;
	}

	public void setPerDes(String perDes) {
		this.perDes = perDes;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public static List<MenuDto> getDtos(List<Menu> pos){
		ArrayList<MenuDto> dtos = new ArrayList<MenuDto>();
		for (Menu po : pos) {
			dtos.add(new MenuDto(po));
		}
		return dtos;
	}
}
