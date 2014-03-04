package com.test.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class ListA {
	int a;
	String str;
	boolean b;

	public ListA() {
		super();
	}

	public ListA(int a, String str, boolean b) {
		super();
		this.a = a;
		this.str = str;
		this.b = b;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("ListA equals ..");
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof ListA)) {
			return false;
		}
		ListA coll = (ListA) obj;
		return this.a == coll.a && this.str.equals(coll.str)
				&& this.b == coll.b;
	}

	public String toString() {
		return a + " " + str + " " + b;
	}

}

public class ListTest {

	public static void main(String[] args) {
		ListA col1 = new ListA(10, "Prashant", true);
		ListA col2 = new ListA(20, "Anshu", false);
		ListA col3 = new ListA(30, "Infinite", true);
		List<ListA> ct1 = new ArrayList<ListA>();
		System.out.println(ct1);
		System.out.println(ct1.size());
		System.out.println(ct1.isEmpty());
		ct1.add(null);
		ct1.add(col1);
		ct1.add(col2);
		ct1.add(col3);
/*		ct1.add(new ListA(20, "Anshu", false));
		ct1.add(null);
		// ct1.add(new Integer(4));
		System.out.println(ct1);
		System.out.println(ct1.size());
		System.out.println(ct1.isEmpty());
		System.out.println(ct1.contains(col1));
		boolean bol = ct1.contains(new ListA(20, "Anshu", false));
		System.out.println(bol);
		Collection<ListA> ct2 = new ArrayList<ListA>();
		ct2.addAll(ct1);
		System.out.println(ct2);
		System.out.println("ct2.containsAll(ct1) :" + ct2.containsAll(ct1));
		bol = ct1.remove(new ListA(20, "Anshu", false));
		System.out.println("bol :" + bol);
		System.out.println("cl1 :" + ct1);
		ct1.remove(col2);
		System.out.println("cl1 :" + ct1);
		Iterator<ListA> it = ct1.iterator();
		while (it.hasNext()) {
			ListA collA = (ListA) it.next();
			System.out.println(collA);
		}
		Object[] obj = ct1.toArray();
		for (int i = 0; i < obj.length; i++) {
			System.out.println(obj[i]);
		}
		ListA[] collA3 = new ListA[5];
		ListA[] collA4 = ct1.toArray(collA3);
		System.out.println("***************************");
		for (int i = 0; i < collA3.length; i++) {
			System.out.println(collA3[i]);
		}
		System.out.println("***************************");
		for (int i = 0; i < collA4.length; i++) {
			System.out.println(collA4[i]);
		}
		ct2.retainAll(ct1);
		System.out.println(ct2);
		ct2.clear();
		System.out.println(ct2);*/
	}

}
