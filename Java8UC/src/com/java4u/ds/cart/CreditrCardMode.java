/**
 * 
 */
package com.java4u.ds.cart;

/**
 * @author bbadak
 *
 */
public class CreditrCardMode implements PaymentMode {

	@Override
	public void pay(Order order){
		System.out.println("Credit Payment of "+order.getTotalAmount()+"recived from the "+order.getCustomer().getCustomerName());
	}

	

}
