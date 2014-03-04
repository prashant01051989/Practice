package com.test.collection;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class HashMap_A implements Comparable<HashMap_A> {
	int id;
	String name;
	boolean bol;

	public HashMap_A() {
		super();
	}

	public HashMap_A(int id, String name, boolean bol) {
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
		if (!(obj instanceof HashMap_A))
			return false;
		HashMap_A la = (HashMap_A) obj;
		return this.id == la.id && this.name.equals(la.name)
				&& this.bol == la.bol;
	}

	@Override
	public int hashCode() {
		System.out.println("************HashCode*************");
		return this.id;
	}

	@Override
	public int compareTo(HashMap_A obj) {

		return this.id - obj.id;
	}

	public String toString() {
		return id + " " + name + " " + bol;
	}

}

public class MapTest {
	public static void main(String[] args) {
		HashMap_A hm1=new HashMap_A(10,"Anshu",true);
		HashMap_A hm2=new HashMap_A(20,"Kumar",false);
		HashMap_A hm3=new HashMap_A(30,"Prashant",true);
		
		HashMap<HashMap_A,String> h1=new HashMap<HashMap_A,String>();
		h1.put(hm1,"true_Anshu");
		h1.put(hm2,"false_Kumar");
		h1.put(hm3,"true_Prashant");
		h1.put(null,"true_Prashant");
		h1.put(hm1,"False_Prashant");
		h1.put(null, null);
		System.out.println("h1.size() :"+h1.size());
		System.out.println("h1.isEmpty() :"+h1.isEmpty());
		boolean bol=h1.containsKey(new HashMap_A(40,"Anshu",true));
		System.out.println(bol);
		bol=h1.containsKey(new HashMap_A(20,"Anshu",false));
		System.out.println(bol);
		bol=h1.containsKey(new HashMap_A(20,"Kumar",false));
		System.out.println(bol);
		bol=h1.containsValue("Kumar");
		System.out.println(bol);
		bol=h1.containsValue("false_Kumar");
		System.out.println(bol);
		Set<Map.Entry<HashMap_A,String>> set=h1.entrySet();
		Iterator<Map.Entry<HashMap_A,String>> it=set.iterator();
		while(it.hasNext()){
			Map.Entry<HashMap_A,String> me=it.next();
			System.out.println(me.getKey()+" : "+me.getValue());
		}
		System.out.println(set instanceof Set);
		System.out.println(set instanceof HashSet);
		System.out.println(set instanceof LinkedHashSet);
		System.out.println(set instanceof TreeSet);
		System.out.println(set instanceof AbstractSet);
		
		Set<HashMap_A>keySet=h1.keySet();
		for (HashMap_A hashMap_A : keySet) {
			System.out.println(hashMap_A);
		}
		
		System.out.println(h1);
		keySet.remove(hm1);
		System.out.println(h1);
	//	keySet.add(hm1);
		Collection<String> col=h1.values();
		for(String str:col){
			System.out.println(str);
		}
		String str=h1.get(h1);
		System.out.println(str);
		str=h1.remove(h1);
		System.out.println(str);
	}

}
