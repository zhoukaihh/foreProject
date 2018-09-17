package com.qf.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.qf.shopping.dto.UserDto;
import com.qf.shopping.mapper.RoleMapper;
import com.qf.shopping.mapper.UserMapper;
import com.qf.shopping.mapper.UserRoleMapper;
import com.qf.shopping.pojo.Role;
import com.qf.shopping.pojo.RoleExample;
import com.qf.shopping.pojo.User;
import com.qf.shopping.pojo.UserExample;
import com.qf.shopping.pojo.UserRoleExample;
import com.qf.shopping.pojo.UserRoleKey;
import com.qf.shopping.service.IUserService;
import com.qf.shopping.util.SSMUtil;

@Service
@Transactional
public class UserService implements IUserService {

	private static Logger logger = Logger.getLogger(UserService.class);

	@Autowired
	private UserMapper userMapper = null;

	@Autowired
	private UserRoleMapper userRoleMapper = null;

	@Autowired
	private RoleMapper roleMapper = null;

	/**
	 * 查询所有用户
	 */
	public List<UserDto> findUserAll() {
		List<User> pos = userMapper.selectByExample(new UserExample());
		for (User po : pos) {
			// 通过用户得到用户角色
			List<Role> roles = getUserRoles(po);
			po.setRoles(roles);
		}
		return UserDto.getDtos(pos);
	}

	/**
	 * 通过用户查询他的角色
	 * 
	 * @param po
	 * @return
	 */
	private List<Role> getUserRoles(User po) {
		UserRoleExample ure = new UserRoleExample();
		ure.createCriteria().andUser_idEqualTo(po.getId());
		List<UserRoleKey> list = userRoleMapper.selectByExample(ure);

		ArrayList<Role> roles = new ArrayList<Role>();
		for (UserRoleKey userRoleKey : list) {
			Integer role_id = userRoleKey.getRole_id();
			Role role = roleMapper.selectByPrimaryKey(role_id);
			roles.add(role);
		}
		return roles;
	}

	/**
	 * 登陆验证，包括角色权限验证
	 */
	@Override
	public UserDto authenticate(HttpServletRequest req, UserDto dto, String loginType) {
		// 根据登陆名获取用户信息
		UserExample ue = new UserExample();
		ue.createCriteria().andLoginNameEqualTo(dto.getLoginName());
		List<User> users = userMapper.selectByExample(ue);
		// 设置用户的角色名
		List<String> roleNames = new ArrayList<String>();
		// 进行用户和权限验证
		// 获取与登录名相同的用户
		if (users.size() != 0) {
			// 获取那个登录名对应的用户
			User u = users.get(0);
			// 获取用户角色关系表
			UserRoleExample ure = new UserRoleExample();
			ure.createCriteria().andUser_idEqualTo(u.getId());
			List<UserRoleKey> userRoles = userRoleMapper.selectByExample(ure);
			// 给用户设置他的角色
			for (UserRoleKey userRole : userRoles) {
				Integer role_id = userRole.getRole_id();
				Role role = roleMapper.selectByPrimaryKey(role_id);
				// 将该用户的角色名全部取出来放到roles里面
				roleNames.add(role.getName());
			}
			// 将密码加密的功能
			String md5 = SSMUtil.getMD5(dto.getLoginName(), dto.getPassword());
			String newMd5 = md5.replaceAll("=", "");
			logger.info("MD5后得到密码：" + newMd5);
			logger.info("数据库中的密码：" + u.getPassword());
			// 判断用户密码是否相同，是否允许登录
			if (newMd5.equals(u.getPassword())) {
				// 判断用户的角色权限并且设置到域对象中
				if (roleNames.contains(loginType)) {
					req.getSession().setAttribute("loginType", loginType);
					u.setPassword("");
					return new UserDto(u);
				}
			}
			return dto;
		}
		return dto;
	}

	/**
	 * 添加用户
	 */
	@Override
	public void create(UserDto dto, String roleName) {

		// 查询用户角色
		RoleExample rex = new RoleExample();
		rex.createCriteria().andNameEqualTo(roleName);
		List<Role> roles = roleMapper.selectByExample(rex);
		Integer rId = roles.get(0).getId();

		// 添加用户数据
		User po = new User();
		po.setLoginName(dto.getLoginName());
		po.setPassword(dto.getPassword());
		po.setEmail(dto.getEmail());
		po.setGender(dto.getGender());
		po.setCode(dto.getCode());
		po.setState(dto.getState());
		po.setTelNum(dto.getTelNum());
		po.setRoles(roles);

		userMapper.insertSelective(po);

		// 添加关联表数据,需要设置po的id回写：useGeneratedKeys="true" keyProperty="id"
		UserRoleKey urk = new UserRoleKey();
		urk.setRole_id(rId);
		urk.setUser_id(po.getId());
		userRoleMapper.insert(urk);

		// 密码MD5
		String md5 = SSMUtil.getMD5(po.getLoginName(), po.getPassword());
		String newMd5 = md5.replaceAll("=", "");
		logger.info("创建的密码："+newMd5);
		po.setPassword(newMd5);
		userMapper.updateByPrimaryKey(po);
	}

	/**
	 * 通过id查询用户
	 */
	@Override
	public UserDto findById(Integer id, Model model) {
		// 查出用户信息
		User po = userMapper.selectByPrimaryKey(id);
		// 设置roleName
		UserRoleExample ure = new UserRoleExample();
		ure.createCriteria().andUser_idEqualTo(id);
		List<UserRoleKey> list = userRoleMapper.selectByExample(ure);
		Integer role_id = list.get(0).getRole_id();
		String roleName = roleMapper.selectByPrimaryKey(role_id).getName();
		model.addAttribute("roleName", roleName);

		return new UserDto(po);
	}

	/**
	 * 修改用户
	 */
	@Override
	public void update(UserDto dto, String roleName) {

		// 修改用户信息
		User po = userMapper.selectByPrimaryKey(dto.getId());
		po.setCode(dto.getCode());
		po.setEmail(dto.getEmail());
		po.setGender(dto.getGender());
		po.setState(dto.getState());
		po.setLoginName(dto.getLoginName());
		po.setId(dto.getId());
		String md5 = SSMUtil.getMD5(dto.getLoginName(), dto.getPassword());
		String newMd5 = md5.replaceAll("=", "");
		po.setPassword(newMd5);
		po.setTelNum(dto.getTelNum());

		userMapper.updateByPrimaryKey(po);

		// 删除关系表
		UserRoleExample ure = new UserRoleExample();
		ure.createCriteria().andUser_idEqualTo(dto.getId());
		userRoleMapper.deleteByExample(ure);
		// 重新设置表关系
		RoleExample rex = new RoleExample();
		rex.createCriteria().andNameEqualTo(roleName);
		List<Role> roles = roleMapper.selectByExample(rex);

		UserRoleKey userRoleKey = new UserRoleKey();
		for (Role role : roles) {
			userRoleKey.setUser_id(dto.getId());
			userRoleKey.setRole_id(role.getId());
			userRoleMapper.insert(userRoleKey);
		}

	}

	/**
	 * 删除单个用户
	 */
	@Override
	public void delete(Integer id) {
		// 删除表关系
		UserRoleExample ure = new UserRoleExample();
		ure.createCriteria().andUser_idEqualTo(id);
		userRoleMapper.deleteByExample(ure);

		// 删除用户数据
		userMapper.deleteByPrimaryKey(id);

	}

	/**
	 * 升级为卖家
	 */
	@Override
	public void vipToSeller(Integer id) {
		String name = "seller";
		User po = userMapper.selectByPrimaryKey(id);
		// 删除关系表
		UserRoleExample ure = new UserRoleExample();
		ure.createCriteria().andUser_idEqualTo(po.getId());
		userRoleMapper.deleteByExample(ure);
		// 重新设置表关系
		RoleExample rex = new RoleExample();
		rex.createCriteria().andNameEqualTo(name);
		List<Role> roles = roleMapper.selectByExample(rex);

		UserRoleKey userRoleKey = new UserRoleKey();
		for (Role role : roles) {
			userRoleKey.setUser_id(po.getId());
			userRoleKey.setRole_id(role.getId());
			userRoleMapper.insert(userRoleKey);
		}
	}

	/**
	 * 通过userid找userRoleKey
	 */
	@Override
	public List<UserRoleKey> findUserRoleKey(Integer id) {
		UserRoleExample ure = new UserRoleExample();
		ure.createCriteria().andUser_idEqualTo(id);
		List<UserRoleKey> urk = userRoleMapper.selectByExample(ure);
		return urk;
	}

	/**
	 * 通过用户中的名字获取该用户的角色名
	 */
	@Override
	public List<String> findRoleNameByUser(UserDto dto) {
		// 根据登陆名获取用户信息
		UserExample ue = new UserExample();
		ue.createCriteria().andLoginNameEqualTo(dto.getLoginName());
		List<User> users = userMapper.selectByExample(ue);
		// 设置用户的角色名
		List<String> roleNames = new ArrayList<String>();
		// 进行用户和权限验证
		// 获取与登录名相同的用户
		if (users.size() != 0) {
			// 获取那个登录名对应的用户
			User u = users.get(0);
			// 获取用户角色关系表
			UserRoleExample ure = new UserRoleExample();
			ure.createCriteria().andUser_idEqualTo(u.getId());
			List<UserRoleKey> userRoles = userRoleMapper.selectByExample(ure);
			// 给用户设置他的角色
			for (UserRoleKey userRole : userRoles) {
				Integer role_id = userRole.getRole_id();
				Role role = roleMapper.selectByPrimaryKey(role_id);
				// 将该用户的角色名全部取出来放到roles里面
				roleNames.add(role.getName());
			}
		}
		return roleNames;
	}

}
