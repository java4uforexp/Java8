package com.java4u.java8;

public class SecondLargest {

	public static void print2Largest(int arr[]) {
		int firstLargest = 0;
		int secondLargest = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]> firstLargest){
				if(firstLargest !=0 ){
					secondLargest = firstLargest;
				}
				firstLargest = arr[i];
			}
			else if((secondLargest < arr[i]) && (firstLargest > secondLargest)){
				secondLargest = arr[i];
			}
		}
		System.out.println(firstLargest + " --->" + secondLargest);
	}

	public static void main(String[] args) {
		int arr[] = { 12, 13, 521,10, 114, 1 };
		print2Largest(arr);
	}
}
