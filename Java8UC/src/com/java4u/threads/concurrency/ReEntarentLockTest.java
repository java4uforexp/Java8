package com.java4u.threads.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class RunnableCounter implements Runnable{
	Lock lock ;
	/**
	 * @param lock
	 */
	public RunnableCounter(Lock lock) {
		super();
		this.lock = lock;
	}

	public void run() {
		for (int i = 0; i < 3; i++) {

			// System.out.println(lock.tryLock());
			if (lock.tryLock()) {

				try {
					lock.lock();

					System.out.println(Thread.currentThread().getName() + " printing " + i);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {

					lock.unlock();
				}
			} else {
				System.out.println("Lock did nt get for the thread " + Thread.currentThread().getName());
			}

		}
	}
}
public class ReEntarentLockTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(3);
		Lock lock =  new ReentrantLock();
		service.execute(new RunnableCounter(lock));
		service.execute(new RunnableCounter(lock));
		service.execute(new RunnableCounter(lock));
	//	service.execute(new RunnableCounter());
		service.shutdown();
		System.out.println("I am done");
		

	}

}
