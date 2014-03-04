package com.test.spring.aop.aspects;

import org.apache.log4j.Logger;

public class SecurityService {
	public static final Logger LOG = Logger.getLogger(SecurityService.class);
	static {
		LOG.info("SecurityService - Satic Block");
	}
	{
		LOG.info("SecurityService - Instance Block");
	}

	public void verifyUser() {
		LOG.info("SecurityService...VerifyUser()...");
	}
}
