package com.qf.shopping.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.shopping.dto.RoleDto;
import com.qf.shopping.mapper.RoleMapper;
import com.qf.shopping.mapper.RoleMenuMapper;
import com.qf.shopping.pojo.Role;
import com.qf.shopping.pojo.RoleExample;
import com.qf.shopping.pojo.RoleMenuExample;
import com.qf.shopping.pojo.RoleMenuKey;
import com.qf.shopping.service.IRoleService;

@Service
@Transactional
public class RoleService implements IRoleService {

	private static Logger logger = Logger.getLogger(RoleService.class);

	@Autowired
	private RoleMapper rMapper;

	@Autowired
	private RoleMenuMapper roleMenuMapper;

	/**
	 * 查询全部角色信息
	 */
	@Override
	public List<RoleDto> findAllRole() {
		List<Role> pos = rMapper.selectByExample(new RoleExample());
		logger.info(pos);
		return RoleDto.getDtos(pos);
	}

	/**
	 * 创建角色
	 */
	@Override
	public void create(RoleDto dto, Integer[] ids) {

		Role po = new Role();
		po.setName(dto.getName());
		po.setDes(dto.getDes());
		rMapper.insertSelective(po);

		// 添加关系表这里需要po的id回写：useGeneratedKeys="true" keyProperty="id"
		for (Integer menuId : ids) {
			RoleMenuKey key = new RoleMenuKey();
			key.setRole_id(po.getId());
			key.setMenu_id(menuId);
			roleMenuMapper.insert(key);
		}

	}

	/**
	 * 通过id查询角色
	 * 
	 * @return
	 */
	@Override
	public RoleDto findById(Integer roleId) {
		Role po = rMapper.selectByPrimaryKey(roleId);
		return new RoleDto(po);
	}

	/**
	 * 修改角色信息
	 */
	@Override
	public void update(RoleDto dto, Integer[] ids) {
		// 修改角色信息
		Role po = rMapper.selectByPrimaryKey(dto.getId());
		po.setId(dto.getId());
		po.setName(dto.getName());
		po.setDes(dto.getDes());
		rMapper.updateByPrimaryKey(po);

		// 删除关联表
		RoleMenuExample rme = new RoleMenuExample();
		rme.createCriteria().andRole_idEqualTo(po.getId());
		roleMenuMapper.deleteByExample(rme);

		// 设置新的关联表
		for (Integer Menuid : ids) {
			RoleMenuKey key = new RoleMenuKey();
			key.setRole_id(po.getId());
			key.setMenu_id(Menuid);
			roleMenuMapper.insert(key);
		}
	}

	/**
	 * 删除角色
	 */
	@Override
	public void delete(Integer roleId) {

		// 删除关联表
		RoleMenuExample rme = new RoleMenuExample();
		rme.createCriteria().andRole_idEqualTo(roleId);
		roleMenuMapper.deleteByExample(rme);
		
		//删除角色信息
		rMapper.deleteByPrimaryKey(roleId);

	}

}
