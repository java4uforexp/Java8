/**
 * 
 */
package com.java4u.dp.factory;

/**
 * @author bbadak
 *
 */
public class FactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Object
		//Drink drink = DrinkFactory.getDrink("com.java4u.dp.factory.Coke");
		Drink drink = DrinkFactory.getDrinkByRef("pepsi");
		System.out.println(drink.getType());
	}

}
