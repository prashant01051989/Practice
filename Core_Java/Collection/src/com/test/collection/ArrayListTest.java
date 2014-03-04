package com.test.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class ArrayList_A {
	int id;
	String name;
	boolean bol;

	public ArrayList_A() {
		super();
	}

	public ArrayList_A(int id, String name, boolean bol) {
		super();
		this.id = id;
		this.name = name;
		this.bol = bol;
	}

	public boolean equals(Object obj) {
		System.out.println("List A equals..............");
		if (this == obj)
			return true;
		if (!(obj instanceof ArrayList_A))
			return false;
		ArrayList_A la = (ArrayList_A) obj;
		return this.id == la.id && this.name.equals(la.name)
				&& this.bol == la.bol;

	}

	public String toString() {
		return id + " " + name + " " + bol;
	}
}

public class ArrayListTest {

	public static void main(String[] args) {
		Boolean[] bol = new Boolean[6];
		ArrayList<ArrayList_A> ali1 = new ArrayList<ArrayList_A>();
		ArrayList_A la1 = new ArrayList_A(10, "Prashant", true);
		ArrayList_A la2 = new ArrayList_A(20, "Anshu", true);
		ArrayList_A la3 = new ArrayList_A(30, "Infinite", false);
		System.out.println(ali1.size());
		System.out.println(ali1.isEmpty());
		bol[0] = ali1.add(la1);
		bol[1] = ali1.add(la2);
		bol[2] = ali1.add(la3);
		bol[3] = ali1.add(la1);
		bol[4] = ali1.add(null);
		ali1.trimToSize();
		
		
		
		
		
	}

}
