package com.collection.set.test;

import java.util.LinkedList;

public class LinkedListTest {

	
	public static void main(String[] args) {
		LinkedList<String>l1=new LinkedList<String>();
		System.out.println(l1.size());
		System.out.println(l1.isEmpty());
		System.out.println(l1);
		System.out.println(l1.add("list"));
		l1.add("list");
		l1.add(null);
		l1.add(null);
		l1.add("A");
		l1.add("B");
		l1.add("C");
		l1.add(5,"D");
		System.out.println(l1.size());
		System.out.println(l1.isEmpty());
		System.out.println(l1);
		l1.addAll(l1);
		System.out.println(l1);
		l1.addAll(7,l1);
		System.out.println(l1);
		System.out.println(l1.contains("a"));
		System.out.println(l1.contains("A"));
		System.out.println(l1.containsAll(l1));
		l1.addFirst("Prashant");
		l1.addLast("Anshu");
		System.out.println(l1);
		System.out.println(l1.remove("Anshu"));
		System.out.println(l1.remove("Kumar"));
		System.out.println(l1);
		System.out.println(l1.remove(0));
		System.out.println(l1.removeFirst());
		System.out.println(l1.removeLast());
		System.out.println(l1);
		System.out.println(l1.removeFirstOccurrence("A"));
		System.out.println(l1.removeLastOccurrence("C"));
		System.out.println(l1);
		System.out.println(l1.get(1));
		System.out.println(l1.getFirst());
		System.out.println(l1.getLast());
		LinkedList<String> l2=new LinkedList<String>();
		l2.add("1");
		l2.add("2");
		l2.add("3");
		l2.add("4");
		l2.add("5");
		l1.addAll(l2);
		System.out.println(l1.retainAll(l2));
		System.out.println(l1);
		System.out.println(l1.indexOf("1"));
		System.out.println(l1.indexOf("11"));
		System.out.println(l1.lastIndexOf("2"));
		System.out.println(l1.set(1, "15"));
		System.out.println(l1);
		System.out.println(l1.poll());
		System.out.println(l1);
		System.out.println(l1.peek());
		System.out.println(l1);
		System.out.println(l1.remove());
		System.out.println(l1);
		LinkedList<String>l3=new LinkedList<String>();
		//System.out.println(l3.remove());
		System.out.println(l1.offer("Kumar"));
		System.out.println(l1);
		//Enumeration<String>enum1=(Enumeration<String>) l1.iterator();
			
		

	}

}
