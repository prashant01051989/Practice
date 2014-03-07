package com.test.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.test.hibernate.persis.Customer;




public class Client {

	public static void main(String[] args) {
		AnnotationConfiguration conf=new AnnotationConfiguration();
		conf=conf.configure();
		SessionFactory sessionFactory=conf.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Customer cust=new Customer("Anshu","a@gmail.com","Blore","Active",987654321l);
		int id=(Integer) session.save(cust);
		System.out.println(id);
		tx.commit();
		session.close();
		sessionFactory.close();
		
	}
}