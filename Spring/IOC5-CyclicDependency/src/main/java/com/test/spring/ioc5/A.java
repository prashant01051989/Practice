package com.test.spring.ioc5;

import org.apache.log4j.Logger;

public class A {
	private static final Logger LOG = Logger.getLogger(A.class);

	B b;

	public A() {
		LOG.info("A def con");
	}

	public B getB() {
		LOG.info("A getB");
		return b;
	}

	public void setB(B b) {
		LOG.info("A setB");
		this.b = b;
	}

}
