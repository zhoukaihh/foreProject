package com.qf.shopping.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.qf.shopping.dto.WareDto;
import com.qf.shopping.mapper.SecondTypeMapper;
import com.qf.shopping.mapper.WareMapper;
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
	
	/**
	 * 获取总页数
	 */
	@Override
	public Integer findAllPage() {
		int pageNum;
		int size = wareMapper.countByExample(new WareExample());
		if (size%5 != 0) {
			pageNum = size/5 + 1;
		}
		pageNum = size/5;
		Integer pageNum1 =new Integer(pageNum);
		return pageNum1;
	}

	/**
	 * 获取所有商品数据
	 */
	@Override
	public List<WareDto> findAllgoods(Integer pageNo) {
		//设置分页
		int pageNo1 = pageNo.intValue();
		Integer start = new Integer((pageNo1-1)*5);
		Integer length = 5;
		PageHelper.startPage(SSMUtil.getPage(start, length), length);
		
		//查询所有数据
		List<Ware> pos = wareMapper.selectByExample(new WareExample());
				
		List<Ware> pos1 = new ArrayList<Ware>();;
		//设置分类级别
		for (Ware po : pos) {
			SecondType secondType = scMapper.selectByPrimaryKey(po.getSecondTypeId());
			po.setSecondType(secondType);
			pos1.add(po);
		}
		return WareDto.getWareDtos(pos1);
	}

	
}
