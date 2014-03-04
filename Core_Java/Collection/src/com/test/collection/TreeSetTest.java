package com.test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class TreeSet_A implements Comparable<TreeSet_A> {
	int id;
	String name;
	boolean bol;

	public TreeSet_A() {
		super();
	}

	public TreeSet_A(int id, String name, boolean bol) {
		super();
		this.id = id;
		this.name = name;
		this.bol = bol;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("************Equals*************");
		if (this == obj)
			return true;
		if (!(obj instanceof TreeSet_A))
			return false;
		TreeSet_A la = (TreeSet_A) obj;
		return this.id == la.id && this.name.equals(la.name)
				&& this.bol == la.bol;
	}

	@Override
	public int hashCode() {
		
		return this.id;
	}

	@Override
	public int compareTo(TreeSet_A obj) {
		
		return this.id - obj.id;
	}

	public String toString() {
		return id + " " + name + " " + bol;
	}

}

class SortByName implements Comparator<TreeSet_A> {
	public int compare(TreeSet_A obj1, TreeSet_A obj2) {
		
		return obj1.name.compareTo(obj2.name);
	}

}

public class TreeSetTest {

	public static void main(String[] args) {
		boolean[] bol = new boolean[6];
		
		TreeSet_A col1 = new TreeSet_A(10, "Prashant", true);
		TreeSet_A col2 = new TreeSet_A(20, "Anshu", false);
		TreeSet_A col3 = new TreeSet_A(30, "Infinite", true);
		
		
		
		/*SortedSet<String> ss2 = new TreeSet<String>();
		SortedSet<String> ss1 = new TreeSet<String>(Arrays.asList("A","B","C","D","E","F","G","H","I","J"));
		
		System.out.println("ss1 :" + ss1);
		
		System.out.println("ss1.first() :" + ss1.first());
		
		// System.out.println("ss2.first() :"+ss2.first());
		
		System.out.println("ss1.last() :" + ss1.last());
		
		// System.out.println("ss2.last() :"+ss2.last());
		
		SortedSet<String>ss3=ss1.tailSet("D");
		
		System.out.println("ss3 :"+ss3);
		
		//ss3.add("A");
		ss3.add("K");
		
		System.out.println("ss1 :" + ss1);
		
		SortedSet<String>ss4=ss1.subSet("D","I");
		
		System.out.println("ss4 :" + ss4);*/
		
		
		/*NavigableSet<String> ns2 = new TreeSet<String>();
		NavigableSet<String> ns1 = new TreeSet<String>(Arrays.asList("A","B","C","D","E","F","G","H","I","J"));
		
		System.out.println("ns1 :" + ns1);
		System.out.println("ns1.floor() :" + ns1.floor("D")); 
		System.out.println("ns1.lower() :" + ns1.lower("D"));
		System.out.println("ns1.ceiling() :" + ns1.ceiling("D"));
		System.out.println("ns1.higher() :" + ns1.higher("D"));
		System.out.println("ns1.pollFirst() :"+ns1.pollFirst()); 
		System.out.println("ns1 :" + ns1);
		System.out.println("ns1.pollLast() :"+ns1.pollLast()); 
		System.out.println("ns1 :" + ns1);
		Iterator<String>it=ns1.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		it=ns1.descendingIterator();
		System.out.println();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		
		
		
		
		System.out.println("*****************************************");*/
		
		TreeSet<TreeSet_A> set2 = new TreeSet<TreeSet_A>(new SortByName());
		bol[0] = set2.add(col1);
		bol[2] = set2.add(col3);
		bol[1] = set2.add(col2);
		System.out.println("set2 :"+set2);
		
		
	}

}
