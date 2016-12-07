/**
 * 
 */
package com.java4u.threads.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

import org.apache.log4j.Logger;

import com.java4u.ds.linkedlist.MergeSortDemo;


/**
 * @author Bharath
 *
 */
class MergeTask extends RecursiveAction{

	int start;
	int end;
	int sharedArray[];
	int THREASH_HOLD = 10;
	
	/**
	 * @param sharedArray
	 */
	public MergeTask(int[] sharedArray) {
		
		this(0,sharedArray.length,sharedArray);
	}

	/**
	 * @param start
	 * @param end
	 * @param sharedArray
	 */
	public MergeTask(int start, int end, int[] sharedArray) {
		super();
		this.start = start;
		this.end = end;
		this.sharedArray = sharedArray;
	}

	
	
	@Override
	protected void compute() {
		
			if((end-start)<=THREASH_HOLD){
				int[] temp = new int[end-start];
				for(int i=start,k=0;i<end;i++){
					temp[k++] = sharedArray[i];
				}
				MergeSortDemo.mergeSort(temp, temp.length);
				
			}
			else{
				int split = (end+start)/2;
				MergeTask lTask = new MergeTask(start, split, sharedArray);
				MergeTask rTask = new MergeTask(split, end, sharedArray);
				invokeAll(lTask,rTask);
			}
		}
		
	
	
}

class Multask extends RecursiveAction{

	int start;
	int end;
	Integer sharedArray[];
	int THREASH_HOLD = 10;
	
	/**
	 * @param sharedArray
	 */
	public Multask(Integer[] sharedArray) {
		this(0,sharedArray.length,sharedArray);
	}

	public Multask(int start, int end, Integer[] sharedArray) {
		super();
		this.start = start;
		this.end = end;
		this.sharedArray = sharedArray;
	}

	@Override
	protected void compute() {
		if((end-start)<=THREASH_HOLD){
			for(int i=start ;i<end;i++){
				sharedArray[i] = i*i*i;
			}
		}
		else{
			int split = (end+start)/2;
			Multask lTask = new Multask(start, split, sharedArray);
			Multask rTask = new Multask(split, end, sharedArray);
			lTask.fork();
			rTask.fork();
			lTask.join();
			rTask.join();
			
		}
		
	}
	
}





class sumTask extends RecursiveTask<Integer>{

	int start;
	int end;
	Integer sharedArray[];
	int THREASH_HOLD = 10;
	
	public sumTask(int start, int end, Integer[] sharedArray) {
		super();
		this.start = start;
		this.end = end;
		this.sharedArray = sharedArray;
	}

	public sumTask(Integer[] sharedArray) {
		this(0,sharedArray.length,sharedArray);
	}

	@Override
	protected Integer compute() {
		if((end-start)<= THREASH_HOLD){
			int sum = 0;
			for(int i= start;i<end;i++){
				sum+=i;
			}
			return sum;
		}
		else{
			int split = (start+end)/2;
			sumTask lTask = new sumTask(start, split, sharedArray);
			sumTask rTask = new sumTask(split, end, sharedArray);
			lTask.fork();
			rTask.fork();
			return (lTask.join()+rTask.join());
				
		}
		
	}
	
}

class MinTask extends RecursiveTask<Integer> {
	int start;
	int end;
	Integer sharedArray[];
	int THREASH_HOLD = 10;
	

	public MinTask(Integer[] sharedArray) {
		this(0,sharedArray.length,sharedArray);
	}


	public MinTask(int start, int end, Integer[] sharedArray) {
		super();
		this.start = start;
		this.end = end;
		this.sharedArray = sharedArray;
	}


	@Override
	protected Integer compute() {
		int position = end - start;
		if (position <= THREASH_HOLD) {
			int min = sharedArray[start];
			for (int i = start; i < end; i++) {
				if (sharedArray[i] < min) {
					min = sharedArray[i];
				}
			}
			return min;
		}
		else{
			int split = (start+end)/2;
			MinTask lTask = new MinTask(start, split, sharedArray);
			MinTask rTask = new MinTask(split, end, sharedArray);
			lTask.fork();
			rTask.fork();
			return Math.min(lTask.join(), rTask.join());
		}
	}

}


class MaxTask extends RecursiveTask<Integer>{
int start;
int end;
Integer sharedArray[];
int THREASH_HOLD = 10;
	
	@Override
	protected Integer compute() {
		int position = end - start;
		if(position <= THREASH_HOLD ){
			int max = sharedArray[start];
			for (int i= start ; i<end ;i++) {
				if(max < sharedArray[i]){;
					max = sharedArray[i];
				}
			}
			return max;
		}
		else{
			int split = (start+end)/2;
			MaxTask lTask = new MaxTask(start,split, sharedArray);
			MaxTask rTask = new MaxTask(split, end, sharedArray);
			lTask.fork();
			rTask.fork();
			return Math.max(lTask.join(), rTask.join());
			
		}
		
	}

	public MaxTask(Integer[] sharedArray) {
		this(0,sharedArray.length,sharedArray);
		 
	}

	public MaxTask(int start, int end, Integer[] sharedArray) {
		super();
		this.start = start;
		this.end = end;
		this.sharedArray = sharedArray;
	}
	
}



public class ForkJoinDemo {

	/**
	 * @param args
	 */
	public static void display(Integer[] arrayInt){
		for(int i=0; i< arrayInt.length ; i++){
			
			System.out.print(arrayInt[i] +">>>");
		}
	}
	public static void display(int[] arrayInt){
		for(int i=0; i< arrayInt.length ; i++){
			
			System.out.print(arrayInt[i] +">>>");
		}
	}
	public static void main(String[] args) {
		int[] arrayInt = new int[100];
		for (int i = arrayInt.length,k=0; i > 1; i--) {
			arrayInt[k++]= i;
		}

		Logger log = Logger.getLogger(ForkJoinDemo.class);
		log.info("Parallelism---->"+Runtime.getRuntime().availableProcessors());
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		
		long before = System.nanoTime();
		//Integer maxVal = pool.invoke(new MaxTask(arrayInt));
		//Integer minVal = pool.invoke(new MinTask(arrayInt));
		//Integer sum = pool.invoke(new sumTask(arrayInt));
		//pool.invoke(new Multask(arrayInt));
		pool.invoke(new MergeTask(arrayInt));
		long after = System.nanoTime();
		long timeTaken = after-before;
		
		log.info("Time taken to execute---->"+timeTaken);
		display(arrayInt);
		//log.info("Max Value---->"+sum);
	}

}
