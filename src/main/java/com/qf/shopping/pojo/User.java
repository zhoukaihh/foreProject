package com.qf.shopping.pojo;

import java.util.ArrayList;
import java.util.List;

import com.qf.shopping.dto.RoleDto;
import com.qf.shopping.dto.UserDto;

public class User {
    private Integer id;

    private String loginName;

    private String password;

    private String telNum;

    private String gender;

    private String email;

    private String code;

    private Integer state;
    
    private List<Role> roles = new ArrayList<Role>();
    
    
    public User() {
	}

    public User(UserDto dto) {
    	this.code=dto.getCode();
    	this.email=dto.getEmail();
    	this.gender=dto.getGender();
    	this.id=dto.getId();
    	this.loginName=dto.getLoginName();
    	this.password=dto.getPassword();
    	this.state=dto.getState();
    	this.telNum=dto.getTelNum();
    			
    	
  	}
    
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
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
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum == null ? null : telNum.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}