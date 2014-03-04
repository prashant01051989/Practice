package com.test.spring.ioc6.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.spring.ioc6.Hello;

public class Main {
	public static void main(String as[]) {
		ApplicationContext app = new ClassPathXmlApplicationContext(
				"config.xml");
		/*Hello hello1 = app.getBean("hello1", Hello.class);
		hello1.show();*/
		Hello hello2 = app.getBean("hello2", Hello.class);
		hello2.show();
		Hello hello3 = app.getBean("hello3", Hello.class);
		hello3.show();
		Hello hello4 = app.getBean("hello4", Hello.class);
		hello4.show();

	}
}
