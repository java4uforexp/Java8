/**
 * 
 */
package com.java4u.ds.cart;

import java.util.Map;

/**
 * @author bbadak
 *
 */
public class CartService {

	public Cart createCart(Cart cart){
		
		return null;
	}
	
	public Cart updateCart(Cart cart){
		
		return null;
	}
		
	public Order checkOutCart(Cart cart){
		
		Order order = new Order();
		order.setOrderId(1);
		order.setCustomer(cart.getCustomer());
		order.setItemQuantityMap(cart.getItemQuantityMap());
		order.setTotalAmount(getTotalAmount(cart.getItemQuantityMap()));
		return order;
 	}

	private Float getTotalAmount(Map<Product, Integer> itemQuantityMap) {
		
		Float totalSum=0.0f;
		for (Map.Entry<Product, Integer> entry : itemQuantityMap.entrySet()) {
			Integer quantity = entry.getValue();
			Float price = entry.getKey().getPrice();
			
			totalSum = totalSum +(quantity*price);
			
		}
		return totalSum;
	}
	
}
