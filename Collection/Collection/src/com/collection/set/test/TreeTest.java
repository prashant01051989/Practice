package com.collection.set.test;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class Student implements Comparable<Student> {
	String name;
	int id;

	Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public boolean equals(Object o) {
		System.out.println("equals method of Student");
		if (o instanceof Student) {
			Student a = (Student) o;
			if (a.name.equals(this.name)) {
				return true;
			}
		}
		return false;
	}

	public int hashCode() {
		System.out.println("hashCode method of Student");
		return this.id;
	}

	public int compareTo(Student s) {
		System.out.println("Student CompareTO method");
		return this.name.compareTo(s.name);
	}
	public String toString(){
		return this.name;
	}

}

public class TreeTest {

	public static void main(String[] args) {
		Student s1 = new Student(1, "A");
		Student s2 = new Student(2, "B");
		Student s3 = new Student(3, "C");
		Student s4 = new Student(4, "D");
		Student s5 = new Student(5, "E");
		Student s6 = new Student(6, "F");
		TreeMap<Student, String> t = new TreeMap<Student, String>();
		System.out.println(t.size());
		System.out.println(t.isEmpty());
		t.put(s1, "A");
		t.put(s2, "B");
		t.put(s3, "C");
		t.put(s4, "D");
		t.put(s5, "E");
		t.put(s6, "F");
		t.put(null,null);
		System.out.println(t);
		
		/*Collection<String> c=t.values();
		Iterator<String>it=c.iterator();
		while (it.hasNext()) {
			String type = (String) it.next();
			System.out.println(type);
			if(type.equals("A"))
			it.remove();
			
		}
		System.out.println(t);*/
		
		SortedMap<Student,String>sm=t.tailMap(s4);
		System.out.println(sm);
		SortedMap<Student,String>sm1=t.headMap(s4);
		System.out.println(sm1);
		SortedMap<Student,String>sm2=t.subMap(s3,s6);
		System.out.println(sm2);
		Student s7=t.firstKey();
		System.out.println(s7.name);
		Student s8=t.lastKey();
		System.out.println(s8.name);
		Set<Student>set=t.keySet();
		System.out.println(set);
		System.out.println(t.containsKey(s3));
		System.out.println(t.containsValue("B"));
		Comparator c=t.comparator();
		System.out.println(c);
		
		
		
		
		
	}

}
