package com.qf.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.qf.shopping.dto.OrderDto;
import com.qf.shopping.mapper.OrderItemMapper;
import com.qf.shopping.mapper.OrderMapper;
import com.qf.shopping.mapper.UserMapper;
import com.qf.shopping.pojo.Order;
import com.qf.shopping.pojo.OrderExample;
import com.qf.shopping.pojo.OrderItem;
import com.qf.shopping.pojo.OrderItemExample;
import com.qf.shopping.pojo.User;
import com.qf.shopping.service.IOrderService;

@Service
@Transactional
public class OrderService implements IOrderService {

	private static Logger logger = Logger.getLogger(OrderService.class);

	@Autowired
	private OrderMapper oMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private OrderItemMapper oItemMapper;
	
	/**
	 * 查询总页数
	 */
	@Override
	public Integer findAllPage() {
		int pageNum;
		int size = oMapper.countByExample(new OrderExample());
		if (size%5 != 0) {
			pageNum = size/5 + 1;
		}else{
			pageNum = size/5;
		}
		
		Integer pageNum1 =new Integer(pageNum);
		return pageNum1;
	}

	/**
	 * 查询所有订单
	 */
	@Override
	public List<OrderDto> findAllOrders(Integer pageNo) {
		Integer length = 5;
		PageHelper.startPage(pageNo, length);
		
		//查询所有数据
		List<Order> pos = oMapper.selectByExample(new OrderExample());
		List<Order> pos1 = new ArrayList<Order>();
		
		for (Order po : pos) {
			User user = userMapper.selectByPrimaryKey(po.getUsreId());
			po.setUser(user);
			
			OrderItemExample oie = new OrderItemExample();
			oie.createCriteria().andOrderIdEqualTo(po.getOrderId());
			List<OrderItem> orderItems = oItemMapper.selectByExample(oie);
			po.setOrderItems(orderItems);
			
			pos1.add(po);
		}
		return OrderDto.getDtos(pos1);
	}

	@Override
	public OrderDto findById(Integer orderId) {
		Order order = oMapper.selectByPrimaryKey(orderId);
		//查询相应的ordreItems
		OrderItemExample oie = new OrderItemExample();
		oie.createCriteria().andOrderIdEqualTo(orderId);
		List<OrderItem> orderItems = oItemMapper.selectByExample(oie);
		order.setOrderItems(orderItems);
		
		return new OrderDto(order);
	}

	/**
	 * 修改地址
	 */
	@Override
	public void updateAddress(OrderDto dto) {
		Order po = new Order();
		po.setOrderId(dto.getOrderId());
		po.setOrderNum(dto.getOrderNum());
		po.setOrderTotalMoney(dto.getOrderTotalMoney());
		po.setOrderShPeople(dto.getOrderShPeople());
		po.setOrderPayType(dto.getOrderPayType());
		po.setOrderShAddress(dto.getOrderShAddress());
		po.setOrderSendType(dto.getOrderSendType());
		po.setOderShTel(dto.getOderShTel());
		
		oMapper.updateByPrimaryKeySelective(po);
	}

	/**
	 * 保存订单
	 */
	@Override
	public void saveOrder(Order order,String orderNum) {
		Order po = new Order();
		po.setOrderShPeople(order.getOrderShPeople());
		po.setOrderSendType(order.getOrderSendType());
		po.setOrderPayType(order.getOrderPayType());
		po.setOderShTel(order.getOderShTel());
		po.setOrderShAddress(order.getOrderShAddress());
		po.setOrderNum(orderNum);
		
		oMapper.insert(po);
	}

	@Override
	public List<Order> findByNum(String orderNum) {
		OrderExample oex = new OrderExample();
		oex.createCriteria().andOrderNumEqualTo(orderNum);
		List<Order> selectByExample = oMapper.selectByExample(oex);
		return selectByExample;
	}

	@Override
	public void update(Order order1) {
		oMapper.updateByPrimaryKey(order1);
	}

	@Override
	public void update(OrderDto order) {
		Order po = new Order();
		po.setFlag(order.getFlag());
		po.setOderShTel(order.getOderShTel());
		po.setOrderId(order.getOrderId());
		po.setOrderItems(order.getOrderItems());
		po.setOrderNum(order.getOrderNum());
		po.setOrderPayType(order.getOrderPayType());
		po.setOrderSendType(order.getOrderSendType());
		po.setOrderShAddress(order.getOrderShAddress());
		po.setOrderShPeople(order.getOrderShPeople());
		po.setOrderTime(order.getOrderTime());
		po.setOrderTotalMoney(order.getOrderTotalMoney());
		po.setState(order.getState());
		po.setUser(order.getUser());
		po.setUsreId(order.getUsreId());
		
		oMapper.updateByPrimaryKey(po);
	}

}
