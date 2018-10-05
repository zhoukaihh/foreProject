package com.qf.shopping.service;

import java.util.List;

import com.qf.shopping.dto.OrderDto;
import com.qf.shopping.pojo.Order;

public interface IOrderService {

	Integer findAllPage();

	List<OrderDto> findAllOrders(Integer pageNo);

	OrderDto findById(Integer orderId);

	void updateAddress(OrderDto dto);

	void saveOrder(Order order, String orderNum);

	List<Order> findByNum(String orderNum);

	void update(Order order1);

	void update(OrderDto order);

}
