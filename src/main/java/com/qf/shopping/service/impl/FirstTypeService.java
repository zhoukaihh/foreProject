package com.qf.shopping.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.shopping.dto.FirstTypeDto;
import com.qf.shopping.mapper.FirstTypeMapper;
import com.qf.shopping.pojo.FirstType;
import com.qf.shopping.pojo.FirstTypeExample;
import com.qf.shopping.service.IFirstTypeService;

@Service
@Transactional
public class FirstTypeService implements IFirstTypeService {

	private static Logger logger = Logger.getLogger(FirstTypeService.class);
	
	@Autowired
	private FirstTypeMapper firstMapper;
	

	@Override
	public List<FirstTypeDto> findAll() {
		List<FirstType> pos = firstMapper.selectByExample(new FirstTypeExample());
		List<FirstTypeDto> dtos = FirstTypeDto.getDtos(pos);
		return dtos;
	}
	

}
