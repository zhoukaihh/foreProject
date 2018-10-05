package com.qf.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.shopping.mapper.AddressMapper;
import com.qf.shopping.mapper.UserAddressMapper;
import com.qf.shopping.pojo.Address;
import com.qf.shopping.pojo.User;
import com.qf.shopping.pojo.UserAddressExample;
import com.qf.shopping.pojo.UserAddressKey;
import com.qf.shopping.service.IAddressService;

@Service
@Transactional
public class AddressService implements IAddressService {

	@Autowired
	private UserAddressMapper uaddMapper;
	
	@Autowired
	private AddressMapper addMapper;
	

	@Override
	public List<Address> getByUser(User user) {

		UserAddressExample uae = new UserAddressExample();
		uae.createCriteria().andUser_idEqualTo(user.getId());
		List<UserAddressKey> lists = uaddMapper.selectByExample(uae);
		
		ArrayList<Address> adds = new ArrayList<Address>();
		for (UserAddressKey userAddressKey : lists) {
			Integer addId = userAddressKey.getAdd_id();
			Address address = addMapper.selectByPrimaryKey(addId);
			adds.add(address);
		}
		
		return adds;
	}

}
