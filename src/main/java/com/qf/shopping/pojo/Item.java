package com.qf.shopping.pojo;

public class Item {

	int value;
	String name;
	
	
	public Item() {
	}
	
	public Item(int value, String name) {
		super();
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Item [value=" + value + ", name=" + name + "]";
	}
	
}
