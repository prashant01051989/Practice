package com.test.spring.aop.services;

import org.apache.log4j.Logger;

public class HelloServiceImpl implements HelloService {

	public static final Logger LOG = Logger.getLogger(HelloServiceImpl.class);
	static {
		LOG.info("HelloServiceImpl - Satic Block");
	}
	{
		LOG.info("HelloServiceImpl - Instance Block");
	}

	public void helloM1() {
		LOG.info("hello - helloM1()");
	}

	public void helloM2() throws Exception {
		LOG.info("hello - helloM2()");
		if(1==1)
			throw new Exception();
		LOG.info("hello - helloM2() end");

	}

	public void helloAm1() {
		LOG.info("hello - helloAm1()");
		
	}

	public void helloAm2() throws Exception {
		LOG.info("hello - helloAm2()");
		if(1==1)
			throw new Exception();
		LOG.info("hello - helloAm2() end");
		
	}

}
