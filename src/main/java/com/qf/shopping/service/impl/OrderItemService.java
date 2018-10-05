package com.qf.shopping.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.shopping.dto.WareDto;
import com.qf.shopping.mapper.OrderItemMapper;
import com.qf.shopping.mapper.StockMapper;
import com.qf.shopping.pojo.OrderItem;
import com.qf.shopping.pojo.OrderItemExample;
import com.qf.shopping.pojo.Stock;
import com.qf.shopping.service.IOrderItemService;
import com.qf.shopping.util.UUIDUtils;

@Service
@Transactional
public class OrderItemService implements IOrderItemService {

	private static Logger logger = Logger.getLogger(OrderItemService.class);

	@Autowired
	private OrderItemMapper orderItemMapper;
	
	@Autowired
	private StockMapper stockMapper;
	
	@Autowired
	private WareService goodService;
	
	/**
	 * 保存订单项,这里要锁库存
	 */
	@Override
	public void saveOrderItem(Integer orderId, WareDto dto,Integer payCount) {
		OrderItem orderItem = new OrderItem();
		
		orderItem.setGoodId(dto.getGoodId());
		orderItem.setGoodImage(dto.getGoodImage());
		orderItem.setGoodName(dto.getGoodName());
		orderItem.setGoodNums(dto.getGoodNums());
		Float price = Float.parseFloat(dto.getGoodPrice());
		orderItem.setGoodPrice(price);
		orderItem.setOrderId(orderId);
		orderItem.setBuyNum(payCount);
		orderItem.setGoodDes(dto.getGoodDes());
		Float total = price * payCount;
		orderItem.setItemTotal(Float.toString(total));
		
		//在这里要生成一把锁
		Stock stock = new Stock();
		stock.setGoodId(dto.getGoodId());
		stock.setGoodLockNum(payCount);
		String uuid = UUIDUtils.getUuid();
		stock.set_version(uuid);
		stockMapper.insert(stock);
		
		//这里要在订单项中标记锁版本号
		orderItem.set_version(uuid);
		//在商品库存中要减去相应的数量
		String goodNums = dto.getGoodNums();
		Integer num = Integer.valueOf(goodNums)-payCount;
		dto.setGoodNums(num.toString());
		goodService.update(dto);
		
		orderItemMapper.insert(orderItem);
	}


	@Override
	public OrderItem findByGoodId(Integer payId) {
		OrderItemExample oie = new OrderItemExample();
		oie.createCriteria().andGoodIdEqualTo(payId);
		
		List<OrderItem> orderItem = orderItemMapper.selectByExample(oie);
		
		return orderItem.get(0);
	}

	/**
	 * 查询某个订单的所有订单项
	 */
	@Override
	public List<OrderItem> findByOrder(Integer orderId) {
		OrderItemExample oie = new OrderItemExample();
		oie.createCriteria().andOrderIdEqualTo(orderId);
		List<OrderItem> orderItems = orderItemMapper.selectByExample(oie);
		
		return orderItems;
	}

}
