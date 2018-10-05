package com.qf.shopping.pojo;

import java.util.List;

public class ShoppingCar {

	private Integer counts;
	
	private Float prices;
	
	private List<ShoppingCarItem> items;

	
	public ShoppingCar() {
	}

	
	
	public ShoppingCar(Integer counts, Float prices, List<ShoppingCarItem> items) {
		this.counts = counts;
		this.prices = prices;
		this.items = items;
	}



	public List<ShoppingCarItem> getItems() {
		return items;
	}


	public void setItems(List<ShoppingCarItem> items) {
		this.items = items;
		
	}

	public Integer getCounts() {
		return counts;
	}



	public void setCounts(Integer counts) {
		this.counts = counts;
	}



	public Float getPrices() {
		return prices;
	}



	public void setPrices(Float prices) {
		this.prices = prices;
	}



	@Override
	public String toString() {
		return "ShoppingCar [counts=" + counts + ", prices=" + prices + ", items=" + items + "]";
	}
	
}
