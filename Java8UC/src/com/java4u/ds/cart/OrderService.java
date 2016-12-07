/**
 * 
 */
package com.java4u.ds.cart;

/**
 * @author bbadak
 *
 */
public class OrderService {
	
	Order order;

	public OrderService(Order order) {
		super();
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void pay(PaymentMode paymentMode){
	paymentMode.pay(order);
	}
}
