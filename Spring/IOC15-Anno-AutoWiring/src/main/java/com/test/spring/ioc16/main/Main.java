package com.test.spring.ioc16.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.spring.ioc16.Hello;

public class Main {
	public static void main(String as[]) {
		ApplicationContext app = new ClassPathXmlApplicationContext(
				"config.xml");
		Hello hello = app.getBean("hello1", Hello.class);
		hello.show();
	}
}
