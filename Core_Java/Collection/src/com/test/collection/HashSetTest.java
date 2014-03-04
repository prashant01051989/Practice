package com.test.collection;

import java.util.HashSet;
import java.util.Set;


class HashSet_A {
	int id;
	String name;
	boolean bol;

	public HashSet_A() {
		super();
	}

	public HashSet_A(int id, String name, boolean bol) {
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
		if (!(obj instanceof HashSet_A))
			return false;
		HashSet_A la = (HashSet_A) obj;
		return this.id == la.id && this.name.equals(la.name)
				&& this.bol == la.bol;
	}
	@Override
	public int hashCode(){
		System.out.println("***************HashCode*************** ");
		return this.id;
	}

	public String toString() {
		return id + " " + name + " " + bol;
	}
}

public class HashSetTest {

	public static void main(String[] args) {
		boolean[] bol = new boolean[6];
		HashSet_A col1 = new HashSet_A(10, "Prashant", true);
		HashSet_A col2 = new HashSet_A(20, "Anshu", false);
		HashSet_A col3 = new HashSet_A(30, "Infinite", true);
		Set<HashSet_A> set1=new HashSet<HashSet_A>();
		bol[0]=set1.add(col1);
		bol[1]=set1.add(col2);
		bol[2]=set1.add(col3);
		System.out.println(set1.size());
		System.out.println(set1.isEmpty());
		for (Boolean bol2 : bol) {
			System.out.print(bol2+"  ");
		}
		System.out.println();
		System.out.println(set1);
		set1.add(new HashSet_A(30, "Infinite", true));
		

	}

}
