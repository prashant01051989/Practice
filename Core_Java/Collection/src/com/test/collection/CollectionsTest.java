package com.test.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


class Student{
	int sid;
	String name;
	long phone;
	public Student() {
		super();
	}
	public Student(int sid, String name, long phone) {
		super();
		this.sid = sid;
		this.name = name;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "{sid=" + sid + ", name=" + name + ", phone=" + phone+"}"
				;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}

public class CollectionsTest {

	public static void main(String[] args) {
	final	Set<Student>set1=new HashSet<Student>();
	
		Student stu1=new Student(1,"Anhsu",983562);
		Student stu2=new Student(11,"Prashant",483562);
		Student stu3=new Student(12,"Infinite",583562);
		Student stu4=new Student(13,"set",683562);
		set1.add(stu1);
		set1.add(stu2);
		set1.add(stu3);
		set1.add(stu4);
		
		System.out.println("**************Original set*****************");
		System.out.println(set1);
		Set set2=Collections.unmodifiableSet(set1);
//final Set<Student> set2=set1;
		System.out.println("**************unmodifiableSet set*****************");
		System.out.println(set2);
		System.out.println("**************Try to add element set*****************");
		set2.add(stu1);
		System.out.println("**************Change in element set*****************");
		stu1.name="Kumar";
		System.out.println(set2);
		List<Student>list=new ArrayList<Student>();
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu4);
		
		List<Student>list5=new ArrayList<Student>();
		list5.add(stu1);
		list5.add(stu2);
		System.out.println(list);
		System.out.println(list5);
		System.out.println(">>>>>>>>>>>>>>> "+Collections.indexOfSubList(list, list5));
		System.out.println(">>>>>>>>>> "+Collections.lastIndexOfSubList(list, list5));
		System.out.println("**************Original list*****************");
		System.out.println(list);
		List<Student>list2=Collections.unmodifiableList(list);
		//list2.add(stu1);
		Collections.swap(list, 1, 3);
		System.out.println(list);
		List<Student>list3=Collections.singletonList(stu1);
		System.out.println(list3);
		//list3.add(stu4);
		Map<Student,String> map=Collections.singletonMap(stu1, "Student Object");
		System.out.println(map);
		Collections.reverse(list);
		System.out.println(list);
		System.out.println(Collections.frequency(list, stu1));
		List<Student>list4=Collections.nCopies(5, stu1);
		System.out.println(list4);
		
		
	}

}
