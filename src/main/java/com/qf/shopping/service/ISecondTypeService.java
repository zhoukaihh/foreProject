package com.qf.shopping.service;

import java.util.List;

import com.qf.shopping.dto.SecondTypeDto;
import com.qf.shopping.pojo.SecondType;

public interface ISecondTypeService {

	Integer findAllPage();

	List<SecondTypeDto> findAllSecondType(Integer pageNo);

	void create(String secondTypeName, Integer firstTypeId);

	SecondType findById(Integer secondTypeId);

	void delete(Integer secondTypeId);

	void update(SecondTypeDto dto, Integer firstTypeId);

}
