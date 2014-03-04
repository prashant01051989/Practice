package com.test.spring.ioc13;

import org.apache.log4j.Logger;

public class Hello {
	private static final Logger LOG = Logger.getLogger(Hello.class);

	A a = null;
	B b = null;
	

	static {
		LOG.info("Hello static block");
	}
	{
		LOG.info("Hello instance block");
	}

	public Hello() {
		LOG.debug("Hello def con");
	}

	public void setA(A a) {
		LOG.info("A-setA");
		this.a = a;
	}

	public void setB(B b) {
		LOG.info("B-setB");
		this.b = b;
	}
	
	public void show() {
		LOG.info("Hello show()");
		System.out.println("a  :" + this.a.a);
		System.out.println("aName  :" + this.a.aName);
		System.out.println("b  :" + this.b.b);
		System.out.println("bName :" + this.b.bName);
	}

	
}
