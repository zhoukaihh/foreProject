package com.qf.shopping.controll;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.shopping.dto.RoleDto;
import com.qf.shopping.dto.UserDto;
import com.qf.shopping.pojo.Item;
import com.qf.shopping.pojo.UserRoleKey;
import com.qf.shopping.service.IRoleService;
import com.qf.shopping.service.IUserService;

@Controller
@RequestMapping("/users")
public class UserControll {

	private static Logger logger = Logger.getLogger(UserControll.class);
	
	@Autowired
	private IUserService userService=null;
	
	@Autowired
	private IRoleService roleService;
	
	/**
	 * 查询所有用户在页面展示
	 */
	@RequestMapping("/list")
	public String findAll(Model model){
		try {
			List<UserDto> users=userService.findUserAll();
			model.addAttribute("userList", users);
		} catch (Exception e) {
			logger.error("获取所有用户失败");
			throw new RuntimeException(e.getMessage());
		}
		
		return "back/user/userinfo";
	}
	
	/**
	 * 请求创建用户页面
	 */
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String create(){
		
		return "back/user/adduser";
	}
	
	/**
	 * 添加用户并展示数据
	 */
	@RequestMapping(value="/create" , method=RequestMethod.POST)
	public String create(UserDto dto,String roleName){
		
		userService.create(dto,roleName);
		return "redirect:/users/list";
	}
	
	/**
	 * 修改用户
	 * @param dto
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(Integer id,Model model,String identity){
		UserDto dto = userService.findById(id,model);
		model.addAttribute("user", dto);
		model.addAttribute("identity", identity);
		return "back/user/updateuser";
	}
	
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(UserDto dto,String roleName){
		
		userService.update(dto,roleName);
		
		return "redirect:/users/list";
	}
	
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(Integer id){
		
		userService.delete(id);
		return "redirect:/users/list";
	}
	
	@RequestMapping("/vtos")
	public String vipToSeller(Integer id){
		userService.vipToSeller(id);
		return "redirect:/users/list";
	}
	
	/**
	 * echarts使用的数据
	 * @return
	 */
	@RequestMapping("/roleNums")
	@ResponseBody
	public List<Item> getRoleNums(){
		//查出所有用户
		List<UserDto> users = userService.findUserAll();
		//查出所有角色
		List<RoleDto> roles = roleService.findAllRole();
		//创建一个item数组
		ArrayList<Item> items = new ArrayList<Item>();
		
		for (RoleDto role : roles) {
			Item item = new Item();
			item.setName(role.getName());
			int value =0;
			for (UserDto user : users) {
				List<UserRoleKey> urks = userService.findUserRoleKey(user.getId());
				for (UserRoleKey urk : urks) {
					if (urk.getRole_id() == role.getId()) {
						value +=1;
					}
				}
			}
			item.setValue(value);
			items.add(item);
		}
		return items;
	}
}
