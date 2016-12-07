/**
 * 
 */
package com.java4u.java8;

/**
 * @author bbadak
 *
 */
public class SwapString {

	StringBuffer s1;
	StringBuffer s2;
	
	static void   swap(StringBuffer s1, StringBuffer s2){
		StringBuffer temp = null;
		temp = s1;
		s1=s2;
		s2 = temp;
		System.out.println(s1 +" "+s2 );
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer s1 = new StringBuffer("a");
		StringBuffer s2 =new StringBuffer("b");
System.out.println(s1 +" "+s2 );
swap(s1,s2);
System.out.println(s1+" "+s2);
	}

}
