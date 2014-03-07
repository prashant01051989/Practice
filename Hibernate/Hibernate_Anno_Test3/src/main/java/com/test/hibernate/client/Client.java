package com.test.hibernate.client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.test.hibernate.persis.Student;
import com.test.hibernate.util.HibernateUtil;

public class Client {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		List<String> email = new ArrayList<String>();
		email.add("a@a.com");
		email.add("c@x.com");
		email.add("d@b.com");
		email.add("b@c.com");

		Set<Long> pho = new HashSet<Long>();
		pho.add(123456l);
		pho.add(123458l);
		pho.add(123459l);
		pho.add(123457l);


		Map<String, Long> refs = new TreeMap<String, Long>();
		refs.put("A", new Long(1000));
		refs.put("B", new Long(2000));
		refs.put("C", new Long(3100));

		Student stu = new Student("Prashant", "Karnataka", "Blore", "Student",
				email, pho, refs);
		Integer id = (Integer) session.save(stu);
		tx.commit();
		session.close();

	}
}
