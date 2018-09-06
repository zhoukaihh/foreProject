package com.qf.shopping.controll;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.qf.shopping.dto.UserDto;
import com.qf.shopping.pojo.User;
import com.qf.shopping.service.IUserService;

@Controller
public class MainController {

	private static Logger logger = Logger.getLogger(MainController.class);
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 登录页面加载
	 * @return
	 */
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login (String error, Map<String, Object>map) {
		map.put("error", error);
		logger.info("哈哈哈");
		return "backLogin";
	}
	
	/**
	 * 请求登陆
	 * @param user
	 * @param req
	 * @param webpagetype
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(UserDto user , HttpServletRequest req,String webpagetype,String loginType){
		
		if ("back".equals(webpagetype)) {
			UserDto dto = userService.authenticate(req,user,loginType);
			if ("".equals(dto.getuPassword())) {
				req.getSession().setAttribute("backUser", dto);
//				req.getSession().setAttribute("loginType", loginType);
				return "main";
			}
			return "login";
		}
		return "error";
	}
	
	@RequestMapping(value="/logout")
	public String logout(String loginType ,HttpServletRequest req,SessionStatus status){
		HttpSession session = req.getSession();
		session.removeAttribute("backUser");
		session.setAttribute("loginType", "");
		status.setComplete();
		return "redirect:/login";
	}
	
}
