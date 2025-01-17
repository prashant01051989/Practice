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
		Transaction tx = session.beginTransaction();
		Set<Address> address = new HashSet<Address>();
		Address add1 = new Address("B.Naraynapura", "Blore", "KA", "560016");
		Address add2= new Address("A.Naraynapura", "Blore", "KA", "560056");
		address.add(add1);
		address.add(add2);
		Student stu1 = new Student("Anshu", address);
		session.save(stu1);
		tx.commit();
		session.close();
	}
}
