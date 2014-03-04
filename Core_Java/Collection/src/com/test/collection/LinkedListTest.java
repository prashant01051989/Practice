package com.test.collection;

import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

class LinkedList_A {
	int id;
	String name;
	boolean bol;

	public LinkedList_A() {
		super();
	}

	public LinkedList_A(int id, String name, boolean bol) {
		super();
		this.id = id;
		this.name = name;
		this.bol = bol;
	}

	public boolean equals(Object obj) {
		System.out.println("List A equals..............");
		if (this == obj)
			return true;
		if (!(obj instanceof LinkedList_A))
			return false;
		LinkedList_A la = (LinkedList_A) obj;
		return this.id == la.id && this.name.equals(la.name)
				&& this.bol == la.bol;

	}

	public String toString() {
		return id + " " + name + " " + bol;
	}
}

public class LinkedListTest {

	public static void main(String[] args) {
		Boolean[] bol = new Boolean[6];
		
		/*
		Queue<String>q1=new LinkedList<String>();
		bol[0]=q1.add("A");
		System.out.println("bol[0] :"+bol[0]);
		bol[0]=q1.offer("B");
		System.out.println("bol[0] :"+bol[0]);
		
		bol[0]=q1.add("C");
		bol[0]=q1.add("D");
		bol[0]=q1.add("E");
		bol[0]=q1.add("F");
		bol[0]=q1.add("G");
		
		System.out.println("q1 :"+q1);
		Queue<String>q2=new LinkedList<String>();
		System.out.println("q1 :"+q1);
		System.out.println("q1.remove() :"+q1.remove());
		//System.out.println("q2.remove() :"+q2.remove());
		System.out.println("q1 :"+q1);
		System.out.println("q1.poll() :"+q1.poll());
		System.out.println("q2.poll() :"+q2.poll());
		System.out.println("q1 :"+q1);
		System.out.println("q1.element() :"+q1.element());
		//System.out.println("q2.element() :"+q2.element());
		System.out.println("q1.peek() :"+q1.peek());
		System.out.println("q2.peek() :"+q2.peek());
		*/
		
		Deque<String>dq1=new LinkedList<String>();
		bol[0]=dq1.add("C");
		bol[0]=dq1.add("D");
		bol[0]=dq1.add("E");
		bol[0]=dq1.add("F");
		bol[0]=dq1.add("G");
		System.out.println("dq1 :"+dq1);
		dq1.addFirst("B");
		System.out.println("dq1 :"+dq1);
		dq1.addLast("H");
		System.out.println("dq1 :"+dq1);
		dq1.offerFirst("A");
		System.out.println("dq1 :"+dq1);
		dq1.offerLast("I");
		System.out.println("dq1 :"+dq1);
		Deque<String>dq2=new LinkedList<String>();
		
		
		System.out.println("dq1.removeFirst() :"+dq1.removeFirst());
		//System.out.println("dq2.removeFirst() :"+dq2.removeFirst());
		System.out.println("dq1 :"+dq1);
		
		System.out.println("dq1.removeLast() :"+dq1.removeLast());
		//System.out.println("dq2.removeLast() :"+dq2.removeLast());
		System.out.println("dq1 :"+dq1);
		
		
		System.out.println("dq1.pollFirst() :"+dq1.pollFirst());
		System.out.println("dq2.pollFirst() :"+dq2.pollFirst());
		System.out.println("dq1 :"+dq1);
		
		
		System.out.println("dq1.pollLast() :"+dq1.pollLast());
		System.out.println("dq2.pollLast() :"+dq2.pollLast());
		System.out.println("dq1 :"+dq1);
		
		System.out.println("dq1.getFirst() :"+dq1.getFirst());
		//System.out.println("dq2.getFirst() :"+dq2.getFirst());
		System.out.println("dq1 :"+dq1);
		
		System.out.println("dq1.getLast() :"+dq1.getLast());
		//System.out.println("dq2.getLast() :"+dq2.getLast());
		System.out.println("dq1 :"+dq1);
		
		
		System.out.println("dq1.peekFirst() :"+dq1.peekFirst());
		System.out.println("dq2.peekFirst() :"+dq2.peekFirst());
		System.out.println("dq1 :"+dq1);
		
		System.out.println("dq1.peekLast() :"+dq1.peekLast());
		System.out.println("dq2.peekLast() :"+dq2.peekLast());
		System.out.println("dq1 :"+dq1);
		
		
		
		
		
		

		
	}

}
