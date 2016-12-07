/**
 * 
 */
package com.java4u.java8;

/**
 * @author bbadak
 *
 */
class A {
	
	protected int i = 10;
	

	A() {
		//i = 10;
	}
}

class B extends A {
	protected int i = 20;
	B() {
		//i = 20;
	}
}

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Class classA = A.class;
		A a = new B();
		System.out.println(a.i);
	}

}
