package com.qf.shopping.controll;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qf.shopping.dto.RoleDto;
import com.qf.shopping.service.IRoleService;

@Controller
@RequestMapping("/roles")
public class RoleController {

	private static Logger logger = Logger.getLogger(WareController.class);

	@Autowired
	private IRoleService roleService;
	
	/**
	 * 查询所有角色信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String findAllRole(Model model ){
		List<RoleDto> dtos = roleService.findAllRole();
		model.addAttribute("roles", dtos);
		return "back/role/rolelist";
	}
	
	/**
	 * 创建角色
	 * @param dto
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create(RoleDto dto , Integer[] ids){
		
		roleService.create(dto,ids);
		return "redirect:/roles/list";
	}
	
	/**
	 * 修改角色信息
	 * @param roleId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(Integer roleId,Model model){
		RoleDto dto = roleService.findById(roleId);
		model.addAttribute("role", dto);
		return "back/role/roleupdate";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(RoleDto dto , Integer[] ids){
		roleService.update(dto,ids);
		return "redirect:/roles/list";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer roleId){
		roleService.delete(roleId);
		return "redirect:/roles/list";
	}
	 
}
