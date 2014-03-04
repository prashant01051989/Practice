package com.test.spring.ioc7;

import org.apache.log4j.Logger;

public class B {
	private static final Logger LOG = Logger.getLogger(B.class);

	int b;
	String bName;

	static {
		LOG.info("B Static block");
	}

	{
		LOG.info("B instance block");
	}

	public B() {
		LOG.info("B def con");
	}

	public void setB(int b) {
		LOG.info("B setB");
		this.b = b;
	}

	public void setbName(String bName) {
		LOG.info("B setbName");
		this.bName = bName;
	}

	public void showB() {
		LOG.info("B ShowB()");
		System.out.println(this.b);
		System.out.println(this.bName);
	}
}
