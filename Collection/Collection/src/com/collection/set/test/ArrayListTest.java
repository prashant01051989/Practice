package com.collection.set.test;

import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> al=new ArrayList<String>();
		System.out.println(al);
		System.out.println(al.size());
		System.out.println(al.isEmpty());
		al.add("A");
		al.add("B");
		al.add("C");
		al.add("D");
		/*al.add("");
		al.add("A");
		al.add(null);
		al.add(null);
		System.out.println(al);
		System.out.println(al.size());
		
		System.out.println(al);
		al.addAll(al);
		System.out.println(al);
		al.addAll(3,al);
		System.out.println(al);
		System.out.println(al.contains("Anshu"));
		System.out.println(al.containsAll(al));
		System.out.println(al.remove("Anshu"));
		System.out.println(al);
		System.out.println(al.indexOf("A1"));
		System.out.println(al.indexOf("A1"));
		System.out.println(al.size());
		System.out.println(al.remove(0));
		System.out.println(al);
		System.out.println(al.size());
		//System.out.println(al.removeAll(al));
		System.out.println(al);
		System.out.println(al.size());
		System.out.println(al.isEmpty());
		System.out.println(al.lastIndexOf("B"));
		System.out.println(al.get(4));
		al.trimToSize();
		System.out.println(al.set(2,"Prashant"));
		*/
		System.out.println(al);
		ListIterator<String>ls=al.listIterator();
		//for(int i=0;i<al.size()+1;i++){
		for(int i=0;i<al.size();i++){
			System.out.print(" "+ls.next());
		}
		System.out.println();
		ls=al.listIterator();
		while (ls.hasNext()) {
			ls.add("*");
			ls.add("^");
			//ls.remove(); It's not working because ls is not pointing to any element
			String s=(String)ls.next();
			System.out.println(s);
			//ls.add("&");
			//ls.add("#");
			//ls.remove();
			
			
		}
		System.out.println(al);
		/*while (ls.hasPrevious()) {
			//ls.add("J");
		ls.remove();
			//ls.remove();
			String s=(String)ls.previous();
			System.out.println(s);
			//ls.add("J");
			break;
		}
		System.out.println(al);*/
		
	}

}