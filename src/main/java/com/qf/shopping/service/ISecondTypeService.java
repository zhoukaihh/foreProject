package com.qf.shopping.service;

import java.util.List;

import com.qf.shopping.dto.SecondTypeDto;

public interface ISecondTypeService {

	Integer findAllPage();

	List<SecondTypeDto> findAllSecondType(Integer pageNo);

}
