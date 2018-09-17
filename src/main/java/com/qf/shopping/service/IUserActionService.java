package com.qf.shopping.service;

import java.util.List;

import com.qf.shopping.dto.UserActionDto;
import com.qf.shopping.pojo.UserAction;

public interface IUserActionService {

	Integer findAllPage();

	List<UserActionDto> findAllBehavior(Integer pageNo);

	void addRecord(UserAction record);
}
