package com.qf.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.shopping.dto.UserDto;
import com.qf.shopping.mapper.RoleMapper;
import com.qf.shopping.mapper.UserMapper;
import com.qf.shopping.mapper.UserRoleMapper;
import com.qf.shopping.pojo.Role;
import com.qf.shopping.pojo.User;
import com.qf.shopping.pojo.UserExample;
import com.qf.shopping.pojo.UserRoleExample;
import com.qf.shopping.pojo.UserRoleKey;
import com.qf.shopping.service.IUserService;

@Service
@Transactional
public class UserService implements IUserService{

	@Autowired
	private UserMapper userMapper=null;
	
	@Autowired
	private UserRoleMapper userRoleMapper=null;
	
	@Autowired
	private RoleMapper roleMapper=null;
	
	/**
	 * 查询所有用户
	 */
	public List<User> findUserAll() {
		return userMapper.selectByExample(new UserExample());
	}

	/**
	 * 登陆验证，包括角色权限验证
	 */
	@Override
	public UserDto authenticate(HttpServletRequest req,UserDto dto,String loginType) {
		UserExample ue = new UserExample();
		ue.createCriteria().andULoginNameEqualTo(dto.getuLoginName());
		List<User> users = userMapper.selectByExample(ue);
		List<String> roleNames = new ArrayList<String>();
		//进行用户和权限验证
		//获取与登录名相同的用户
		if (users.size() != 0) {
			//获取那个登录名对应的用户
			User u = users.get(0);
			UserRoleExample ure = new UserRoleExample();
			ure.createCriteria().andUser_idEqualTo(u.getuId());
			List<UserRoleKey> userRoles = userRoleMapper.selectByExample(ure);
			
			for (UserRoleKey userRole : userRoles) {
				Integer role_id = userRole.getRole_id();
				Role role = roleMapper.selectByPrimaryKey(role_id);
				//将该用户的角色名全部取出来放到roles里面
				roleNames.add(role.getrName());
			}
			
 			//判断用户密码是否相同，是否允许登录
			if (dto.getuPassword().equals(u.getuPassword())) {
				//判断用户的角色权限并且设置到域对象中
				if (roleNames.contains(loginType)) {
					req.getSession().setAttribute("loginType", loginType);
					u.setuPassword("");
					return new UserDto(u);
				}
			}
			return dto;
		}
		return dto;
	}

}
