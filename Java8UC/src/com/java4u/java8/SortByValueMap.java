/**
 * 
 */
package com.java4u.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author bbadak
 * @param <T>
 *
 */


public class SortByValueMap {

	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
				return (e1.getValue()).compareTo(e2.getValue());
			}
		});
	 
		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
	 
		return result;
	}
	public static void main(String[] args) {
				
		  Map<String, Integer> map = new HashMap<String, Integer>();
	        map.put("one", 20);
	        map.put("two", 20);
	        map.put("three", 45);
	        map.put("four", 2);
	        map.put("five", 67);
	        map.put("six", 26);
	        map.put("seven", 43);
	        Map<String, Integer> result = sortByValue(map);
	        System.out.println(result);
	    }
	
	}

