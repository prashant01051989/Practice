package com.test.hibernate.client;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.test.hibernate.persis.OldStudent;
import com.test.hibernate.persis.RegularStudent;
import com.test.hibernate.persis.Student;
import com.test.hibernate.util.HibernateUtil;

public class Client {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Student stu = new Student("Anshu", "Blore", "Active", 50009.00f);
		OldStudent os = new OldStudent("Ram", "Blore", "JOB", 13000,"Infinite", "a.a@a.com", 500000);
		RegularStudent rs=new RegularStudent("Ram", "Blore", "JOB", 13000,2000,"2.30 a.m","Marathalli","MCA","80%", 5);
		int id = (Integer) session.save(rs);
		//System.out.println(id);
		tx.commit();
		session.close();

	}
}
