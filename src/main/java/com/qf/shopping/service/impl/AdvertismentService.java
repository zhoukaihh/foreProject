package com.qf.shopping.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.qf.shopping.dto.AdvertismentDto;
import com.qf.shopping.mapper.AdvertismentMapper;
import com.qf.shopping.pojo.Advertisment;
import com.qf.shopping.pojo.AdvertismentExample;
import com.qf.shopping.service.IAdvertismentService;

@Service
@Transactional
public class AdvertismentService implements IAdvertismentService {

	private static Logger logger = Logger.getLogger(AdvertismentService.class);

	@Autowired
	private AdvertismentMapper adMapper;
	
	/**
	 * 获取总页数
	 */
	@Override
	public Integer findAllPage() {
		int pageNum;
		int size = adMapper.countByExample(new AdvertismentExample());
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
	public List<AdvertismentDto> findAllgoods(Integer pageNo) {
		Integer length = 5;
		PageHelper.startPage(pageNo, length);
		
		//查询所有数据
		List<Advertisment> pos = adMapper.selectByExample(new AdvertismentExample());
		
		for (Advertisment po : pos) {
			SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
		}
		
		return AdvertismentDto.getDtos(pos);
	}

	
	/**
	 * 创建广告
	 */
	@Override
	public void create(AdvertismentDto dto) {
		
		Date date2 = new Date();
		
		Advertisment po = new Advertisment();
		po.setAdType(dto.getAdType());
		po.setImgPath(dto.getImgPath());
		po.setAdStartTime(date2);
		adMapper.insert(po);
	}

	@Override
	public void delete(Integer adId) {
		adMapper.deleteByPrimaryKey(adId);
	}

	@Override
	public AdvertismentDto findById(Integer adId) {
		Advertisment po = adMapper.selectByPrimaryKey(adId);
		return new AdvertismentDto(po);
	}

	@Override
	public void update(AdvertismentDto dto) {
		Date date = new Date();
		
		Advertisment po = adMapper.selectByPrimaryKey(dto.getAdId());
		po.setAdType(dto.getAdType());
		po.setImgPath(dto.getImgPath());
		po.setAdStartTime(date);
		adMapper.updateByPrimaryKey(po);
	}

	/**
	 * 查询所有广告
	 */
	@Override
	public List<AdvertismentDto> findAll() {
		List<Advertisment> pos = adMapper.selectByExample(new AdvertismentExample());
		return AdvertismentDto.getDtos(pos);
	}
	
}
