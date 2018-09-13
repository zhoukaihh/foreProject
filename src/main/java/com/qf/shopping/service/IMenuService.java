package com.qf.shopping.service;

import java.util.List;

import com.qf.shopping.dto.MenuDto;

public interface IMenuService {

	List<MenuDto> findAllMenu();

	void create(MenuDto dto);

	MenuDto findById(Integer permId);

	void update(MenuDto dto);

	void delete(Integer permId);

}
