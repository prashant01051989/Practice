package com.test.spring.ioc6.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.spring.ioc6.NullAndEmpty;

public class NullAndEmptyMain {
	public static void main(String as[]) {
		ApplicationContext app = new ClassPathXmlApplicationContext(
				"NullAndEmptyConfig.xml");
	NullAndEmpty obj=app.getBean("obj1",NullAndEmpty.class);
	System.out.println(obj.getEmpty());
	System.out.println(obj.getName());

	}
}
