/**
 * 
 */
package com.java4u.java8;

import java.io.Serializable;

/**
 * @author bbadak
 *
 */
public class Employee implements Cloneable,Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private Student s;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student getS() {
		return s;
	}

	public void setS(Student s) {
		this.s = s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee(String name) {
		super();
		this.name = name;
	}
	
	public Employee clone() throws CloneNotSupportedException{
		return (Employee)super.clone();
	}
}
