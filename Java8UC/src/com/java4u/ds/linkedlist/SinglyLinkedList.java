/**
 * 
 */
package com.java4u.ds.linkedlist;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Bharath
 *
 */

/**
 * Node class, which holds data and contains next which points to next Node.
 */
class Node<T> {
	public T data; // data in Node.
	public Node<T> next; // points to next Node in list.

	/**
	 * Constructor
	 */
	public Node(T data) {
		this.data = data;
	}

	/**
	 * Display Node's data
	 */
	public void displayNode() {
		System.out.print(data + " ");
	}
}

class LinkedList<T> {

	private Node<T> head;

	public LinkedList() {
		head = null;
	}
ConcurrentHashMap<K, V>
	public  void insertFirst(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	public void insertLast(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> current = head;
			while (current.next != null) {
			   current = current.next;
			}
		   current.next=newNode;
	}

	}
	
	public  void displayList(){
		Node<T> current = head;
		while(current != null){
			System.out.print(current.data+"--->");
			current = current.next;
		}
	}
	public  void reverse(){
		Node<T> before = null;
		Node<T>  current = head, after = head;
		while(current != null){
			after = after.next;
			current.next = before;
			before = current;
			current = after;
		}
		head = before;
	}
	
	
}


public class SinglyLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("in prog");
		 LinkedList<String> linkedList = new LinkedList<String>();
         
         linkedList.insertLast("4");
         linkedList.insertLast("3");
         linkedList.insertLast("2");
         linkedList.insertLast("1");
         System.out.println("Displaying");
         linkedList.displayList();
         System.out.println("Reversing");
         linkedList.reverse();
         linkedList.displayList();
         

	}

}
