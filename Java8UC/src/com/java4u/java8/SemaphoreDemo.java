/**
 * 
 */
package com.java4u.java8;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author bbadak
 *
 */
class SharedObject{
	Integer i;

	public SharedObject(Integer i) {
		super();
		this.i = i;
	}
	
}
class ProducerSemaphore implements Runnable{

	private Semaphore semaphoreProducer;
	private Semaphore semaphoreConsumer;	
	private SharedObject obj;
	

	public ProducerSemaphore(Semaphore semaphoreProducer, Semaphore semaphoreConsumer, SharedObject obj) {
		super();
		this.semaphoreProducer = semaphoreProducer;
		this.semaphoreConsumer = semaphoreConsumer;
		this.obj = obj;
	}



	@Override
	public void run() {
		
	}
	
}


class ConsumerSemaphore implements Runnable{

	private Semaphore semaphoreProducer;
	private Semaphore semaphoreConsumer;
	private SharedObject obj;
	
	public ConsumerSemaphore(Semaphore semaphoreProducer, Semaphore semaphoreConsumer,SharedObject obj) {
		super();
		this.semaphoreProducer = semaphoreProducer;
		this.semaphoreConsumer = semaphoreConsumer;
		this.obj = obj;
	}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}




public class SemaphoreDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	SharedObject obj = new SharedObject(5);
	Semaphore semaphoreProducer = new Semaphore(1);
	Semaphore semaphoreConsumer = new Semaphore(0);
	ProducerSemaphore producerSemaphore = new ProducerSemaphore(semaphoreProducer,semaphoreConsumer,obj);
	ConsumerSemaphore consumerSemaphore = new ConsumerSemaphore(semaphoreProducer,semaphoreConsumer,obj);
	
	new Thread(producerSemaphore).start();
	new Thread(consumerSemaphore).start();
	
	}

}
