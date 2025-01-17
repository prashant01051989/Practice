package com.test.spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.test.spring.aop.aspects.LogService;
import com.test.spring.aop.aspects.SecurityService;

public class MIAdvice implements MethodInterceptor {
	public static final Logger LOG = Logger.getLogger(MIAdvice.class);
	@Autowired
	private LogService log = null;
	@Autowired
	private SecurityService security = null;
	static {
		LOG.info("MIAdvice - Satic Block");
	}
	{
		LOG.info("MIAdvice - Instance Block");
	}

	public Object invoke(MethodInvocation mi) throws Throwable {
		LOG.info("MIAdvice - invoke(MethodInvocation mi)");
		log.logBegin();
		security.verifyUser();
		Object obj = mi.proceed();
		log.logEnd();
		return obj;
	}

}
