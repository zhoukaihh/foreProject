package com.qf.shopping.dto;

import java.util.ArrayList;
import java.util.List;

import com.qf.shopping.pojo.User;

public class UserDto {

	 private Integer id;

	    private String loginName;

	    private String password;

	    private String telNum;

	    private String gender;

	    private String email;

	    private String code;

	    private Integer state;
	
	private List<RoleDto> roles = new ArrayList<RoleDto>();

	public UserDto() {
	}
	
	public UserDto(User u){
		this.setId(u.getId());
		this.setLoginName(u.getLoginName());
		this.setCode(u.getCode());
		this.setEmail(u.getEmail());
		this.setGender(u.getGender());
		this.setState(u.getState());
		this.setPassword(u.getPassword());
		this.setTelNum(u.getTelNum());
		this.setRoles(RoleDto.getDtos(u.getRoles()));
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
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
