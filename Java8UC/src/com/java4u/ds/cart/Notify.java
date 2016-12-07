/**
 * 
 */
package com.java4u.ds.cart;

/**
 * @author bbadak
 *
 */


public class Notify {

	public void notifyViaEmail(Order order,NotificationType notificationType){
		
		
		System.out.println(order.getCustomer().getCustomerName()+" has been notifiefd using mail");
	}
	public void notifyViaMobile(Order order,NotificationType notificationType){
		
		
		System.out.println(order.getCustomer().getCustomerName()+" has been notifiefd mobile");
	}
}
