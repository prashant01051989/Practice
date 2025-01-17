package com.test.spring.aop.aspects;

import org.apache.log4j.Logger;

public class LogService {
	public static final Logger LOG = Logger.getLogger(LogService.class);
	static {
		LOG.info("LogService - Satic Block");
	}
	{
		LOG.info("LogService - Instance Block");
	}

	public void logBegin() {
		LOG.info("LogService...logBegin.()..");
	}

	public void logEnd() {
		LOG.info("LogService...logEnd.()...");
	}

	public void logException() {
		LOG.info("LogService...logException.()..");
	}

}
