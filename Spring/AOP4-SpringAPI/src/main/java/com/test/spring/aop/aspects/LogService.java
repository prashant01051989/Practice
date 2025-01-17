package com.test.spring.aop.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogService {
	public static final Logger LOG = Logger.getLogger(LogService.class);
	static {
		LOG.info("LogService - Satic Block");
	}
	{
		LOG.info("LogService - Instance Block");
	}

	@Pointcut(value = "execution(* com.test.spring.aop.services.HelloServiceImpl.helloM1(..))")
	public void begin() {}

	public void end() {}

	public void throwing() {}

	@Before("begin()")
	public void logBegin() {
		LOG.info("LogService...logBegin.()..");
	}

	@AfterReturning("begin()")
	public void logEnd() {
		LOG.info("LogService...logEnd.()...");
	}

	@AfterThrowing("begin()")
	public void logException() {
		LOG.info("LogService...logException.()..");
	}

}
