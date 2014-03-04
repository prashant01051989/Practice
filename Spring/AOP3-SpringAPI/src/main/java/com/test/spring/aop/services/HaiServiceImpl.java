package com.test.spring.aop.services;

import org.apache.log4j.Logger;

public class HaiServiceImpl implements HaiService {
	public static final Logger LOG = Logger.getLogger(HaiServiceImpl.class);
	static {
		LOG.info("HaiServiceImpl - Satic Block");
	}
	{
		LOG.info("HaiServiceImpl - Instance Block");
	}

	public void haiM1() {
		LOG.info("hai  haiM1()");

	}

	public void haiM2() {
		LOG.info("hai  haiM2()");
		
	}

	public void haiAm1() {
		LOG.info("hai  haiAm1()");
		
	}

	public void haiAm2() {
		LOG.info("hai  haiAm2()");
		
	}

	public void test1() {
		LOG.info("hai  test1()");
		
	}

}
