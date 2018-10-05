package com.qf.shopping.service;

import java.util.List;

import com.qf.shopping.dto.WareDto;
import com.qf.shopping.pojo.OrderItem;

public interface IOrderItemService {

	void saveOrderItem(Integer orderId, WareDto dto, Integer payCount);

	OrderItem findByGoodId(Integer payId);

	List<OrderItem> findByOrder(Integer orderId);

}
