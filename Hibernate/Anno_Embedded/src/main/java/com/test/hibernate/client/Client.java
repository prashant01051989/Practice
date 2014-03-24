package com.test.hibernate.client;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.test.hibernate.persis.Address;
import com.test.hibernate.persis.Customer;
import com.test.hibernate.persis.Employee;
import com.test.hibernate.util.HibernateUtil;

public class Client {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Address add=new Address();
		add.setCity("blore");
		add.setState("Karnataka");
		add.setStreet("B. Narayanapura");
		add.setZipcode("560016");
		Customer cust=new Customer();
		cust.setCustName("anshu");
		cust.setEmail("pras@gmai.com");
		cust.setCustAdd(add);
		Employee emp=new Employee();
		emp.setName("Prashant");
		emp.setSalary(15000);
		emp.setEmpAdd(add);
		session.save(emp);
		session.save(cust);
		tx.commit();
		session.close();

	}
}
