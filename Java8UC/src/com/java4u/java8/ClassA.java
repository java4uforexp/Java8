/**
 * 
 */
package com.java4u.java8;

/**
 * @author bbadak
 *
 */
public class ClassA {
	static{
		throwException(null);
	}
	
	public static void throwException(String val) {
		int length = val.length();
		System.out.println(val+" length is "+length);
		
	}
	
	public void getConnection(){
		System.out.println("Connection done");
	}
}
