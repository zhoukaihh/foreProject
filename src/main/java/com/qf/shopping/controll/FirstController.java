package com.qf.shopping.controll;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qf.shopping.dto.FirstTypeDto;
import com.qf.shopping.service.IFirstTypeService;


@RestController
@RequestMapping("/firstType")
public class FirstController {

	private static Logger logger = Logger.getLogger(FirstController.class);

	@Autowired
	private IFirstTypeService firstService;
	
}
