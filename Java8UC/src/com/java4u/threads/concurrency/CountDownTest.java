/**
 * 
 */
package com.java4u.threads.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Bharath
 *
 */

class CountATMMachine {

	public void withDraw(CountPerson person,CountDownLatch countDownLatch) throws InterruptedException {
		System.out.println(person.getName() + " is entred to atm");
		System.out.println(person.getName() + " is withdrawing");
		Thread.sleep(5000);
		System.out.println(person.getName() + " has come out");
		

	}

}

class CountPerson implements Runnable {
	String name;
	CountDownLatch countDown;
	CountATMMachine atmMachine;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void run() {
		try {
			if(countDown.getCount() == 0){
				countDown.await();
				
			}else{
				countDown.countDown();
				this.atmMachine.withDraw(this,countDown);
				
			}
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public CountDownLatch getCountDown() {
		return countDown;
	}

	public void setCountDown(CountDownLatch countDown) {
		this.countDown = countDown;
	}

	public CountATMMachine getAtmMachine() {
		return atmMachine;
	}

	public void setAtmMachine(CountATMMachine atmMachine) {
		this.atmMachine = atmMachine;
	}

	public CountPerson(String name,CountATMMachine atmMachine, CountDownLatch countDown) {
		super();
		this.name = name;
		this.countDown = countDown;
		this.atmMachine = atmMachine;
	}
}

public class CountDownTest {
	
	public static void main(String args[]){
		
		CountATMMachine atmMachine = new CountATMMachine();
		CountDownLatch countDownLatch   = new CountDownLatch(3);
		CountPerson ram = new CountPerson("Ram", atmMachine, countDownLatch);
		CountPerson lax = new CountPerson("Lax", atmMachine, countDownLatch);
		CountPerson bha = new CountPerson("Bha", atmMachine, countDownLatch);
		CountPerson kri = new CountPerson("Kri", atmMachine, countDownLatch);
		CountPerson bal = new CountPerson("bal", atmMachine, countDownLatch);
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		service.execute(ram);
		service.execute(lax);
		service.execute(bha);
		service.execute(kri);
		service.execute(bal);
		service.shutdown();
	}

}
