package com.java4u.ds.cart;

import java.util.List;
import java.util.Map;

public class Cart {

	private Integer cartId;
	
	Map<Product,Integer>  itemQuantityMap;
	
	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Map<Product, Integer> getItemQuantityMap() {
		return itemQuantityMap;
	}

	public void setItemQuantityMap(Map<Product, Integer> itemQuantityMap) {
		this.itemQuantityMap = itemQuantityMap;
	}

	
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
