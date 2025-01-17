package com.test.spring.aop.advice;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import com.test.spring.aop.aspects.LogService;
import com.test.spring.aop.aspects.SecurityService;

public class MBAdvice implements MethodBeforeAdvice {
	public static final Logger LOG = Logger.getLogger(MBAdvice.class);
	@Autowired
	private SecurityService security = null;
	@Autowired
	private LogService log = null;

	static {
		LOG.info("MBAdvice - Satic Block");
	}
	{
		LOG.info("MBAdvice - Instance Block");
	}

	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		LOG.info("MBAdvice...before(Method arg0, Object[] arg1, Object arg2)");
		log.logBegin();
		security.verifyUser();
	}

}
