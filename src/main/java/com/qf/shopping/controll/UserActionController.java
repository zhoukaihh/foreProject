package com.qf.shopping.controll;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.shopping.dto.UserActionDto;
import com.qf.shopping.service.IUserActionService;

@Controller
@RequestMapping("/behaviour")
public class UserActionController {

	private static Logger logger = Logger.getLogger(UserActionController.class);

	@Autowired
	private IUserActionService uActionService;

	@RequestMapping("/list")
	public String findByPage(Integer pageNo , Model model ) {
		// 获取总页数
		Integer allPage = uActionService.findAllPage();
		model.addAttribute("allPage", allPage);
		// 获取所有商品数据
		List<UserActionDto> dtos = uActionService.findAllBehavior(pageNo);
		model.addAttribute("behaviors", dtos);
		// 设置当前页数
		model.addAttribute("currentpage", pageNo);

		return "back/behavior/showbehavior";
	}
}
