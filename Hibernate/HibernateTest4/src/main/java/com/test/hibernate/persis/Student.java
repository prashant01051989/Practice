package com.test.hibernate.persis;

import java.util.List;

public class Student {
	private int sid;
	private String sname;
	private String city;
	private String status;
	private float totalFee;
	private List<String> emails;
	private List<Long>phones;

	public Student() {
		super();
	}

	public Student(String sname, String city, String status, float totalFee,
			List<String> emails, List<Long> phones) {
		super();
		this.sname = sname;
		this.city = city;
		this.status = status;
		this.totalFee = totalFee;
		this.emails = emails;
		this.phones = phones;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(float totalFee) {
		this.totalFee = totalFee;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public List<Long> getPhones() {
		return phones;
	}

	public void setPhones(List<Long> phones) {
		this.phones = phones;
	}

	

}
