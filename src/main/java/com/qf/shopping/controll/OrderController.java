package com.qf.shopping.controll;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.shopping.dto.OrderDto;
import com.qf.shopping.service.IOrderItemService;
import com.qf.shopping.service.IOrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {

	private static Logger logger = Logger.getLogger(OrderController.class);

	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IOrderItemService orderItemService;

	@RequestMapping("/list")
	public String findByPage(Integer pageNo, Model model) {
		// 获取总页数
		Integer allPage = orderService.findAllPage();
		model.addAttribute("allPage", allPage);
		
		// 获取所有订单数据
		List<OrderDto> dtos = orderService.findAllOrders(pageNo);
		model.addAttribute("orders", dtos);
		// 设置当前页数
		model.addAttribute("currentpage", pageNo);
//		logger.info("allPage是："+allPage+"---"+"当前页数是："+pageNo);
		return "back/order/orderlist";
	}
	
	/**
	 * 查询订单详情或修改该地址
	 * @param orderId
	 * @param flag
	 * @param model
	 * @return
	 */
	@RequestMapping("/findOrderById")
	public String findOrderById(Integer orderId,String flag,Model model){
		//查询对应订单
		OrderDto order = orderService.findById(orderId);
		//将两个对象放入域对象
		model.addAttribute("order", order);
		//返回相应页面
		if ("show".equals(flag)) {
			return "back/order/orderItemlist";
		}
		return "back/order/updateAddress";
	}
	
	/**
	 * 修改订单地址
	 * @param dto
	 * @return
	 */
	@RequestMapping("/updateorder")
	public String updateAddress(OrderDto dto){
		orderService.updateAddress(dto);
		return new StringBuffer("redirect:/orders/findOrderById?orderId=").append(dto.getOrderId()).append("&flag=show").toString();
	}
	
}
