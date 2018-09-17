package com.qf.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.qf.shopping.dto.UserActionDto;
import com.qf.shopping.mapper.UserActionMapper;
import com.qf.shopping.mapper.UserMapper;
import com.qf.shopping.pojo.User;
import com.qf.shopping.pojo.UserAction;
import com.qf.shopping.pojo.UserActionExample;
import com.qf.shopping.service.IUserActionService;

@Service
@Transactional
public class UserActionService implements IUserActionService {

	private static Logger logger = Logger.getLogger(UserActionService.class);

	@Autowired
	private UserActionMapper uActiongMapper;
	
	@Autowired
	private UserMapper uMapper;

	@Override
	public Integer findAllPage() {
		int pageNum;
		int size = uActiongMapper.countByExample(new UserActionExample());
		if (size%10 != 0) {
			pageNum = size/10 + 1;
		}else{
			pageNum = size/10;
		}
		
		Integer pageNum1 =new Integer(pageNum);
		return pageNum1;
	}

	@Override
	public List<UserActionDto> findAllBehavior(Integer pageNo) {
		//设置分页
				Integer length = 10;
				PageHelper.startPage(pageNo, length);
				
				//查询所有数据
				List<UserAction> pos = uActiongMapper.selectByExample(new UserActionExample());
						
				List<UserAction> pos1 = new ArrayList<UserAction>();;
				//设置分类级别
				for (UserAction po : pos) {
					User user = uMapper.selectByPrimaryKey(po.getUserId());
					po.setUser(user);
					pos1.add(po);
				}
				return UserActionDto.getDtos(pos1);
	}

	/**
	 * 保存用户的行为记录
	 */
	@Override
	public void addRecord(UserAction record) {
		uActiongMapper.insertSelective(record);
	}

}
