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

}
