/**
 * 
 */
package com.java4u.threads.concurrency;

import java.util.concurrent.Semaphore;

/**
 * @author Bharath
 *
 */

/**
 * 
 * 
 * Ram is entred to atm Ram is withdrwaing bal is entred to atm Kri is entred to
 * atm Bha is entred to atm Lax is entred to atm Bha is withdrwaing Kri is
 * withdrwaing bal is withdrwaing Lax is withdrwaing bal has come out Ram has
 * come out Lax has come out Bha has come out Kri has come out
 *
 */

class ATMMachine {

	public void withDraw(SemaphorePerson person) throws InterruptedException {

		System.out.println(person.getName() + " is entred to atm");
		System.out.println(person.getName() + " is withdrawing");
		Thread.sleep(1000);
		System.out.println(person.getName() + " has come out");

	}

}

class SemaphorePerson implements Runnable {
	String name;
	Semaphore semaphore;
	ATMMachine atm;

	public SemaphorePerson(String name, ATMMachine atmMachine, Semaphore sem) {
		super();
		this.name = name;
		this.atm = atmMachine;
		this.semaphore = sem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void run() {
		try {
			semaphore.acquire();
			atm.withDraw(this);
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class SemaphoreTest {

	public static void test() {
		Semaphore sem = new Semaphore(0);
		ATMMachine machine = new ATMMachine();
		SemaphorePerson ram = new SemaphorePerson("Ram", machine, sem);
		SemaphorePerson lax = new SemaphorePerson("Lax", machine, sem);
		SemaphorePerson bha = new SemaphorePerson("Bha", machine, sem);
		SemaphorePerson kri = new SemaphorePerson("Kri", machine, sem);
		SemaphorePerson bal = new SemaphorePerson("bal", machine, sem);

		Thread ramT = new Thread(ram);
		Thread laxT = new Thread(lax);
		Thread bhaT = new Thread(bha);
		Thread kriT = new Thread(kri);
		Thread balT = new Thread(bal);
		ramT.start();
		laxT.start();
		bhaT.start();
		kriT.start();
		balT.start();
	}

}

public class SyncTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}