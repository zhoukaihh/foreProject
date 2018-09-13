package com.qf.shopping.service;

import java.util.List;

import com.qf.shopping.dto.UserActionDto;

public interface IUserActionService {

	Integer findAllPage();

	List<UserActionDto> findAllBehavior(Integer pageNo);

}
