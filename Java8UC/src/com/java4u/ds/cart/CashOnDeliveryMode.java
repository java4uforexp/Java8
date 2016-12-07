/**
 * 
 */
package com.java4u.ds.cart;

/**
 * @author bbadak
 *
 */
public class CashOnDeliveryMode implements PaymentMode {

	/* (non-Javadoc)
	 * @see com.java4u.ds.cart.PaymentMode#pay(com.java4u.ds.cart.Order)
	 */
	@Override
	public void pay(Order order){
		System.out.println("Cash on Delivery Payment of "+order.getTotalAmount()+"recived from the "+order.getCustomer().getCustomerName());
	}

}
