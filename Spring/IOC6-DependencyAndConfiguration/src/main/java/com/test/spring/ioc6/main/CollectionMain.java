package com.test.spring.ioc6.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.spring.ioc6.collection.Customer;
import com.test.spring.ioc6.collection.Employee;
import com.test.spring.ioc6.collection.Order;

public class CollectionMain {
	public static void main(String as[]) {
		ApplicationContext app = new ClassPathXmlApplicationContext(
				"CollectionConfig.xml");
		/*Customer cust = app.getBean("cust1", Customer.class);
		System.out.println(cust.getCid());
		System.out.println(cust.getCname());
		for (String email : cust.getEmails()) {
			System.out.print(email + "\t");
		}
		System.out.println();
		for (Long phone : cust.getPhones()) {
			System.out.print(phone + "\t");
		}
		System.out.println();
		for (Order order : cust.getOrders()) {
			System.out.println(order + "\t");
		}
		System.out.println();
		System.out.println(cust.getRefs());
		System.out.println(cust.getMyProperties());*/
		
		Employee emp = app.getBean("emp1", Employee.class);
		System.out.println();
		System.out.println(emp.getCities());
		System.out.println(emp.getPhones());
		System.out.println(emp.getCompanies());
		
		
		
	}
}
