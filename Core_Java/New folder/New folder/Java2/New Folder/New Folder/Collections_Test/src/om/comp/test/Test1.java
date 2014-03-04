package om.comp.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Test1 {
	public static void main(String[] args)
    {
		ArrayList<Student>al=new ArrayList<Student>();
		Student s1=new Student(22,"dd","cc@jlc");
		Student s2=new Student(44,"aa","bb@jlc");
		Student s3=new Student(44,"cc","dd@jlc");
		Student s4=new Student(33,"bb","aa@jlc");
		al.add(s1);
		al.add(s2);
		al.add(s3);
		al.add(s4);
		System.out.println("No Sorting");
		Iterator it=al.iterator();
		while (it.hasNext()) {
			Student s = (Student) it.next();
			System.out.println(s);
		}
		System.out.println("Sorting By Sid");
		Collections.sort(al);
		it=al.iterator();
		while (it.hasNext()) {
			Student s = (Student) it.next();
			System.out.println(s);
		}
    
    }
}