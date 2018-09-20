package com.qf.shopping.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.shopping.dto.FirstTypeDto;
import com.qf.shopping.mapper.FirstTypeMapper;
import com.qf.shopping.mapper.SecondTypeMapper;
import com.qf.shopping.mapper.WareMapper;
import com.qf.shopping.pojo.FirstType;
import com.qf.shopping.pojo.FirstTypeExample;
import com.qf.shopping.pojo.SecondType;
import com.qf.shopping.pojo.SecondTypeExample;
import com.qf.shopping.pojo.Ware;
import com.qf.shopping.pojo.WareExample;
import com.qf.shopping.service.IFirstTypeService;

@Service
@Transactional
public class FirstTypeService implements IFirstTypeService {

	private static Logger logger = Logger.getLogger(FirstTypeService.class);
	
	@Autowired
	private FirstTypeMapper firstMapper;
	
	@Autowired
	private SecondTypeMapper scMapper;
	
	@Autowired
	private WareMapper wareMapper;
	
	

	@Override
	public List<FirstTypeDto> findAll() {
		//查询所有一级
		List<FirstType> pos = firstMapper.selectByExample(new FirstTypeExample());
		//遍历一级
		for (FirstType firstType : pos) {
			//查询所有二级
			SecondTypeExample sce = new SecondTypeExample();
			sce.createCriteria().andFirstTypeIdEqualTo(firstType.getFirstTypeId());
			List<SecondType> scTypes = scMapper.selectByExample(sce);
			//遍历所有二级
			for (SecondType secondType : scTypes) {
				//查询该二级的所有商品
				WareExample wex = new WareExample();
				wex.createCriteria().andSecondTypeIdEqualTo(secondType.getSecondTypeId());
				List<Ware> wares = wareMapper.selectByExample(wex);
				//添加商品到二级
				secondType.setWares(wares);
			}
			//添加二级到对应一级
			firstType.setSecondTypes(scTypes);
		}
		
		
		List<FirstTypeDto> dtos = FirstTypeDto.getDtos(pos);
		return dtos;
	}



	@Override
	public FirstTypeDto findById(Integer firstTypeId) {
		FirstType po = firstMapper.selectByPrimaryKey(firstTypeId);
		//查询所有二级
		SecondTypeExample sce = new SecondTypeExample();
		sce.createCriteria().andFirstTypeIdEqualTo(po.getFirstTypeId());
		List<SecondType> scTypes = scMapper.selectByExample(sce);
		//遍历所有二级
		for (SecondType secondType : scTypes) {
			//查询该二级的所有商品
			WareExample wex = new WareExample();
			wex.createCriteria().andSecondTypeIdEqualTo(secondType.getSecondTypeId());
			List<Ware> wares = wareMapper.selectByExample(wex);
			//添加商品到二级
			secondType.setWares(wares);
		}
		//添加二级到对应一级
		po.setSecondTypes(scTypes);
		
		return new FirstTypeDto(po);
	}
	

}
