package com.test.collection;

import java.util.Enumeration;
import java.util.Vector;

class Vector_A {
	int id;
	String name;
	boolean bol;

	public Vector_A() {
		super();
	}

	public Vector_A(int id, String name, boolean bol) {
		super();
		this.id = id;
		this.name = name;
		this.bol = bol;
	}

	public boolean equals(Object obj) {
		System.out.println("List A equals..............");
		if (this == obj)
			return true;
		if (!(obj instanceof Vector_A))
			return false;
		Vector_A la = (Vector_A) obj;
		return this.id == la.id && this.name.equals(la.name)
				&& this.bol == la.bol;

	}

	public String toString() {
		return id + " " + name + " " + bol;
	}
}

public class VectorTest {

	public static void main(String[] args) {
		Boolean[] bol = new Boolean[6];
		Vector<Vector_A> v1 = new Vector<Vector_A>();
		Vector_A la1 = new Vector_A(10, "Prashant", true);
		Vector_A la2 = new Vector_A(20, "Anshu", true);
		Vector_A la3 = new Vector_A(30, "Infinite", false);
		v1.add(la1);
		v1.add(1,la2);
		v1.addElement(la3);
		System.out.println(v1.size());
		System.out.println(v1.isEmpty());
		System.out.println(v1);
		System.out.println(v1.contains(la3));
		System.out.println(v1.elementAt(0));
		Enumeration<Vector_A> en=v1.elements();
		while (en.hasMoreElements()) {
			Vector_A vector_A =  en.nextElement();
			System.out.println(vector_A);			
		}
		
		
	}

}
