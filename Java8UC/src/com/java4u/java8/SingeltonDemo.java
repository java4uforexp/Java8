/**
 * 
 */
package com.java4u.java8;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author bbadak
 *
 */

class SingleTon implements Serializable {

	private static final long serialVersionUID = 1L;
	private static volatile SingleTon singleTon ;

	private SingleTon() {

	}

	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Cloning of this class is not allowed");
	}

	protected Object readResolve() {
		return singleTon;
	}

	public static SingleTon getInstance() {
		if (singleTon == null) {
			synchronized (SingleTon.class) {
				if (singleTon == null) {
					singleTon = new SingleTon();
				}
			}
		}
		return singleTon;
	}
}

public class SingeltonDemo {

		public static void main(String[] args) {

		SingleTon singleton1 = SingleTon.getInstance();
		SingleTon singleton2 = SingleTon.getInstance();
		System.out.println(singleton1 +"---->"+singleton2);
		
		ExecutorService executors = Executors.newCachedThreadPool();
		
		  Map<Integer, Integer> map = new ConcurrentHashMap<>();
       
        for(int i=0;i<1000;i++){
        	executors.submit(new Runnable() {

                     @Override
                     public void run() {
                           
                                   try {
                                          Thread.sleep(10);
                                   } catch (InterruptedException e) {
                                          e.printStackTrace();
                                   }
                                   map.put(SingleTon.getInstance().hashCode(), 1);
                                   //EagerInitializedSingleton.getInstance());
                                   if(map.size() != 1){
                                          System.out.println("error");
                                   }
                          
                     }
               });

        }
       
        executors.shutdown();
        try {
        	executors.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
               e.printStackTrace();
        }
       
		System.out.println(map);
		//reflectionWithSingleton();

	}

		private static void reflectionWithSingleton() {
			try {
				Class<SingleTon> singletonClass = SingleTon.class;
				Constructor<SingleTon> constructor = singletonClass.getDeclaredConstructor();
				constructor.setAccessible(true);
				SingleTon singletonReflection = constructor.newInstance();
				System.out.println(singletonReflection);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
						e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
