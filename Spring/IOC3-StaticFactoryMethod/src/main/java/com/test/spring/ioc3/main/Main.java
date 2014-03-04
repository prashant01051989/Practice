package com.test.spring.ioc3.main;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.spring.ioc3.Hello;

public class Main {
	public static final Logger LOG = Logger.getLogger(Main.class);

	public static void main(String as[]) {
		LOG.info("Main-Method");
		ApplicationContext app = new ClassPathXmlApplicationContext(
				"config.xml");
		Hello hello = app.getBean("hello1", Hello.class);
		hello.show();

	}
}
