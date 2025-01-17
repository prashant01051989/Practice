package com.test.hibernate.client;

import java.util.HashSet;
import java.util.Set;

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
	//	Customer cust=new Customer("Anshu","a@gmail.com","Blore","Active",987654321l);
		//session.save(cust);
    	//Customer cust1=(Customer) session.get(Customer.class,1);
	//	System.out.println("Cust1:" + cust1);
		Customer cust2=(Customer) session.load(Customer.class,1);
	//	System.out.println("Cust2:" +  cust2);
		tx.commit();
		session.close();
		System.out.println("Cust2 CIty:" +  cust2.getCity());
		/*Session session2=sessionFactory.openSession();
		Transaction tx2=session2.beginTransaction();
		Customer cust3=(Customer) session2.get(Customer.class,1);
		tx2.commit();
		session2.close();
		Set<Customer> set=new HashSet<Customer>();
		set.add(cust1);
		set.add(cust2);
		set.add(cust3);
		System.out.println(set.size());*/
	}
}
