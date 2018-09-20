package com.qf.shopping.controll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.qf.shopping.dto.AdvertismentDto;
import com.qf.shopping.dto.FirstTypeDto;
import com.qf.shopping.dto.WareDto;
import com.qf.shopping.manager.CacheManager;
import com.qf.shopping.pojo.ShoppingCar;
import com.qf.shopping.pojo.ShoppingCarItem;
import com.qf.shopping.service.IWareService;
import com.qf.shopping.service.impl.FirstTypeService;

@Controller
@RequestMapping("/shopcar")
public class ShoppingCarController {

	private static Logger logger = Logger.getLogger(ShoppingCarController.class);

	@Autowired
	private IWareService goodService;
	
	@Autowired
	private CacheManager  cacheManager;
	
	@Autowired
	private FirstTypeService ftService;
	
	/**
	 * 将商品添加到购物车
	 * @param goodId
	 * @param count
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String addToShopCar(Integer goodId , Integer count,Model model){
		//查询出要添加的商品信息
		WareDto good = goodService.findById(goodId);
		//设置添加的购物项
		ShoppingCarItem item = new ShoppingCarItem();
		item.setCount(count);
		item.setGood(good);
		Float price = Float.parseFloat(good.getGoodPrice());
		item.setMoney(price*count);
		//设置添加成功展示的数据
		model.addAttribute("carItem",item);
		//将商品存进购物车（登陆的模式，选一个存一个到redis）
		//先取出来判断是否已存在
		String theShopCar = cacheManager.getTheShopCar(goodId);
		if (theShopCar == null) {
			//不存在就直接存
			String itemString = JSON.toJSONString(item);
			cacheManager.putShopCar(itemString,goodId);
		}else{
			//存在时就要重置已存在商品的count
			ShoppingCarItem item1 = JSON.parseObject(theShopCar, ShoppingCarItem.class);
			item1.setCount(item1.getCount()+1);
			//重置完毕后添加
			String itemString1 = JSON.toJSONString(item1);
			cacheManager.putShopCar(itemString1,goodId);
		}
		
		//跳转到添加成功页面
		return "addToCarOk";
	}
	
	/**
	 * 展示购物车的所有数据
	 * @param req
	 * @return
	 */
	@RequestMapping("/showCar")
	public String showCar(HttpServletRequest req){
		//设置购物车和购物项的对象
		ShoppingCar car = new ShoppingCar();
		List<ShoppingCarItem> items = new ArrayList<ShoppingCarItem>();
		//取出redis所有的商品信息
		Map<String, String> map = cacheManager.getAllShopCar();
		//通过遍历这个map将所有的商品设置到购物项集合中
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			String string = map.get(key);
			ShoppingCarItem item = JSON.parseObject(string, ShoppingCarItem.class);
			items.add(item);
		}
		//将购物项集合设置到购物车
		car.setItems(items);
		//设置页面所需对象
		req.setAttribute("shopCar", car);
		//跳转到购物车页面
		return "shopcar";
	}
	
	@RequestMapping("/goToMain")
	public String mian(HttpServletRequest req) throws IOException{
		//从redis中取出广告信息并放入域对象
		String adsAgain = cacheManager.getAd();
		List<AdvertismentDto> ads1 = JSON.parseArray(adsAgain, AdvertismentDto.class);
		req.getSession().setAttribute("ads", ads1);
		/**
		//从redis中取出分类信息并放入域对象
		String firstsAgain = cacheManager.getFirstType();
		List<FirstTypeDto> firsts1 = JSON.parseArray(firstsAgain, FirstTypeDto.class);
		req.getSession().setAttribute("firstTypes", firsts1);
		*/
		//查询一级分类
		List<FirstTypeDto> firstTypes = ftService.findAll();
		req.getSession().setAttribute("goodFirstTypes", firstTypes);
		
		return "index";
	}
	
	@RequestMapping("removeOneCarItem")
	public void deleteItem(Integer goodId,HttpServletResponse resp) throws IOException{
		cacheManager.delete(goodId);
		resp.getWriter().write("removeOK");
	}
}
