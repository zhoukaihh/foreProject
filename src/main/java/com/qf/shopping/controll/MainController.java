package com.qf.shopping.controll;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.alibaba.fastjson.JSON;
import com.qf.shopping.annotation.LoggingManager;
import com.qf.shopping.dto.AdvertismentDto;
import com.qf.shopping.dto.FirstTypeDto;
import com.qf.shopping.dto.UserDto;
import com.qf.shopping.manager.CacheManager;
import com.qf.shopping.service.IAdvertismentService;
import com.qf.shopping.service.IUserService;

@Controller
public class MainController {

	private static Logger logger = Logger.getLogger(MainController.class);
	
	@Autowired
	private CacheManager  cacheManager;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IAdvertismentService adService;
	
	/**
	 * 前台登陆页面加载
	 * @param error
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginBefore(String error, Map<String, Object>map){
		map.put("error", error);
		logger.info("赐我前台登陆页面吧！");
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String  loginBefor(UserDto dto, HttpServletRequest req,String webpagetype){
		if ("front".equals(webpagetype)) {
			String loginType = "";
			List<String> roleNames = userService.findRoleNameByUser(dto);
			for (String roleName : roleNames) {
				if ("vip".equals(roleName)) {
					loginType=roleName;
					UserDto dto1 = userService.authenticate(req,dto,loginType);
					//判断是否可以登录
					if ("".equals(dto1.getPassword())) {
						req.getSession().setAttribute("realuser", dto1);
						
						//从redis中取出广告信息并放入域对象
						String ads = cacheManager.getAd();
						List<AdvertismentDto> ads1 = JSON.parseArray(ads, AdvertismentDto.class);
						req.getSession().setAttribute("ads", ads1);
						
						//从redis中取出分类信息并放入域对象
						String firsts = cacheManager.getFirstType();
						List<FirstTypeDto> firsts1 = JSON.parseArray(firsts, FirstTypeDto.class);
						for (FirstTypeDto firstTypeDto : firsts1) {
							System.out.println(firstTypeDto);
						}
						req.getSession().setAttribute("firstTypes", firsts1);
						return "index";
					}
				}
			}
		}
		
		return "login";
	}
	
	
	
	/**
	 * 后台登录页面加载
	 * @return
	 */
	@RequestMapping(value="/backLogin", method = RequestMethod.GET)
	public String login (String error, Map<String, Object>map) {
		map.put("error", error);
		logger.info("赐我后台登陆页面吧！");
		return "back/backLogin";
	}
	
	/**
	 * 请求后台登陆
	 * 在这里使用自定义注解@logginManager来将登陆方法设置成为AspectJ切入的连接点
	 * @param user
	 * @param req
	 * @param webpagetype
	 * @return
	 */
	@RequestMapping(value="/backLogin",method=RequestMethod.POST)
	@LoggingManager(description="进行登陆")
	public String login(UserDto user , HttpServletRequest req,String webpagetype,String loginType){
		
		if ("back".equals(webpagetype)) {
			UserDto dto = userService.authenticate(req,user,loginType);
			if ("".equals(dto.getPassword())) {
				req.getSession().setAttribute("backUser", dto);
				return "back/main";
			}
			return "back/backLogin";
		}
		return "back/error";
	}
	
	@RequestMapping(value="/logout")
	public String logout(String loginType ,HttpServletRequest req,SessionStatus status){
		HttpSession session = req.getSession();
		session.removeAttribute("backUser");
		session.setAttribute("loginType", "");
		status.setComplete();
		return "redirect:login";
	}
	
}
