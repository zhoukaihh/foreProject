package com.qf.shopping.service;

import java.util.List;

import com.qf.shopping.pojo.Address;
import com.qf.shopping.pojo.User;

public interface IAddressService {

	List<Address> getByUser(User user);

}
