/**
 * 
 */
package com.java4u.ds.linkedlist;

/**
 * @author Bharath
 *
 */
public class MergeSortDemo {

//static int[] ar = { 54, 13, 24, 19, 11, 3, 71, 8 };
static int[] ar = { 3,2,1,4,9 };
    public static void display(int[] array){
    	System.out.println();
    	for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+"---->");
			
		}
    	System.out.println();
    }
public static void mergeSort(int[] array,int length){
	
	if(length==1){
		return;
	}
	else{
		//display(array);
		int mid = (length)/2;
		int left[] = new int[mid];
		int right[] = new int[length-mid];
		
		for(int i=0;i<mid;i++){
			left[i] = array[i];
		}
		//System.out.println(length);
		for(int i=mid;i<length;i++){
			right[i-mid] = array[i];
		}
		
		mergeSort(left,mid);
		mergeSort(right,length-mid);
		merge(left,right,array);
		// merging(ar, start, mid + 1, end);//merging 
	}
}
    private static void merge(int[] left, int[] right, int[] ar2) {
	int i=0,k=0,j=0;
	while(i<left.length && j<right.length){
		if(left[i] <=right[j]){
			ar2[k++] = left[i++];
		}
		else{
			ar2[k++] = right[j++];
		}
	}
	while(i<left.length ){
		ar2[k++] = left[i++];
	}
	while(j<right.length){
		ar2[k++] = right[j++];
	}
	display(ar2);
}
	/**
     * Main method which calls merge sort in java
     * @param args
     */
    public static void main(String[] args) {
           
           System.out.print("Display array before Merge sorting: "  );
           for (int i = 0; i < ar.length; i++)
                  System.out.print(ar[i] +" ");
           System.out.println();
           
           mergeSort(ar,ar.length);
           
           System.out.print("\nDisplay array after Merge sort: "  );
           for (int i = 0; i < ar.length; i++)
                  System.out.print(ar[i] +" ");
            
    }
}
