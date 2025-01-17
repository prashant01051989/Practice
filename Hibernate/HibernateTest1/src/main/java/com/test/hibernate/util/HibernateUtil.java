package com.test.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory=null;
	static{
		try{
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		sessionFactory=new Configuration().configure().buildSessionFactory();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public static void shutdown(){
		getSessionFactory().close();
	}

}
