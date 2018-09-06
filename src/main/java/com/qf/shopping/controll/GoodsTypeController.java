package com.qf.shopping.controll;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.shopping.dto.SecondTypeDto;
import com.qf.shopping.service.ISecondTypeService;


@Controller
@RequestMapping("/goodTypes")
public class GoodsTypeController {

	private static Logger logger = Logger.getLogger(GoodsTypeController.class);
	
	@Autowired
	private ISecondTypeService scService;
	
	@RequestMapping("/list")
	public String findByPage(Integer pageNo, Model model){
		//获取总页数
				Integer allPage = scService.findAllPage();
				model.addAttribute("allPage", allPage);
				//获取所有商品数据
				List<SecondTypeDto> dtos = scService.findAllSecondType(pageNo);
				model.addAttribute("scTypes", dtos);
				//设置当前页数
				model.addAttribute("currentpage", pageNo);
				
				return "goodstype/goodstype";
	}
}
