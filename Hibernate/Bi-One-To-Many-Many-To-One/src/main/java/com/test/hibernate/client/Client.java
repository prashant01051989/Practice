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
		Address add1 = new Address();
		add1.setStreet("B.Narayanpura");
		add1.setCity("Blore");
		add1.setState("KA");
		add1.setZipcode("560016");
		Address add2 = new Address();
		add2.setStreet("B.Narayanpura1");
		add2.setCity("Blore1");
		add2.setState("KA1");
		add2.setZipcode("560016");
		Set<Address> address = new HashSet<Address>();
		address.add(add1);
		address.add(add2);
		Student stu1 = new Student();
		stu1.setSname("Anshu");
		stu1.setAdd(address);
		add1.setStu(stu1);
		add2.setStu(stu1);
		session.save(stu1);
		tx.commit();
		session.close();
		HibernateUtil.getSessionFactory().close();
	}
}
