package com.qf.shopping.service;

import java.util.List;

import com.qf.shopping.dto.RoleDto;

public interface IRoleService {

	List<RoleDto> findAllRole();

	void create(RoleDto dto, Integer[] ids);

	RoleDto findById(Integer roleId);

	void update(RoleDto dto, Integer[] ids);

	void delete(Integer roleId);

}
