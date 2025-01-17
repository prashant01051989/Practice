package com.test.hibernate.client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
		Address add1 = new Address("B.Naraynapura", "Blore", "KA", "560016");
		Address add2= new Address("A.Naraynapura", "Blore", "KA", "560056");
		Student stu1 = new Student("Anshu", add1);
		Student stu2 = new Student("Prashant", add2);
		session.save(stu1);
		//session.save(stu2);
		Student stu3=(Student) session.load(Student.class, 2);
		System.out.println(stu3);
		session.delete(stu3);
		tx.commit();
		session.close();
		
	}
}
