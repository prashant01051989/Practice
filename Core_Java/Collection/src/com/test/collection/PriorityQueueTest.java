package com.test.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

class IntegerComparator implements Comparator<Integer>{
	public int compare(Integer one,Integer two){
		return one - two;
	}
}
public class PriorityQueueTest {

	public static void main(String[] args) {
		int[] ia = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
		// use offer() method to add elements to the PriorityQueue pq1
		for (int x : ia) {
			pq1.offer(x);
		}
		System.out.println("pq1: " + pq1);
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10, new IntegerComparator());
		for (int x : ia) {
			pq2.offer(x);
		}
		//pq2.add(null);
		System.out.println("pq2: " + pq2);
		System.out.println("size: " + pq2.size());
		System.out.println("peek: " + pq2.peek());
		System.out.println("pq2: " + pq2);
		System.out.println("size: " + pq2.size());
		System.out.println("poll: " + pq2.poll());
		System.out.println("size: " + pq2.size());
		System.out.println("pq2: " + pq2);
		
		Iterator<Integer>it=pq2.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+"\t");
		}
		
		
		
	}

}
