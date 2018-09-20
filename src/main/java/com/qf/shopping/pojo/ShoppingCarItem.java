package com.qf.shopping.pojo;

import com.qf.shopping.dto.WareDto;

public class ShoppingCarItem {

	private Float money;
	
	private Integer count;
	
	private WareDto good;

	
	public ShoppingCarItem() {
	}

	public ShoppingCarItem(Float money, Integer count, WareDto good) {
		super();
		this.money = money;
		this.count = count;
		this.good = good;
	}



	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public WareDto getGood() {
		return good;
	}

	public void setGood(WareDto good) {
		this.good = good;
	}

	@Override
	public String toString() {
		return "ShoppingCarItem [money=" + money + ", count=" + count + ", good=" + good + "]";
	}
	
	
}
