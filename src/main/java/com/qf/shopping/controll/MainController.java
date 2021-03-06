package com.qf.shopping.controll;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.alibaba.fastjson.JSON;
import com.qf.shopping.annotation.BeforLoginManager;
import com.qf.shopping.annotation.BeforeRequirManager;
import com.qf.shopping.annotation.LoggingManager;
import com.qf.shopping.dto.AdvertismentDto;
import com.qf.shopping.dto.FirstTypeDto;
import com.qf.shopping.dto.UserDto;
import com.qf.shopping.manager.CacheManager;
import com.qf.shopping.service.IAdvertismentService;
import com.qf.shopping.service.IFirstTypeService;
import com.qf.shopping.service.IUserService;

@Controller
public class MainController {

	private static Logger logger = Logger.getLogger(MainController.class);

	@Autowired
	private CacheManager cacheManager;

	@Autowired
	private IUserService userService;

	@Autowired
	private IAdvertismentService adService;

	@Autowired
	private IFirstTypeService ftService;

	/**
	 * 前台登陆页面加载
	 * @param error
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@BeforeRequirManager(description = "前台访问请求")
	public String loginBefore(String error, Map<String, Object> map) {
		map.put("error", error);
		logger.info("赐我前台登陆页面吧！");
		return "index";
	}

	/**
	 * 免登陆处跳转到登陆页面
	 * @return
	 */
	@RequestMapping("/userLogin")
	public String userLogin() {
		return "login";
	}

	/**
	 * 前台登陆
	 * @param dto
	 * @param req
	 * @param resp
	 * @param webpagetype
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginBefor(UserDto dto, HttpServletRequest req, HttpServletResponse resp, String webpagetype,Model model)
			throws IOException {
		// 是否为前台登陆请求
		if ("front".equals(webpagetype)) {
			String loginType = "";
			// 查询该用户角色
			List<String> roleNames = userService.findRoleNameByUser(dto);
			for (String roleName : roleNames) {
				if ("vip".equals(roleName)) {
					loginType = roleName;
					UserDto dto1 = userService.authenticate(req, dto,loginType,model);
					// 判断是否可以登录
					if (!"".equals(dto1.getPassword())) {
						// 进来了就表示验证成功，可以登录

						// 设置session的信息到redis中去
						String sessionId = req.getSession().getId();
						logger.info("sesseionId："+sessionId);
						String user = JSON.toJSONString(dto1);
						cacheManager.putSessionId(sessionId, user);

						// 设置cookie
						Cookie cookie = new Cookie("token", sessionId);
						cookie.setMaxAge(2592000);
						resp.addCookie(cookie);
						// 设置首页需要的数据
						req.getSession().setAttribute("realuser", dto1);

						// 从redis中取出广告信息并放入域对象
						String adsAgain = cacheManager.getAd();
						List<AdvertismentDto> ads1 = JSON.parseArray(adsAgain, AdvertismentDto.class);
						req.getSession().setAttribute("ads", ads1);

						// 从redis中取出分类信息并放入域对象
						String firstsAgain = cacheManager.getFirstType();
						List<FirstTypeDto> firsts1 = JSON.parseArray(firstsAgain, FirstTypeDto.class);
						req.getSession().setAttribute("firstTypes", firsts1);

						// 查询一级分类
						List<FirstTypeDto> firstTypes = ftService.findAll();
						req.getSession().setAttribute("goodFirstTypes", firstTypes);

						return "index";
					}
				}
			}
		}

		return "login";
	}

	/**
	 * 前台注销账户
	 * @param req
	 * @return
	 */
	@RequestMapping("/goawaybefore")
	public String logoutBefore(HttpServletRequest req, HttpServletResponse resp) {
		Cookie cookie = new Cookie("token", null);
		cookie.setMaxAge(0);// 立即销毁cookie
		cookie.setPath("/");
		resp.addCookie(cookie);
		req.getSession().setAttribute("realuser", null);
		return "login";

	}

	/**
	 * 后台登录页面加载
	 * @return
	 */
	@RequestMapping(value = "/backLogin", method = RequestMethod.GET)
	public String login(String error, Map<String, Object> map) {
		map.put("error", error);
		logger.info("赐我后台登陆页面吧！");
		return "back/backLogin";
	}

	/**
	 * 请求后台登陆 在这里使用自定义注解@logginManager来将登陆方法设置成为AspectJ切入的连接点
	 * @param user
	 * @param req
	 * @param webpagetype
	 * @return
	 */
	@RequestMapping(value = "/backLogin", method = RequestMethod.POST)
	@LoggingManager(description = "进行管理登陆")
	public String login(UserDto user, HttpServletRequest req, String webpagetype,String loginType,Model model) {

		if ("back".equals(webpagetype)) {
			UserDto dto = userService.authenticate(req, user,loginType,model);
			if (!"".equals(dto.getPassword())) {
				req.getSession().setAttribute("backUser", dto);
				return "back/main";
			}
			return "back/backLogin";
		}
		return "back/error";
	}

	/**
	 * 后台退出系统
	 */
	@RequestMapping(value = "/logout")
	public String logout(String loginType, HttpServletRequest req, SessionStatus status) {
		HttpSession session = req.getSession();
		session.removeAttribute("backUser");
		session.setAttribute("loginType", "");
		status.setComplete();
		return "redirect:login";
	}

}
