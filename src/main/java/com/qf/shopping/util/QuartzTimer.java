package com.qf.shopping.util;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.qf.shopping.dto.OrderDto;
import com.qf.shopping.pojo.OrderItem;
import com.qf.shopping.pojo.Stock;
import com.qf.shopping.service.IOrderItemService;
import com.qf.shopping.service.IOrderService;
import com.qf.shopping.service.IStockService;

@Component
public class QuartzTimer {

	private static Logger logger = Logger.getLogger(QuartzTimer.class);

	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IOrderItemService orderItemService;
	
	@Autowired
	private IStockService stockService;
	
	@Scheduled(cron = "0 */1 * * * ?")
	public void timer(){
		//测试定时器
		logger.info("定时执行");
		//执行定时监测业务
		List<OrderDto> orders = orderService.findAllOrders(1);
		for (OrderDto order : orders) {
			//判断订单的状态
			if ("未付款".equals(order.getState())) {
				String orderTime = order.getOrderTime();
				Long time1 = Long.valueOf(orderTime);
				long time2 = new Date().getTime();
				long time3 = time2 - time1;
				if (time3>900) {
					//这时订单已经过期了，需要归还锁资源
					//找到相对应的订单项
					List<OrderItem> orderItems = orderItemService.findByOrder(order.getOrderId());
					for (OrderItem orderItem : orderItems) {
						List<Stock> stocks = stockService.findByGoodId(orderItem.getGoodId());
						//找到版本号对应的锁
						for (Stock stock : stocks) {
							if (stock.get_version().equals(orderItem.get_version())) {
								stockService.giveBackStock(stock.getStockId());
							}
						}
					}
					//设置过期订单的状态为“待付款”
					order.setState("待付款");
					orderService.update(order);
				}
			}else if ("待付款".equals(order.getState())) {
				logger.info("您有订单处于待支付状态，请您及时完成");
			}
		}
	}
}
