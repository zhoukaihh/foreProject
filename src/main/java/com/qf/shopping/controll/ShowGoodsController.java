package com.qf.shopping.controll;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.qf.shopping.dto.FirstTypeDto;
import com.qf.shopping.pojo.SecondType;
import com.qf.shopping.pojo.Ware;
import com.qf.shopping.service.IFirstTypeService;

@Controller
@RequestMapping("/showGoods")
public class ShowGoodsController {

	private static Logger logger = Logger.getLogger(ShowGoodsController.class);

	@Autowired
	private IFirstTypeService ftService;
	
	@RequestMapping("/findFTypeGoods")
	@ResponseBody
	public List<FirstTypeDto> findEveryFTypeGoodsOnePage(){
		
		//第一步，查询所有的一级,里面包含二级和商品
		List<FirstTypeDto> firstTypes = ftService.findAll();
		//设置返回前端持有商品的一级
		ArrayList<FirstTypeDto> firstTypes1 = new ArrayList<FirstTypeDto>();
		
		//将每一个一级所属的商品（二级中）设置到一级中
		for (FirstTypeDto dto : firstTypes) {
			//设置商品数量，用于计算总页数
			int sum = 0;
			int allPage;
			//设置一级的商品容器
			List<Ware> goods = new ArrayList<Ware>();
			List<SecondType> secondTypes = dto.getSecondTypes();
			for (SecondType secondType : secondTypes) {
				List<Ware> wares = secondType.getWares();
				for (Ware ware : wares) {
					goods.add(ware);
					sum +=1;
				}
			}
			//计算总页数，每页8个商品
			if (sum%8 != 0) {
				allPage = sum/8 + 1;
			}else{
				allPage = sum/8;
			}
			Integer allPage1 =new Integer(allPage);
			//设置当前页数为1
			Integer nowPage = 1;
			
			Integer length = 8;
			PageHelper.startPage(nowPage, length);
			//将需要的参数都设置进一级
			dto.setNowPage(nowPage);
			dto.setAllPage(allPage1);
			dto.setGoods(goods);
			
			firstTypes1.add(dto);
		}
		return firstTypes1;
	}

	
	@RequestMapping("/findFirstTypeGoodsOnePageByfirstTypeId")
	public FirstTypeDto findFirstTypeByid(Integer pageNo,Integer firstTypeId){
		
		FirstTypeDto dto = ftService.findById(firstTypeId);
		//设置当前页数为1
		Integer nowPage = 1;
		
		Integer length = 8;
		PageHelper.startPage(nowPage, length);
		//设置商品数量，用于计算总页数
		int sum = 0;
		int allPage;
		//设置一级的商品容器
		List<Ware> goods = new ArrayList<Ware>();
		List<SecondType> secondTypes = dto.getSecondTypes();
		for (SecondType secondType : secondTypes) {
			List<Ware> wares = secondType.getWares();
			for (Ware ware : wares) {
				goods.add(ware);
				sum +=1;
			}
		}
		//计算总页数，每页8个商品
		if (sum%8 != 0) {
			allPage = sum/8 + 1;
		}else{
			allPage = sum/8;
		}
		Integer allPage1 =new Integer(allPage);
		
		//将需要的参数都设置进一级
		dto.setNowPage(nowPage);
		dto.setAllPage(allPage1);
		dto.setGoods(goods);

		return dto;
	}
}
