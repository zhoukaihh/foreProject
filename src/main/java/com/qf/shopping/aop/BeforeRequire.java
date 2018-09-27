package com.qf.shopping.aop;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.qf.shopping.annotation.BeforeRequirManager;
import com.qf.shopping.controll.UserControll;
import com.qf.shopping.manager.CacheManager;
import com.qf.shopping.pojo.User;
import com.qf.shopping.service.IUserService;

@Component
@Aspect
public class BeforeRequire {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private CacheManager  cacheManager;
	
	@Autowired
	private UserControll userController;
	
	/**
	 * 这里是免登陆的验证
	 * @return
	 */
	@Before(value = "@annotation(beforeRequirManager)")
	public void beforRequire(JoinPoint joinPoint,BeforeRequirManager beforeRequirManager){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Cookie[] cookies = request.getCookies();
		userService.beforeRequireSeting(request);
		for (Cookie cookie : cookies) {
			if (cookie != null) {
				String cookieName = cookie.getName();
				String cookieValue = cookie.getValue();
				
				if ("token".equals(cookieName)) {
					Boolean b = checkCookieValue(request,cookieValue);
//					if (b) {
//						userController.getin();
//					}
				}
			}
		}
//		userController.getin();
	}
	//验证这个sessionId在redis里面是否有对应的验证信息
	private Boolean checkCookieValue(HttpServletRequest request, String cookieValue) {
		Boolean flag = false;
		String user = cacheManager.getSessionId(cookieValue);

		if (user != null) {
			User user1 = JSON.parseObject(user, User.class);
			//设置首页需要的数据
			request.getSession().setAttribute("realuser", user1);
			flag = true;
		}
		return flag;
	}
}
