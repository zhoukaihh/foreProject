package com.qf.shopping.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.shopping.service.IAddressService;

@Controller
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private IAddressService addServcie;
	
}
