package com.test.hibernate.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.hibernate.persis.Address;
import com.test.hibernate.persis.Student;
import com.test.hibernate.util.HibernateUtil;

public class Client {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Address add1 = new Address("B.Naraynapura", "Blore", "KA", "560016");
		Address add2 = new Address("A.Naraynapura", "Blore", "KA", "560056");
		Transaction tx = session.beginTransaction();
		Set<Address> addSet = new HashSet<Address>();
		addSet.add(add1);
		addSet.add(add2);
	//	Student stu1 = new Student("Anshu", addSet);
		Student stu1 = new Student();
		stu1.setSname("Prashant");
		session.save(stu1);

		tx.commit();
		session.close();

	}
}
