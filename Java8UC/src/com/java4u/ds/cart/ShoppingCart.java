/**
 * 
 */
package com.java4u.ds.cart;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bbadak
 *
 */
public class ShoppingCart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("sapient");

		Product product1 = new Product();
		product1.setProductId(1);
		product1.setProductName("Oneplus3");
		product1.setPrice(27000f);

		Product product2 = new Product();
		product2.setProductId(2);
		product2.setProductName("Oneplus2");
		product2.setPrice(20000f);

		Product product3 = new Product();
		product3.setProductId(3);
		product3.setProductName("Oneplus1");
		product3.setPrice(15000f);

		Product product4 = new Product();
		product4.setProductId(4);
		product4.setProductName("iphone6");
		product4.setPrice(40000f);

		Product product5 = new Product();
		product5.setProductId(5);
		product5.setProductName("iphone7");
		product5.setPrice(65000f);
		
		Cart cart = new Cart();
		cart.setCartId(1);
		cart.setCustomer(customer);
		Map<Product, Integer> itemQuantityMap = new HashMap<>();
		itemQuantityMap.put(product1, 1);
		itemQuantityMap.put(product2, 2);
		itemQuantityMap.put(product3, 1);
		itemQuantityMap.put(product4, 1);
		
		cart.setItemQuantityMap(itemQuantityMap);
		System.out.println("HI "+customer.getCustomerName()+"... Your cart details as shown below");
		for (Map.Entry<Product, Integer> entry : itemQuantityMap.entrySet()) {
			Integer quantity = entry.getValue();
			Product product = entry.getKey();
		
			System.out.println(product.getProductName() +" "+product.getPrice() +" "+ quantity );
		}
		
		CartService cartService = new CartService();
		Order order = cartService.checkOutCart(cart);
		Notify notify = new Notify();
		notify.notifyViaEmail(order, NotificationType.ORDER_NOTIFY);
		OrderService orderService = new OrderService(order);
		PaymentMode mode = new DebitCardMode();
		orderService.pay(mode);
		notify.notifyViaEmail(order, NotificationType.PAYMENT_NOFITY);

	}

}
