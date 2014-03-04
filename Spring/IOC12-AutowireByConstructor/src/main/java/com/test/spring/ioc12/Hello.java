package com.test.spring.ioc12;

import org.apache.log4j.Logger;

public class Hello {
	private static final Logger LOG = Logger.getLogger(Hello.class);

	A a = null;
	B b = null;
	String name;
	String age;

	static {
		LOG.info("Hello static block");
	}

	{
		LOG.info("Hello instance block");
	}

	public Hello() {
		LOG.debug("Hello def con");
	}

	/*public Hello(A a) {
		super();
		LOG.debug("Hello(A a) A-Para con");
		this.a = a;
	}

	public Hello(B b) {
		super();
		LOG.debug("Hello(B b) A-Para con");
		this.b = b;
	}*/
	public Hello(B b, A a) {
		super();
		LOG.debug("Hello 2Para con");
		this.a = a;
		this.b = b;
	}

	// @ConstructorProperties({"name","age"})
	public Hello(String name, String age) {
		super();
		LOG.debug("Hello 2Para con");
		this.name = name;
		this.age = age;
	}

	public void show() {
		LOG.info("Hello show()");
		System.out.println("a  :" + a.a);
		System.out.println("aName  :" + a.aName);
		System.out.println("b  :" + b.b);
		System.out.println("bName :" + b.bName);
	}

	public void showName() {
		LOG.info("Hello showName()");
		System.out.println("Name  :" + this.name);
		System.out.println("Age  :" + this.age);
	}
}
