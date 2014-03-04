package com.test.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class CollA {
	int a;
	String str;
	boolean b;

	public CollA() {
		super();
	}

	public CollA(int a, String str, boolean b) {
		super();
		this.a = a;
		this.str = str;
		this.b = b;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("CollA equals ..");
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof CollA)) {
			return false;
		}
		CollA coll = (CollA) obj;
		return this.a == coll.a && this.str.equals(coll.str)
				&& this.b == coll.b;
	}

	public String toString() {
		return a + " " + str + " " + b;
	}

}

public class CollectionTest {

	public static void main(String[] args) {
		CollA col1 = new CollA(10, "Prashant", true);
		CollA col2 = new CollA(20, "Anshu", false);
		CollA col3 = new CollA(30, "Infinite", true);

		Collection<CollA> ct1 = new ArrayList<CollA>();
		System.out.println(ct1);
		System.out.println(ct1.size());
		System.out.println(ct1.isEmpty());
		ct1.add(null);
		ct1.add(col1);
		ct1.add(col2);
		ct1.add(col3);
		ct1.add(new CollA(20, "Anshu", false));
		ct1.add(null);
		// ct1.add(new Integer(4));
		System.out.println(ct1);
		System.out.println(ct1.size());
		System.out.println(ct1.isEmpty());
		System.out.println(ct1.contains(col1));
		boolean bol = ct1.contains(new CollA(20, "Anshu", false));
		System.out.println(bol);
		Collection<CollA> ct2 = new ArrayList<CollA>();
		ct2.addAll(ct1);
		System.out.println(ct2);
		System.out.println("ct2.containsAll(ct1) :" + ct2.containsAll(ct1));
		bol = ct1.remove(new CollA(20, "Anshu", false));
		System.out.println("bol :" + bol);
		System.out.println("cl1 :" + ct1);
		ct1.remove(col2);
		System.out.println("cl1 :" + ct1);
		Iterator<CollA> it = ct1.iterator();
		while (it.hasNext()) {
			CollA collA = (CollA) it.next();
			System.out.println(collA);
		}
		Object[] obj = ct1.toArray();
		for (int i = 0; i < obj.length; i++) {
			System.out.println(obj[i]);
		}
		CollA[] collA3 = new CollA[5];
		CollA[] collA4 = ct1.toArray(collA3);
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
		System.out.println(ct2);
	}

}
