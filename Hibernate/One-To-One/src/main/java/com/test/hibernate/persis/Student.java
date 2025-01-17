package com.test.hibernate.persis;

import java.io.Serializable;

public class Student implements Serializable{
	private int sid;
	private String sname;
	private Address add;

	public Student() {
		super();
	}

	public Student(String sname, Address add) {
		super();
		this.sname = sname;
		this.add = add;
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

	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}

}
