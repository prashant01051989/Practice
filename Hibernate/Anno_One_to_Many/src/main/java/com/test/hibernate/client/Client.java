package com.test.hibernate.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.hibernate.persis.Address;
import com.test.hibernate.persis.Student;
import com.test.hibernate.util.HibernateUtil;

public class Client {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Address add1 = new Address("F.Naraynapura", "Blore", "KA", "560016");
		Address add2= new Address("D.Naraynapura", "Blore", "KA", "560056");
		Transaction tx = session.beginTransaction();
		List<Address>addSet=new ArrayList<Address>();
		addSet.add(add1);
		addSet.add(add2);
		Student stu1 = new Student("Anshu", addSet);
		//session.save(stu1);
		Student st=(Student) session.load(Student.class,2 );
		List<Address> add=st.getAdd();
		System.out.println(add);
		tx.commit();
		session.close();

	}
}
