package com.test.spring.aop.advice;

import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.spring.aop.aspects.LogService;

public class MTAdvice implements ThrowsAdvice {
	public static final Logger LOG = Logger.getLogger(MTAdvice.class);
	@Autowired
	LogService log = null;
	static {
		LOG.info("MTAdvice - Satic Block");
	}
	{
		LOG.info("MTAdvice - Instance Block");
	}

	public void afterThrowing(Exception e) throws Throwable {
		LOG.info("MRAdvice...afterThrowing(Exception e");
		log.logException();
	}
}
