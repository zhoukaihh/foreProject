package com.qf.shopping.controll;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.shopping.dto.OrderDto;
import com.qf.shopping.dto.WareDto;
import com.qf.shopping.pojo.Order;
import com.qf.shopping.pojo.OrderItem;
import com.qf.shopping.pojo.User;
import com.qf.shopping.service.IOrderItemService;
import com.qf.shopping.service.IOrderService;
import com.qf.shopping.service.IWareService;
import com.qf.shopping.util.UUIDUtils;

@Controller
@RequestMapping("/orders")
public class OrderController {

	private static Logger logger = Logger.getLogger(OrderController.class);

	@Autowired
	private IOrderService orderService;

	@Autowired
	private IOrderItemService orderItemService;

	@Autowired
	private IWareService goodService;

	
	/**
	 * 后台查询订单列表信息
	 * 
	 * @param pageNo
	 * @param model
	 * @return
	 */
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
		// logger.info("allPage是："+allPage+"---"+"当前页数是："+pageNo);
		return "back/order/orderlist";
	}

	/**
	 * 查询订单详情或修改该地址
	 * 
	 * @param orderId
	 * @param flag
	 * @param model
	 * @return
	 */
	@RequestMapping("/findOrderById")
	public String findOrderById(Integer orderId, String flag, Model model) {
		// 查询对应订单
		OrderDto order = orderService.findById(orderId);
		// 将两个对象放入域对象
		model.addAttribute("order", order);
		// 返回相应页面
		if ("show".equals(flag)) {
			return "back/order/orderItemlist";
		}
		return "back/order/updateAddress";
	}

	/**
	 * 修改订单地址
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping("/updateorder")
	public String updateAddress(OrderDto dto) {
		orderService.updateAddress(dto);
		return new StringBuffer("redirect:/orders/findOrderById?orderId=").append(dto.getOrderId()).append("&flag=show")
				.toString();
	}

	/**
	 * 前端提交后生成订单
	 * 
	 * @return
	 */
	@RequestMapping(value="/makeOrder")
	public String makeOrder(HttpServletRequest req ,Model model,Order order,Integer[] payId,Integer[] payCount) {
		// 生成一个订单编号
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		String orderNum = new String(new StringBuilder(UUIDUtils.getUuid()).append(dateString));
		// 先保存一下订单
		orderService.saveOrder(order, orderNum);
		// 再根据订单编号查出这个订单
		List<Order> orders = orderService.findByNum(orderNum);
		Order order1 = orders.get(0);
		//得到订单id
		Integer orderId = order1.getOrderId();
		//设置订单总价
		Float total = Float.valueOf(0.0F);
		//设置总购买数
		int goodAllSize = 0;
		
		//保存订单项，每一个提交的商品是一个订单项
		for (int i = 0; i < payId.length; i++) {
			for (int j = 0; j < payCount.length; j++) {
				if (i == j) {
					//获取相应商品
					WareDto dto = goodService.findById(payId[i]);
					//保存相应订单项
					orderItemService.saveOrderItem(orderId,dto,payCount[j]);
					//设置总价
					Float price = Float.parseFloat(dto.getGoodPrice());
					total += (price*payCount[j]);
					//设置总购买数
					goodAllSize += payCount[j];
				}
			}
		}
		//获取订单的所有订单项
		List<OrderItem> orderItems = orderItemService.findByOrder(orderId);
		//设置订单时间戳
		long time = new Date().getTime();
		String time1 = String.valueOf(time);
		order1.setOrderTime(time1);
		order1.setState("未付款");
		order1.setOrderTotalMoney(total);
		//设置用户信息
		User user = (User) req.getSession().getAttribute("realuser");
		order1.setUsreId(user.getId());
		order1.setUser(user);
		order1.setOrderItems(orderItems);
		orderService.update(order1);
		
		List<OrderItem> orderItems2 = order1.getOrderItems();
		for (int i = 0; i < orderItems2.size(); i++) {
			logger.info("第"+i+"个订单项的购买数量是："+orderItems2.get(i).getBuyNum());
			logger.info("第"+i+"个订单项的购小计是："+orderItems2.get(i).getItemTotal());
		}
		
		model.addAttribute("order", order1);
		model.addAttribute("allSize", goodAllSize);
		
		return "payOrder";
	}
}
