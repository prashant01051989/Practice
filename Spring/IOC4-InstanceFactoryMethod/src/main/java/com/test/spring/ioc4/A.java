package com.test.spring.ioc4;

import org.apache.log4j.Logger;

public class A {
	private static final Logger LOG = Logger.getLogger(A.class);
	int a;
	String aName;

	static {
		LOG.info("A Static block");
	}

	{
		LOG.info("A instance block");
	}

	public A() {
		LOG.info("A def con");
	}

	public A(int a, String aName) {
		LOG.info("A 2-arg con");
		this.a = a;
		this.aName = aName;
	}

	public A getAInstance(int a, String aName) {
		LOG.info("A getAInstance()");
		return new A(a, aName);
	}

	public void showA() {
		LOG.info("A ShowA()");
		System.out.println(this.a);
		System.out.println(this.aName);
	}

}
