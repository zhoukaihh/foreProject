package com.qf.shopping.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.qf.shopping.dto.UserDto;
import com.qf.shopping.pojo.User;
import com.qf.shopping.pojo.UserRoleKey;
/**
 * service接口
 * @author apple
 *
 */
public interface IUserService {
    /**
     * 获取全部信息
     * @return
     */
	List<UserDto> findUserAll();

	UserDto authenticate(HttpServletRequest req,UserDto user,String loginType ,Model model);

	void create(UserDto dto, String roleName);

	void delete(Integer id);

	UserDto findById(Integer id, Model model);

	void update(UserDto dto, String roleName);

	void vipToSeller(Integer id);

	List<UserRoleKey> findUserRoleKey(Integer id);

	List<String> findRoleNameByUser(UserDto dto);

	void beforeRequireSeting(HttpServletRequest request);
}
