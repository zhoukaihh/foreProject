package com.qf.shopping.listener;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSON;
import com.qf.shopping.dto.AdvertismentDto;
import com.qf.shopping.dto.FirstTypeDto;
import com.qf.shopping.manager.CacheManager;
import com.qf.shopping.service.IAdvertismentService;
import com.qf.shopping.service.IFirstTypeService;

@WebListener
public class MyContextLoadListener implements ServletContextListener {
	@Resource
	private IAdvertismentService adService;
	
	@Autowired
	private IFirstTypeService fService;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("监听的这里执行了");
		ApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(sce.getServletContext());
		CacheManager cacheManager = context.getBean(CacheManager.class);

		// 判断redis是否有广告的数据
			
		try {
			String ads = cacheManager.getAd();
			List<AdvertismentDto> dtos = adService.findAll();
			String jsonString = JSON.toJSONString(dtos);
			if (ads == null || !ads.equals(jsonString)) {
				// 如果没有或修改了，就添加
				cacheManager.putAd(jsonString);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		/**
	// 判断redis是否有分类的数据
//		String firsts = cacheManager.getFirstType();
		List<FirstTypeDto> dtos1 = fService.findAll();
		String jsonString1 = JSON.toJSONString(dtos1);
//		if (firsts == null || !firsts.equals(jsonString1)) {
			// 如果没有或修改了，就添加
			cacheManager.putFirstType(jsonString1);
//		}*/
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
