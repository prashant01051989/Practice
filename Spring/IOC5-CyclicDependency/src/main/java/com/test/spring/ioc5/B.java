package com.test.spring.ioc5;

import org.apache.log4j.Logger;

public class B {
	private static final Logger LOG = Logger.getLogger(B.class);

	A a;

	public B() {
		LOG.info("B def con");
	}

	public A getA() {
		LOG.info("B getA");
		return a;
	}

	public void setA(A a) {
		LOG.info("B setA");
		this.a = a;
	}

}
