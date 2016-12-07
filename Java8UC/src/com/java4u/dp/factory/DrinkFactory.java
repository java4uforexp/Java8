/**
 * 
 */
package com.java4u.dp.factory;

import java.util.Iterator;
import java.util.Set;

import org.jboss.errai.reflections.Reflections;

/**
 * @author bbadak
 *
 */
public class DrinkFactory {

	public static Drink getDrink(String type) {

		Drink drink = null;
		try {
			drink = (Drink) Class.forName(type).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return drink;
	}

	public static Drink getDrinkByRef(String type) {
		String packageScan = "com.java4u.dp.factory";
		Reflections reflections = new Reflections(packageScan);
		Set<Class<? extends Drink>> drinkSet = reflections.getSubTypesOf(Drink.class);
		Iterator<Class<? extends Drink>> itr = drinkSet.iterator();
		while (itr.hasNext()) {
			try {
				Drink drink = itr.next().newInstance();
				if (drink.getType().equals(type)) {
					return drink;
				}
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
