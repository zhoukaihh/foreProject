package com.qf.shopping.controll;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.shopping.dto.MenuDto;
import com.qf.shopping.service.IMenuService;

@Controller
@RequestMapping("/permitions")
public class MenuController {

	private static Logger logger = Logger.getLogger(WareController.class);

	@Autowired
	private IMenuService menuService;
	
	@RequestMapping("/list")
	public String findAllMenu(Model model){
		List<MenuDto> dtos = menuService.findAllMenu();
		model.addAttribute("perms", dtos);
		return "back/menu/permlist";
	}
	
	/**
	 * 角色获取权限信息
	 * @return
	 */
	@RequestMapping("/getAll")
	@ResponseBody
	public List<MenuDto> getAllPermition(){
		List<MenuDto> dtos = menuService.findAllMenu();
		return dtos;
	}
	
	/**
	 * 创建权限
	 * @param dto
	 * @return
	 */
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create(MenuDto dto){
		menuService.create(dto);
		return "redirect:/permitions/list";
	}
	
	/**
	 * 修改资源权限
	 * @param permId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(Integer permId,Model model){
		MenuDto dto = menuService.findById(permId);
		model.addAttribute("perm", dto);
		return "back/menu/permUpdate";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(MenuDto dto){
		menuService.update(dto);
		return "redirect:/permitions/list";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer permId){
		menuService.delete(permId);
		return "redirect:/permitions/list";
	}
}
