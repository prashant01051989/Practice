package com.test.hibernate.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.hibernate.persis.Address;
import com.test.hibernate.persis.Customer;
import com.test.hibernate.persis.PhoneType;
import com.test.hibernate.util.HibernateUtil;

public class Client {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Address add1 = new Address();
		add1.setCity("blore");
		add1.setState("Karnataka");
		add1.setStreet("A. Narayanapura");
		add1.setZipcode("560016");
		Address add2 = new Address();
		add2.setCity("blore2");
		add2.setState("Karnataka2");
		add2.setStreet("B. Narayanapura2");
		add2.setZipcode("560016-2");
		Address add3 = new Address();
		add3.setCity("blore");
		add3.setState("Karnataka");
		add3.setStreet("E. Narayanapura");
		add3.setZipcode("560016");
		Address add4 = new Address();
		add4.setCity("blore2");
		add4.setState("Karnataka2");
		add4.setStreet("D. Narayanapura2");
		add4.setZipcode("560016-2");
		List<Address> adds = new ArrayList<Address>();
		adds.add(add1);
		adds.add(add2);
		adds.add(add4);
		adds.add(add3);
		Set<String> names = new HashSet<String>();
		names.add("Anshu1");
		names.add("Anshu2");
		names.add("Anshu3");
		Map<PhoneType,String>phones=new HashMap<PhoneType,String>();
		phones.put(PhoneType.Home,"1111");
		phones.put(PhoneType.Mobile,"222");
		phones.put(PhoneType.Office,"333");
		Customer cust = new Customer();
		cust.setCustNames(names);
		cust.setEmail("pras@gmai.com");
		cust.setCustAdds(adds);
		cust.setPhones(phones);
		session.save(cust);
		/*
		Customer cust1=(Customer) session.load(Customer.class,3);
		List<Address> adds1=cust1.getCustAdds();
		System.out.println(adds1);*/
		session.
		tx.commit();
		session.close();

	}
}
