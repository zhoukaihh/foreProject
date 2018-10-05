package com.qf.shopping.service;

import java.util.List;

import com.qf.shopping.pojo.Stock;

public interface IStockService {

	List<Stock> findByGoodId(Integer goodId);

	void deleteByStock(Integer stockId);

	void giveBackStock(Integer stockId);

}
