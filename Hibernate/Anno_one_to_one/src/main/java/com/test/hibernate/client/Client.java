package com.test.hibernate.client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.hibernate.persis.Address;
import com.test.hibernate.persis.AddressPK;
import com.test.hibernate.persis.Student;
import com.test.hibernate.util.HibernateUtil;

public class Client {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Address add1 = new Address("B.Naraynapura", "Blore", "KA", "560016");
		AddressPK apk= new AddressPK();
		apk.setSid(560016);
		add1.setApk(apk);
		Address add2= new Address("A.Naraynapura", "Blore", "KA", "560056");
		Student stu1 = new Student("Anshu", add1);
		//add1.setStu(stu1);
		//Student stu2 = new Student("Prashant", add2);
		
		session.save(stu1);
		
	/*	stu2=(Student) session.load(Student.class, 1);
		System.out.println(stu2);
		add1=stu2.getAdd();		
		System.out.println(add1);*/
		/*add1=(Address) session.load(Address.class, 1);
		System.out.println(add1);
		stu1=add1.getStu();		
		*/
		
		tx.commit();
		session.close();

	}
}
