package com.test.hibernate.persis;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Student implements Serializable{
	private int sid;
	private String sname;
	private Set<Address> add=new HashSet<Address>();
	
	public Student() {
		super();
	}

	public Student(String sname, Set<Address> add) {
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

	
	public Set<Address> getAdd() {
		return add;
	}

	public void setAdd(Set<Address> add) {
		this.add = add;
	}
}
