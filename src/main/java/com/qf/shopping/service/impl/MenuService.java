package com.qf.shopping.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.shopping.dto.MenuDto;
import com.qf.shopping.mapper.MenuMapper;
import com.qf.shopping.pojo.Menu;
import com.qf.shopping.pojo.MenuExample;
import com.qf.shopping.service.IMenuService;

@Service
@Transactional
public class MenuService implements IMenuService {

	private static Logger logger = Logger.getLogger(MenuService.class);

	@Autowired
	private MenuMapper menuMapper;
	
	@Override
	public List<MenuDto> findAllMenu() {
		List<Menu> pos = menuMapper.selectByExample(new MenuExample());
		return MenuDto.getDtos(pos);
	}

	/**
	 * 创建权限
	 */
	@Override
	public void create(MenuDto dto) {
		Menu po = new Menu();
		po.setPerName(dto.getPerName());
		po.setResName(dto.getResName());
		po.setPath(dto.getPath());
		
		menuMapper.insertSelective(po);
	}

	/**
	 * 通过id查询权限
	 */
	@Override
	public MenuDto findById(Integer permId) {
		Menu po = menuMapper.selectByPrimaryKey(permId);
		return new MenuDto(po);
	}

	/**
	 *修改权限
	 */
	@Override
	public void update(MenuDto dto) {

		Menu po = new Menu();
		po.setPerId(dto.getPerId());
		po.setPath(dto.getPath());
		po.setResName(dto.getResName());
		menuMapper.updateByPrimaryKey(po);
	}

	@Override
	public void delete(Integer permId) {
		menuMapper.deleteByPrimaryKey(permId);
	}

}
