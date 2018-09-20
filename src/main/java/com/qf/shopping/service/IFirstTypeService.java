package com.qf.shopping.service;

import java.util.List;

import com.qf.shopping.dto.FirstTypeDto;

public interface IFirstTypeService {

	List<FirstTypeDto> findAll();

	FirstTypeDto findById(Integer firstTypeId);

}
