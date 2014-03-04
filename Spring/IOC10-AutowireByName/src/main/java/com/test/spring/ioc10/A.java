package com.test.spring.ioc10;

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

	public void setA(int a) {
		LOG.info("A setA");
		this.a = a;
	}

	public void setaName(String aName) {
		LOG.info("A setaName");
		this.aName = aName;
	}

	public void showA() {
		LOG.info("A ShowA()");
		System.out.println(this.a);
		System.out.println(this.aName);
	}

}
