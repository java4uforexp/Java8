/**
 * 
 */
package com.java4u.threads.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.log4j.Logger;

/**
 * @author Bharath
 *
 */

/** Read functionality */

class Task1 implements Runnable {

	Logger log = Logger.getLogger(this.getClass());

	List<String> sharedResource;

	ReadWriteLock lock;

	/**
	 * @param lock
	 */
	public Task1(ReadWriteLock lock, List<String> sharedResource) {
		super();
		this.lock = lock;
		this.sharedResource = sharedResource;
	}

	public void run() {

		if (lock.readLock().tryLock()) {
			lock.readLock().lock();
			log.info(Thread.currentThread().getName() + " acquired read lock");
			for (String string : sharedResource) {
				log.info(string);
			}
			log.info(Thread.currentThread().getName() + " released read lock");
			lock.readLock().unlock();
		} else {
			log.info(Thread.currentThread().getName() + "did not get lock to read");
		}

	}

}

/** Write functionality */
class Task2 implements Runnable {

	Logger log = Logger.getLogger(this.getClass());

	List<String> sharedResource;

	ReadWriteLock lock;

	/**
	 * @param lock
	 */
	public Task2(ReadWriteLock lock, List<String> sharedResource) {
		super();
		this.lock = lock;
		this.sharedResource = sharedResource;

	}

	public void run() {

		if (lock.writeLock().tryLock()) {
			lock.writeLock().lock();
			log.info(Thread.currentThread().getName() + " acquired write lock");
			sharedResource.add("Adddddd");
			log.info(Thread.currentThread().getName() + " released write lock");
			lock.writeLock().unlock();
		} else {
			log.info(Thread.currentThread().getName() + " did not get lock to write");
		}

	}

}

public class ReEntarentReadWriteLockDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> sharedResource = new ArrayList<String>();
		sharedResource.add("1");
		sharedResource.add("2");
		
		ReadWriteLock lock = new ReentrantReadWriteLock();

		Task1 readTask = new Task1(lock, sharedResource);
		Task2 writeTask = new Task2(lock, sharedResource);

		ExecutorService service = Executors.newFixedThreadPool(3);
		service.execute(readTask);
		service.execute(writeTask);
		service.execute(readTask);
		service.shutdown();
		
	}

}
