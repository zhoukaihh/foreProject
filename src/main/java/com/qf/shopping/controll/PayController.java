package com.qf.shopping.controll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.shopping.dto.OrderDto;
import com.qf.shopping.pojo.OrderItem;
import com.qf.shopping.pojo.Stock;
import com.qf.shopping.service.IOrderItemService;
import com.qf.shopping.service.IOrderService;
import com.qf.shopping.service.IStockService;

@Controller
@RequestMapping("/pay")
public class PayController {

	private static Logger logger = Logger.getLogger(PayController.class);

	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IOrderItemService orderItemService;
	
	@Autowired
	private IStockService stockService;
	
	@RequestMapping("/hasPay")
	public String hasPay(HttpServletRequest req ,Integer orderId){
		//我也咩有写付款的逻辑，所以这里点击支付就当成功付款吧
		//先判断一下订单的状态,这里考虑有两种，过期是待付款，没过期是未付款
		OrderDto order1 = orderService.findById(orderId);
		if ("待付款".equals(order1.getState())) {
			logger.info("从新上锁");
		}
		//找到相对应的订单项
		List<OrderItem> orderItems = orderItemService.findByOrder(orderId);
		for (OrderItem orderItem : orderItems) {
			List<Stock> stocks = stockService.findByGoodId(orderItem.getGoodId());
			//找到版本号对应的锁
			for (Stock stock : stocks) {
				if (stock.get_version().equals(orderItem.get_version())) {
					stockService.deleteByStock(stock.getStockId());
				}
			}
			logger.info("订单失效");
		}
		//支付成功过后就要将订单状态修改成“已完成支付”
		order1.setState("已完成支付");
		orderService.update(order1);
		
		req.setAttribute("order", order1);
		return "success";
	}
	
	
	
	
}
