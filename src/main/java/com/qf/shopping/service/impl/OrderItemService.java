package com.qf.shopping.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.shopping.service.IOrderItemService;

@Service
@Transactional
public class OrderItemService implements IOrderItemService {

	private static Logger logger = Logger.getLogger(OrderItemService.class);

}
