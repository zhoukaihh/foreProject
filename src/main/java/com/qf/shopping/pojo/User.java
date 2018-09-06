package com.qf.shopping.pojo;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer uId;

    private String uLoginName;

    private String uPassword;

    private String uTelNum;

    private String gender;

    private String email;

    private String code;

    private Integer state;

    private List<Role> roles = new ArrayList<Role>();
    
    
    public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
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
        this.uLoginName = uLoginName == null ? null : uLoginName.trim();
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    public String getuTelNum() {
        return uTelNum;
    }

    public void setuTelNum(String uTelNum) {
        this.uTelNum = uTelNum == null ? null : uTelNum.trim();
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

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uLoginName=" + uLoginName + ", uPassword=" + uPassword + ", uTelNum=" + uTelNum
				+ ", gender=" + gender + ", email=" + email + ", code=" + code + ", state=" + state + ", roles=" + roles
				+ "]";
	}
    
    
}