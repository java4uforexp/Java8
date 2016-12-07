package com.java4u.ds.cart;

import java.util.List;
import java.util.Map;

public class Order {

	private Integer orderId;
	
	Map<Product,Integer>  itemQuantityMap;
	
	private Float totalAmount;
	
	private Customer customer;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	

	public Map<Product, Integer> getItemQuantityMap() {
		return itemQuantityMap;
	}

	public void setItemQuantityMap(Map<Product, Integer> itemQuantityMap) {
		this.itemQuantityMap = itemQuantityMap;
	}

	public Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
