package com.qf.shopping.service;

import java.util.List;

import com.qf.shopping.dto.OrderDto;

public interface IOrderService {

	Integer findAllPage();

	List<OrderDto> findAllOrders(Integer pageNo);

	OrderDto findById(Integer orderId);

	void updateAddress(OrderDto dto);

}
