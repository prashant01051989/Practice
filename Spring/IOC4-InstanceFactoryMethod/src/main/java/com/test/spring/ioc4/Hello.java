package com.test.spring.ioc4;

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

	public Hello(A a, B b) {
		super();
		LOG.debug("Hello 2Para con");
		this.a = a;
		this.b = b;
	}

	public Hello getHelloInstance(A a, B b) {
		LOG.info("Hello getHelloInstance()");
		return new Hello(a, b);

	}

	public void show() {
		LOG.info("Hello show()");
		System.out.println("a  :" +this.a.a);
		System.out.println("aName  :" + this.a.aName);
		System.out.println("b  :" + this.b.b);
		System.out.println("bName :" + this.b.bName);
	}

}
