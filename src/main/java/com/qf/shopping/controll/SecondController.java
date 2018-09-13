package com.qf.shopping.controll;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.shopping.dto.FirstTypeDto;
import com.qf.shopping.dto.SecondTypeDto;
import com.qf.shopping.pojo.SecondType;
import com.qf.shopping.service.IFirstTypeService;
import com.qf.shopping.service.ISecondTypeService;

@Controller
@RequestMapping("/goodTypes")
public class SecondController {

	private static Logger logger = Logger.getLogger(SecondController.class);

	@Autowired
	private ISecondTypeService scService;

	@Autowired
	private IFirstTypeService firstService;

	@RequestMapping("/list")
	public String findByPage(Integer pageNo, Model model) {
		// 获取总页数
		Integer allPage = scService.findAllPage();
		model.addAttribute("allPage", allPage);
		// 获取所有商品类别数据
		List<SecondTypeDto> dtos = scService.findAllSecondType(pageNo);
		model.addAttribute("scTypes", dtos);
		// 设置当前页数
		model.addAttribute("currentpage", pageNo);

		return "back/goodstype/goodstype";
	}

	//查询一级类别
	@RequestMapping("/getFirst")
	public String getFirstTypes(Model model) {
		List<FirstTypeDto> dtos = firstService.findAll();
		model.addAttribute("firstTypes", dtos);
		return "back/goodstype/goodstypeadd";
	}

	@RequestMapping("/getJsonFirst")
	@ResponseBody
	public List<FirstTypeDto> find(){
		List<FirstTypeDto> dtos = firstService.findAll();
		return dtos;
	}
	/**
	 * 创建商品类别
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(String secondTypeName, Integer firstTypeId) {
		scService.create(secondTypeName, firstTypeId);
		
		return "back/goodstype/goodstype";
	}

	/**
	 * 通过id查询要修改的信息
	 * @param secondTypeId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String findById(Integer secondTypeId, Model model) {
		SecondType po = scService.findById(secondTypeId);
		model.addAttribute("secondType", new SecondTypeDto(po));
		List<FirstTypeDto> firstDto = firstService.findAll();
		model.addAttribute("firstTypes", firstDto);
		return "back/goodstype/goodstypeupdate";
	}
	
	/**
	 * 修改信息
	 * @param dto
	 * @param firstTypeId
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(SecondTypeDto dto,Integer firstTypeId){
		
		scService.update(dto,firstTypeId);
		return "redirect:/goodTypes/list?pageNo=1";
	}
	
	/**
	 * 删除信息
	 * @param secondTypeId
	 * @param pageNo
	 * @param model
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(Integer secondTypeId,Integer pageNo,Model model){
		scService.delete(secondTypeId);
		
		 
		return (new StringBuilder("redirect:/goodTypes/list?pageNo=")).append(pageNo).toString();
	}
	
}
