package com.qf.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.qf.shopping.dto.SecondTypeDto;
import com.qf.shopping.mapper.FirstTypeMapper;
import com.qf.shopping.mapper.SecondTypeMapper;
import com.qf.shopping.pojo.FirstType;
import com.qf.shopping.pojo.SecondType;
import com.qf.shopping.pojo.SecondTypeExample;
import com.qf.shopping.service.ISecondTypeService;
import com.qf.shopping.util.SSMUtil;

@Service
@Transactional
public class SecondTypeSrervice implements ISecondTypeService {

	private static Logger logger = Logger.getLogger(SecondTypeSrervice.class);

	@Autowired
	private SecondTypeMapper scMapper;
	
	@Autowired
	private FirstTypeMapper fMapper;
	
	@Override
	public Integer findAllPage() {
		int pageNum;
		int size = scMapper.countByExample(new SecondTypeExample());
		if (size%8 != 0) {
			pageNum = size/8 + 1;
		}
		pageNum = size/8;
		Integer pageNum1 =new Integer(pageNum);
		return pageNum1;
	}

	@Override
	public List<SecondTypeDto> findAllSecondType(Integer pageNo) {
		//设置分页
				int pageNo1 = pageNo.intValue();
				Integer start = new Integer((pageNo1-1)*8);
				Integer length = 8;
				PageHelper.startPage(SSMUtil.getPage(start, length), length);
				
				//查询所有数据
				List<SecondType> pos = scMapper.selectByExample(new SecondTypeExample());
						
				List<SecondType> pos1 = new ArrayList<SecondType>();;
				//设置分类级别
				for (SecondType po : pos) {
					FirstType fType = fMapper.selectByPrimaryKey(po.getFirstTypeId());
					po.setFirstType(fType);
					pos1.add(po);
				}
				return SecondTypeDto.getDtos(pos1);
	}

	
}
