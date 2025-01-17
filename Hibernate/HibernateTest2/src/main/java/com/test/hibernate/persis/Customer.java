package com.test.hibernate.persis;

import org.apache.log4j.Logger;

public class Customer {
	private static final Logger LOG = Logger.getLogger(Customer.class);
	private int cid;
	private String cname;
	private String email;
	private String city;
	private String status;
	private long phone;

	public Customer() {
		LOG.info("Customer 0 arg cons");
	}

	public Customer(String cname, String email, String city, String status,
			long phone) {
		super();
		LOG.info("Customer  arg cons");

		this.cname = cname;
		this.email = email;
		this.city = city;
		this.status = status;
		this.phone = phone;
	}

	public int getCid() {
		LOG.info("getCid "+cid);
		return cid;
	}

	public void setCid(int cid) {
		LOG.info("setCid");
		this.cid = cid;
	}

	public String getCname() {
		LOG.info("getCname");
		return cname;
	}

	public void setCname(String cname) {
		LOG.info("setCname");
		this.cname = cname;
	}

	public String getEmail() {
		LOG.info("getEmail");
		return email;
	}

	public void setEmail(String email) {
		LOG.info("setEmail");
		this.email = email;
	}

	public String getCity() {
		LOG.info("getCity");
		return city;
	}

	public void setCity(String city) {
		LOG.info("setCity");
		this.city = city;
	}

	public String getStatus() {
		LOG.info("getStatus");
		return status;
	}

	public void setStatus(String status) {
		LOG.info("setStatus");
		this.status = status;
	}

	public long getPhone() {
		LOG.info("getPhone");
		return phone;
	}

	public void setPhone(long phone) {
		LOG.info("setPhone");
		this.phone = phone;
	}

}
