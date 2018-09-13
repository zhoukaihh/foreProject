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
		if (size % 8 != 0) {
			pageNum = size / 8 + 1;
		}else{
			pageNum = size / 8;
		}
		
		Integer pageNum1 = new Integer(pageNum);
		return pageNum1;
	}

	@Override
	public List<SecondTypeDto> findAllSecondType(Integer pageNo) {
		// 设置分页
		Integer length = 8;
		PageHelper.startPage(pageNo, length);

		// 查询所有数据
		List<SecondType> pos = scMapper.selectByExample(new SecondTypeExample());

		List<SecondType> pos1 = new ArrayList<SecondType>();
		
		// 设置分类级别
		for (SecondType po : pos) {
			FirstType fType = fMapper.selectByPrimaryKey(po.getFirstTypeId());
			po.setFirstType(fType);
			pos1.add(po);
		}
		return SecondTypeDto.getDtos(pos1);
	}

	/**
	 * 创建类别
	 */
	@Override
	public void create(String secondTypeName, Integer firstTypeId) {
		// 获取父类别
		FirstType firstType = fMapper.selectByPrimaryKey(firstTypeId);
		logger.info("添加二级类别是获取的一级类别：" + firstType);
		// 保存二级类别数据
		SecondType po = new SecondType();
		po.setSecondTypeName(secondTypeName);
		po.setFirstTypeId(firstTypeId);

		scMapper.insertSelective(po);
	}

	/**
	 * 通过id查询
	 */
	@Override
	public SecondType findById(Integer secondTypeId) {
		//查询po
		SecondType po = scMapper.selectByPrimaryKey(secondTypeId);
		//查询po的firstId获取父级类别
		FirstType firstType = fMapper.selectByPrimaryKey(po.getFirstTypeId());
		//给po设置父级
		po.setFirstType(firstType);
		
		return po;
	}

	/**
	 * 查询所有
	 * @return
	 */
	public List<SecondTypeDto> findAll(){
		List<SecondType> pos = scMapper.selectByExample(new SecondTypeExample());
		return SecondTypeDto.getDtos(pos);
	}
	
	/**
	 * 修改该信息
	 */
	@Override
	public void update(SecondTypeDto dto, Integer firstTypeId) {
		SecondType po = new SecondType();
		po.setSecondTypeId(dto.getSecondTypeId());
		po.setFirstTypeId(firstTypeId);
		po.setSecondTypeName(dto.getSecondTypeName());
		scMapper.updateByPrimaryKey(po);
		
	}
	
	/**
	 * 删除信息
	 */
	@Override
	public void delete(Integer secondTypeId) {
		scMapper.deleteByPrimaryKey(secondTypeId);
	}

	/**
	 * 根据一级id查询下属二级类别
	 * @param firstTypeId
	 * @return
	 */
	public List<SecondTypeDto> findSecondByFist(Integer firstTypeId) {
		SecondTypeExample sex = new SecondTypeExample();
		sex.createCriteria().andFirstTypeIdEqualTo(firstTypeId);
		List<SecondType> list = scMapper.selectByExample(sex);
		return SecondTypeDto.getDtos(list);
	}

}
