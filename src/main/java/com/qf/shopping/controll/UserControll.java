package com.qf.shopping.controll;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.shopping.pojo.User;
import com.qf.shopping.service.IUserService;

@Controller
@RequestMapping("/users")
public class UserControll {

	private static Logger logger = Logger.getLogger(UserControll.class);
	
	@Autowired
	private IUserService userService=null;
	
	@RequestMapping("/list")
	public String findAll(Model model){
		try {
			List<User> users=userService.findUserAll();
			System.out.println("获取:"+users);
			model.addAttribute("userList", users);
		} catch (Exception e) {
			logger.error("获取所有用户失败");
			throw new RuntimeException(e.getMessage());
		}
		
		return "user/userinfo";
	}
	
	
}
