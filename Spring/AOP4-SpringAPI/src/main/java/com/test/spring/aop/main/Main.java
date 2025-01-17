package com.test.spring.aop.main;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.spring.aop.services.HelloService;

public class Main {
	private static final Logger LOG = Logger.getLogger(Main.class);

	public static void main(String as[]) {

		ApplicationContext app = new ClassPathXmlApplicationContext(
				"config.xml");

		LOG.info("**************After Proxy *******************");
		HelloService helloproxy = app
				.getBean("helloTarget", HelloService.class);
		helloproxy.helloM1();
		try {
			helloproxy.helloM2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
