package com.test.spring.ioc16;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

public class Hello {
	private static final Logger LOG = Logger.getLogger(Hello.class);

	// @Autowired
	// @Autowired(required = false)
	// @Qualifier(value="aObj")
	@Resource
	private A a = null;
	// @Autowired
	// @Autowired(required = false)
	// @Qualifier(value="main")
	@Resource
	private B b = null;
	/*
	 * @Resource private List<Hello> hello1;
	 */
	static {
		LOG.info("Hello static block");
	}
	{
		LOG.info("Hello instance block");
	}

	public Hello() {
		LOG.debug("Hello def con");
	}

	/*
	 * //@Autowired -- Only one annotated constructor per-class can be marked as
	 * required, but multiple non-required constructors can be annotated.
	 */
	// @Autowired(required=false)
	public Hello(A a) {
		super();
		LOG.debug("Hello(A a) def con");
		this.a = a;
	}

	// @Autowired(required=false)
	public Hello(B b) {
		super();
		LOG.debug("Hello(B b) def con");
		this.b = b;
	}

	// @Autowired(required=false)
	public Hello(A a, B b) {
		super();
		LOG.debug("Hello(A a, B b) def con");
		this.a = a;
		this.b = b;
	}

	// @Autowired
	public void setA(A a) {
		LOG.info("Hello setA(A a)");
		this.a = a;
	}

	// @Autowired
	public void setB(B b) {
		LOG.info("Hello setB(B b)");
		this.b = b;
	}

	// @Autowired
	public void initialization(A a, B b) {
		LOG.info("Hello initialization(A a,B b)");
		this.a = a;
		this.b = b;
	}

	public void show() {
		LOG.info("Hello show()");
		System.out.println("a  :" + this.a.a);
		System.out.println("aName  :" + this.a.aName);
		System.out.println("b  :" + this.b.b);
		System.out.println("bName :" + this.b.bName);
	}
}
