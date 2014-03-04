package com.collection.set.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

class A{
	int id;
	String name;
	A(int id,String name){
		this.id=id;
		this.name=name;
	}
	public boolean equals(Object o){
		System.out.println("equals method of A");
		if(o instanceof A){
			A a=(A)o;
			if(a.name.equals(this.name)){
				return true;
			}
		}
		return false;
	}
public int hashCode(){
	System.out.println("hashCode method of A");
	return this.id;
}
	
}

public class SetTest {


	public static void main(String[] args) {
		A a1=new A(1,"A");
		A a2=new A(2,"B");
		
		a1.name="Ras";
		HashSet<A> h1=new HashSet<A>();
		System.out.println("h1.size() "+h1.size());
		System.out.println("h1.isEmpty() "+h1.isEmpty());
		System.out.println(h1.add(a1));
		System.out.println(h1.add(a2));
		System.out.println(h1.add(a1));
		System.out.println(h1.add(null));
		A a3=new A(1,"A");
		System.out.println("h1.contains(a3) "+h1.contains(a3));
		A a4=new A(4,"A");
		System.out.println("h1.contains(a4) "+h1.contains(a4));
		Iterator<A> it=h1.iterator();
		while(it.hasNext()){
			A a=(A)it.next();
			if(a!=null)
			System.out.println(a.name);
		}
		
	Object[] o=h1.toArray();
	for (Object object : o) {
		if(object!=null)
		System.out.println(((A)object).name);
	}
	
	//System.out.println("h1.remove(a1) "+h1.remove(a1));
	System.out.println(h1.hashCode());
	HashSet<A>h2=new HashSet<A>();
	h2.add(a1);
	h2.add(a2);

	System.out.println("h1.addAll(h2) "+h1.addAll(h2));
	//System.out.println(h1.removeAll(h2));
	System.out.println(h1.retainAll(h2));
	System.out.println(h1.equals(h2));
	HashSet<String> names=new HashSet<String>()	;
	names.add("A");
	names.add("B");
	names.add("C");
	names.add("D");
	names.add("E");
	names.add("F");
	names.add("G");
	names.add("H");
	names.add("I");
	names.add("J");
	names.add("K");
	names.add("L");
	System.out.println(names);
	LinkedHashSet<String> names1=new LinkedHashSet<String>()	;
	names1.add("A");
	names1.add("B");
	names1.add("C");
	names1.add("D");
	names1.add("E");
	names1.add("F");
	names1.add("G");
	names1.add("H");
	names1.add("I");
	names1.add("J");
	names1.add("K");
	names1.add("L");
	System.out.println(names1);
	}
	
	
	

}
