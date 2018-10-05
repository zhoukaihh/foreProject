package com.qf.shopping.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.shopping.mapper.StockMapper;
import com.qf.shopping.mapper.WareMapper;
import com.qf.shopping.pojo.Stock;
import com.qf.shopping.pojo.StockExample;
import com.qf.shopping.pojo.Ware;
import com.qf.shopping.service.IStockService;

@Service
@Transactional
public class StockService implements IStockService {

	private static Logger logger = Logger.getLogger(StockService.class);

	@Autowired
	private StockMapper stockMapper;
	
	@Autowired
	private WareMapper wareMapper;
	
	/**
	 * 查询订单项包含商品对应的所有锁
	 */
	@Override
	public List<Stock> findByGoodId(Integer goodId) {
		StockExample sex = new StockExample();
		sex.createCriteria().andGoodIdEqualTo(goodId);
		List<Stock> stocks = stockMapper.selectByExample(sex);
		
		return stocks;
	}

	/**
	 * 付款成功后就不需要了，直接删掉这把锁
	 */
	@Override
	public void deleteByStock(Integer stockId) {
		stockMapper.deleteByPrimaryKey(stockId);
	}

	/**
	 * 订单过期后进行锁资源归还处理
	 */
	@Override
	public void giveBackStock(Integer stockId) {
		Stock stock = stockMapper.selectByPrimaryKey(stockId);
		Ware good = wareMapper.selectByPrimaryKey(stock.getGoodId());
		Integer nums = Integer.valueOf(good.getGoodNums());
		Integer num = nums+stock.getGoodLockNum();
		good.setGoodNums(num.toString());
		
		stockMapper.deleteByPrimaryKey(stockId);
	}

}
