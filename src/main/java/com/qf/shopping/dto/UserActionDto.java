package com.qf.shopping.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qf.shopping.pojo.User;
import com.qf.shopping.pojo.UserAction;

/**
 * 用户的dto
 * @author Administrator
 *
 */
public class UserActionDto {

	private Integer behaviorId;

	private Date startTime;

	private Date endTime;

	private String behavior;

	private String state;

	private Integer userId;

	private User user;
	
	

	public UserActionDto() {
	}
	
	public UserActionDto(UserAction po) {
		this.behavior=po.getBehavior();
		this.behaviorId=po.getBehaviorId();
		this.endTime=po.getEndTime();
		this.startTime=po.getStartTime();
		this.state=po.getState();
		this.user=po.getUser();
		this.userId=po.getUserId();
	}

	public Integer getBehaviorId() {
		return behaviorId;
	}

	public void setBehaviorId(Integer behaviorId) {
		this.behaviorId = behaviorId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * pos转换成dtos
	 * @param pos
	 * @return
	 */
	public static List<UserActionDto> getDtos(List<UserAction> pos){
		ArrayList<UserActionDto> dtos = new ArrayList<UserActionDto>();
		for (UserAction po : pos) {
			dtos.add(new UserActionDto(po));
		}
		return dtos;
	}
}
