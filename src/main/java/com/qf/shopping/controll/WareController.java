package com.qf.shopping.controll;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.shopping.dto.WareDto;
import com.qf.shopping.service.IWareService;


@Controller
@RequestMapping("/goods")
public class WareController {

	private static Logger logger = Logger.getLogger(WareController.class);
	
	@Autowired
	private IWareService wareService;
	
	@RequestMapping("/list")
	public String findByPage(Integer pageNo,Model model){
		//获取总页数
		Integer allPage = wareService.findAllPage();
		model.addAttribute("allPage", allPage);
		//获取所有商品数据
		List<WareDto> dtos = wareService.findAllgoods(pageNo);
		model.addAttribute("goods", dtos);
		//设置当前页数
		model.addAttribute("currentpage", pageNo);
		
		return "goods/goodsList";
	}
}
