package com.test.spring.ioc6;

import org.apache.log4j.Logger;

public class Hello {
	private static final Logger LOG = Logger.getLogger(Hello.class);

	String aName = null;
	String bName = null;
	A aObj = null;
	B bObj = null;

	static {
		LOG.info("Hello static block");
	}
	{
		LOG.info("Hello instance block");
	}

	public Hello() {
		LOG.info("Hello def con");
	}

	public void setaName(String aName) {
		LOG.info("Hello setaName");
		this.aName = aName;
	}

	public void setbName(String bName) {
		LOG.info("Hello setbName");
		this.bName = bName;
	}

	public void setaObj(A aObj) {
		LOG.info("Hello setaObj");
		this.aObj = aObj;
	}

	public void setbObj(B bObj) {
		LOG.info("Hello setbObj");
		this.bObj = bObj;
	}

	public void show() {
		LOG.info("Hello show()");
		System.out.println("aName  :" + this.aName);
		System.out.println("bName :" + this.bName);
		System.out.println("a  :" +this.aObj.a);
		System.out.println("aName  :" + this.aObj.aName);
		System.out.println("b  :" + this.bObj.b);
		System.out.println("bName :" + this.bObj.bName);
	}
}
