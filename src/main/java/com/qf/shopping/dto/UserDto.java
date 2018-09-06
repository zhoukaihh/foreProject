package com.qf.shopping.dto;

import java.util.ArrayList;
import java.util.List;

import com.qf.shopping.pojo.User;

public class UserDto {

	private Integer uId;

	private String uLoginName;

	private String uPassword;

	private String uTelNum;

	private String gender;

	private String email;

	private String code;

	private Integer state;
	
	private List<RoleDto> roles = new ArrayList<RoleDto>();

	public UserDto() {
	}
	
	public UserDto(User u){
		this.setuId(u.getuId());
		this.setuLoginName(u.getuLoginName());
		this.setCode(u.getCode());
		this.setEmail(u.getEmail());
		this.setGender(u.getGender());
		this.setState(u.getState());
		this.setuPassword(u.getuPassword());
		this.setuTelNum(u.getuTelNum());
		this.setRoles(RoleDto.getDtos(u.getRoles()));
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getuLoginName() {
		return uLoginName;
	}

	public void setuLoginName(String uLoginName) {
		this.uLoginName = uLoginName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuTelNum() {
		return uTelNum;
	}

	public void setuTelNum(String uTelNum) {
		this.uTelNum = uTelNum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public List<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}
	
	public static List<UserDto> getDtos (List<User> pos) {
		List<UserDto> dtos = new ArrayList<UserDto>();
		for (User u : pos) {
			UserDto dto = new UserDto (u);
			dtos.add(dto);
		}
		return dtos;
	}
}
