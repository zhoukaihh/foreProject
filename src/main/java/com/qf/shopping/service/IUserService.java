package com.qf.shopping.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qf.shopping.dto.UserDto;
import com.qf.shopping.pojo.User;
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
	List<User> findUserAll();

	UserDto authenticate(HttpServletRequest req,UserDto user,String loginType);
}
