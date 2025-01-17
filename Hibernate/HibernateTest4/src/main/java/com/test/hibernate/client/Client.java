package com.test.hibernate.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.hibernate.persis.OldStudent;
import com.test.hibernate.persis.Student;
import com.test.hibernate.util.HibernateUtil;

public class Client {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<String> emails=new ArrayList<String>();
		emails.add("a@e.com");
		emails.add("a@d.com");
		emails.add("a@c.com");
		emails.add("a@b.com");
		List<Long> phones=new ArrayList<Long>();
		phones.add((long)147856);
		phones.add((long)147857l);
		phones.add((long)147858l);
		phones.add((long)147859l);
		//Student stu=new Student("Anshu","Blore","Active",50009.00f,emails,phones);
		OldStudent os=new OldStudent("Ram","Blore","JOB",13000, emails, phones,"IGate","a.a@a.com",500000);
		int id=(Integer) session.save(os);
		System.out.println(id);
		tx.commit();
		session.close();
		
	}
}
