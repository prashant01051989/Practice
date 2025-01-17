package com.test.hibernate.client;

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
		add1.setCity("Blore");
		add1.setState("KA");
		add1.setStreet("B.Narayanpura");
		add1.setZipcode("560016");
		Student stu1 = new Student("Anshu", add1);
		add1.setStu(stu1);
		session.save(stu1);
		tx.commit();
		session.close();
	}
}
