package com.test.hibernate.client;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.test.hibernate.persis.Message;
import com.test.hibernate.util.HibernateUtil;




public class Client {

	public static void main(String[] args) {
		//First unit of work
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx1=session.beginTransaction();
		Message message=new Message("Hello World");
		Long msgId=(Long) session.save(message);
		tx1.commit();
		session.close();
		
		//Second unit of Work
			Session newSession=HibernateUtil.getSessionFactory().openSession();
			Transaction tx2=newSession.beginTransaction();
			List<Message> messages=newSession.createQuery("from Message m order by m.text asc").list();
			System.out.println(messages.size() +" Message(s) found");
			Iterator<Message>it=messages.iterator();
			while(it.hasNext()){
				Message msg=it.next();
				System.out.println(msg.getText());
			}
			HibernateUtil.shutdown();
		//Third unit of Work
			
			Session thirdSession=HibernateUtil.getSessionFactory().openSession();
			System.out.println(HibernateUtil.getSessionFactory().isClosed());
			Transaction tx3=thirdSession.beginTransaction();
			message=(Message) thirdSession.get(Message.class,msgId);
			message.setText("Third Session");
			message.setNextMessage(new Message("Related to third Session"));
			tx3.commit();
			thirdSession.close();
	}
}
