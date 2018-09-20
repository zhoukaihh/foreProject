package com.qf.shopping.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.shopping.dto.WareDto;
import com.qf.shopping.mapper.FirstTypeMapper;
import com.qf.shopping.mapper.SecondTypeMapper;
import com.qf.shopping.mapper.WareMapper;
import com.qf.shopping.pojo.FirstType;
import com.qf.shopping.pojo.SecondType;
import com.qf.shopping.pojo.Ware;
import com.qf.shopping.pojo.WareExample;
import com.qf.shopping.service.IWareService;
import com.qf.shopping.util.SSMUtil;

@Service
@Transactional
public class WareService implements IWareService {

	private static Logger logger = Logger.getLogger(WareService.class);
	
	@Autowired
	private WareMapper wareMapper;
	
	@Autowired
	private SecondTypeMapper scMapper;
	
	@Autowired
	private FirstTypeMapper fMapper;
	
	/**
	 * 获取总页数
	 */
	@Override
	public Integer findAllPage() {
		int pageNum;
		int size = wareMapper.countByExample(new WareExample());
		logger.info("查出数据总量："+size);
		if (size%5 != 0) {
			pageNum = size/5 + 1;
		}else{
			pageNum = size/5;
		}
		
		Integer pageNum1 =new Integer(pageNum);
		return pageNum1;
	}

	/**
	 * 获取所有商品数据
	 */
	@Override
	public List<WareDto> findAllgoods(Integer pageNo) {
		
		//查询所有数据
		List<Ware> pos = wareMapper.selectByExample(new WareExample());
		
		List<Ware> pos1 = new ArrayList<Ware>();
		//设置分类级别
		for (Ware po : pos) {
			//查询每个商品的二级分类
			SecondType secondType = scMapper.selectByPrimaryKey(po.getSecondTypeId());
			//查询每个商品的一级分类
			FirstType firstType = fMapper.selectByPrimaryKey(secondType.getFirstTypeId());
			//设置一级分类
			secondType.setFirstType(firstType);
			//设置二级分类
			po.setSecondType(secondType);
			//设置所有商品数据
			pos1.add(po);
		}
		return WareDto.getWareDtos(pos1);
	}

	/**
	 * 创建商品
	 */
	@Override
	public void create(WareDto dto) {
		Ware po = new Ware();
		po.setGoodDes(dto.getGoodDes());
		po.setGoodwNum(dto.getGoodwNum());
		po.setGoodDiscountPrice(dto.getGoodDiscountPrice());
		po.setGoodId(dto.getGoodId());
		po.setGoodImage(dto.getGoodImage());
		po.setGoodName(dto.getGoodName());
		po.setGoodNums(dto.getGoodNums());
		po.setGoodPrice(dto.getGoodPrice());
		po.setSecondTypeId(dto.getSecondTypeId());
		
		wareMapper.insert(po);
		
	}

	
	@Override
	public void delete(Integer goodId) {
		wareMapper.deleteByPrimaryKey(goodId);
	}

	@Override
	public WareDto findById(Integer goodId) {
		Ware po = wareMapper.selectByPrimaryKey(goodId);
		
		return new WareDto(po);
	}

	@Override
	public void update(WareDto dto) {
		Ware po = new Ware();
		po.setGams(dto.getGams());
		po.setGewNum(dto.getGewNum());
		po.setGlNum(dto.getGlNum());
		po.setGms(dto.getGms());
		po.setGnum(dto.getGnum());
		po.setGoodDes(dto.getGoodDes());
		po.setGoodDiscountPrice(dto.getGoodDiscountPrice());
		po.setGoodId(dto.getGoodId());
		po.setGoodImage(dto.getGoodImage());
		po.setGoodName(dto.getGoodName());
		po.setGoodNums(dto.getGoodNums());
		po.setGoodPrice(dto.getGoodPrice());
		po.setGoodwNum(dto.getGoodwNum());
		po.setSecondTypeId(dto.getSecondTypeId());
		po.setVersion(dto.getVersion());
		
		wareMapper.updateByPrimaryKey(po);
		
	}

	
}
