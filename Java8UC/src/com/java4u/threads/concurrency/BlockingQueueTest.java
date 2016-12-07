/**
 * 
 */
package com.java4u.threads.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

/**
 * @author Bharath
 * 
 */
class BlockingQueuee<T> {
	T array[];
	Integer MAX;
	Integer pointer = 0;
	Lock lock = new ReentrantLock();
	Condition addCondition = lock.newCondition();
	Condition removeCondition = lock.newCondition();
	Logger logger = Logger.getLogger(this.getClass());
	public BlockingQueuee(T[] array, Integer max) {
		super();
		this.array = array;
		this.MAX = max;

	}

	public void add(T element) {
		try {
			lock.lock();
			if (pointer == MAX) {
				addCondition.await();
				System.out.println("Add got blocked ---->" + pointer);
			}
			array[pointer++] = element;
			//display();
			removeCondition.signalAll();
			logger.debug("added element--->" + element +" final array---->"+array.length);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

	/*public void display() {
		for (T arrayDis : array) {
			System.out.println(arrayDis);
		}
	}*/

	public T remove() {
		T element = null;
		try {
			lock.lock();
			if (pointer == 0) {
				removeCondition.await();
				System.out.println("Remove got blocked ---->" + pointer);
			} else {
				element = array[--pointer];
				addCondition.signalAll();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		logger.debug("Removed element--->" + element+" final array---->"+array.length);
		return element;

	}
}

class Consumer<T> implements Callable<T> {
	public Consumer(BlockingQueuee<T> blockingQueue) {
		super();
		this.blockingQueue = blockingQueue;
	}

	private BlockingQueuee<T> blockingQueue;

	public T call() throws Exception {
		T element = null;
		
		while(true){
			element = blockingQueue.remove();
			
		}
		//return null;
	}

	

}

class Producer<T> implements Callable<T> {

	private BlockingQueuee<T> blockingQueue;
	
	private T[] store;
	
	public Producer(BlockingQueuee<T> blockingQueue, T[] store) {
		super();
		this.blockingQueue = blockingQueue;
		this.store = store;
	}



	public void add(T element) {
		blockingQueue.add(element);
	}

	
	public T call() {
		
		for (T t : store) {
			blockingQueue.add(t);
			
		}
		return null;
	}

}

public class BlockingQueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Integer max = 10;
		String arr[] = new String[max];
		String integer[] = new String[max];
		integer[0] = "1";
		integer[1] = "2";
		integer[2] = "3";
		integer[3] = "4";
		integer[4] = "5";
		integer[5] = "6";
		integer[6] = "7";
		integer[7] = "8";
		integer[8] = "9";
		integer[9] = "10";
		
		final BlockingQueuee<String> blockingQueue = new BlockingQueuee<String>(arr, max);
		Producer<String> producer = new Producer<String>(blockingQueue , integer);
		
		Consumer<String> consumer = new Consumer<String>(blockingQueue);
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(consumer);
		service.submit(producer);
		if (!service.isTerminated()) {
			service.shutdown();
		}
		/*new Thread(){
			public void run(){
				System.out.println("Remove thread");
				while(true){
					blockingQueue.remove();
				}
			}
		}.start();
		
		new Thread(){
			public void run(){
				System.out.println("add thread");
				blockingQueue.add("1");
				blockingQueue.add("2");
				blockingQueue.add("3");
				blockingQueue.add("4");
				blockingQueue.add("5");
				blockingQueue.add("6");
				blockingQueue.add("7");
				blockingQueue.add("8");
				blockingQueue.add("9");
				blockingQueue.add("10");
				
			}
		}.start();
*/
	}

}
