package com.qf.shopping.service;

import java.util.List;

import com.qf.shopping.dto.WareDto;

public interface IWareService {

	Integer findAllPage();

	List<WareDto> findAllgoods(Integer pageNo);

}
