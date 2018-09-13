package com.qf.shopping.service;

import java.util.List;

import com.qf.shopping.dto.WareDto;

public interface IWareService {

	Integer findAllPage();

	List<WareDto> findAllgoods(Integer pageNo);

	void create(WareDto dto);

	void delete(Integer goodId);

	WareDto findById(Integer goodId);

	void update(WareDto dto);

}
