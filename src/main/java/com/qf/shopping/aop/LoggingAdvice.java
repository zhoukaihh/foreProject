package com.qf.shopping.aop;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.qf.shopping.annotation.LoggingManager;
import com.qf.shopping.dto.UserDto;
import com.qf.shopping.pojo.UserAction;
import com.qf.shopping.service.impl.UserActionService;

/**
 * 在这里声明一个切面类
 * 
 * @author Administrator
 *
 */
@Component
@Aspect
public class LoggingAdvice {

	private static Logger logger = Logger.getLogger(LoggingAdvice.class);

	@Autowired
	private UserActionService uaService;

	private Date startTime;
	/**
	 * 现在想在实现类中的每个方法执行前、后、以及是否发生异常等信息打印出来，需要把日志信息抽取出来，写到对应的切面的类中
	 * LoggingAspect.java 中 要想把一个类变成切面类，需要两步， ① 在类上使用 @Component 注解把切面类加入到IOC容器中
	 * ② 在类上使用 @Aspect 注解 使之成为切面类
	 * 用@Aspect注解方式来实现前置通知、返回通知、后置通知、异常通知、环绕通知（advice）。
	 */

	@Before(value = "@annotation(loggingManager)") // 这个注解表示运行时只要有loggingManager这个方法就会执行到这里来
	public void before(JoinPoint joinPoint, LoggingManager loggingManager) {
		/**
		 * AspectJ中的切入点匹配的执行点称作连接的（Join
		 * Point），在通知方法中可以声明一个JoinPoint类型的参数。通过JoinPoint可以访问连接点的细节。
		 * 下面简要介绍JponPoint的方法： 1.java.lang.Object[] getArgs()：获取连接点方法运行时的入参列表；
		 * 2.Signature getSignature() ：获取连接点的方法签名对象； 3.java.lang.Object
		 * getTarget() ：获取连接点所在的目标对象； 4.java.lang.Object getThis() ：获取代理对象本身；
		 */

		Object[] objects = joinPoint.getArgs();
		Date now = new Date();
		logger.info(now.toString() + "执行[" + loggingManager.description() + "]开始");
		startTime=new Date();
	}

	@After(value = "@annotation(loggingManager)")
	public void after(JoinPoint joinPoint, LoggingManager loggingManager) {
		Object[] objects = joinPoint.getArgs();
		Date now = new Date();
		logger.info(now.toString() + "执行[" + loggingManager.description() + "]结束");

		// 在这里进行用户行为日志的构建
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		UserDto dto = (UserDto) request.getSession().getAttribute("backUser");
		Date endTime = new Date();
		UserAction record = new UserAction();
		record.setBehavior(loggingManager.description());
		record.setStartTime(startTime);
		record.setEndTime(endTime);
		record.setState("成功");
		record.setUserId(dto.getId());
		uaService.addRecord(record);
	}
}
