package com.test.spring.aop.advice;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import com.test.spring.aop.aspects.LogService;

public class MRAdvice implements AfterReturningAdvice {
	public static final Logger LOG = Logger.getLogger(MRAdvice.class);
	@Autowired
	LogService log = null;
	static {
		LOG.info("MRAdvice - Satic Block");
	}
	{
		LOG.info("MRAdvice - Instance Block");
	}

	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		LOG.info("MRAdvice...afterReturning(Object arg0, Method arg1, Object[] arg2,Object arg3)");
		log.logEnd();

	}
}
