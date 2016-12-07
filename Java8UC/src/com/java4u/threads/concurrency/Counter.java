/**
 * 
 */
package com.java4u.threads.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Bharath
 * 
 */
class Incrementer {
	private int count;
	
	public void increment() {
		int arr[]= {1,2};
		arr[2]=3/0;
		count++; // it's a trap!
		// a single "line" is not atomic
	}

	public int getValue() {
		return count;
	}
}

class AtomicIncrementer {
	private AtomicInteger count = new AtomicInteger();

	public void increment() {
		count.getAndIncrement(); // it's a trap!
		// a single "line" is not atomic
	}

	public int getValue() {
		return count.intValue();
	}
}

class IncrementerThread extends Thread {
	private Incrementer incrementer;

	// all instances are passed the same counter
	public IncrementerThread(Incrementer counter) {
		this.incrementer = counter;
	}

	public void run() {
		// "i" is local and thread-safe
		for (int i = 0; i < 10000; i++) {
			incrementer.increment();
		}

	}

}
class AtomicIncrementerThread extends Thread {
	private AtomicIncrementer incrementer;

	// all instances are passed the same counter
	public AtomicIncrementerThread(AtomicIncrementer counter) {
		this.incrementer = counter;
	}

	public void run() {
		// "i" is local and thread-safe
		for (int i = 0; i < 10000; i++) {
			incrementer.increment();
		}

	}

}

class Counter{
	public static void main(String args[]) throws Exception{
		AtomicIncrementer incrementer = new AtomicIncrementer(); // the shared object
		AtomicIncrementerThread it1 = new AtomicIncrementerThread(incrementer);
		AtomicIncrementerThread it2 = new AtomicIncrementerThread(incrementer);
		it1.start(); // thread 1 increments the count by 10000
		it2.start(); // thread 2 increments the count by 10000
		it1.join();
		it2.join();
		System.out.println(incrementer.getValue()); 
	}
}