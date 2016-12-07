/**
 * 
 */
package com.java4u.java8;

/**
 * @author bbadak
 *
 */
public class EmployeeClone {

	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Employee  emp1 = new Employee("A");
		Employee emp2 = (Employee)emp1.clone();
		System.out.println(emp2.getName());
	}

}
