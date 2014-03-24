package com.test.hibernate.persis;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student implements Serializable{
	
	private int sid;
	private String sname;
	
	private List<Address> add;

	public Student() {
		super();
	}


	public Student(String sname, List<Address> add) {
		super();
		this.sname = sname;
		this.add = add;
	}


	@Id
	@GeneratedValue
	@Column(name="Student_ID")
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
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//	@JoinTable(name="Student_Address",joinColumns=@JoinColumn(name="Student_ID"),inverseJoinColumns=@JoinColumn(name="Address_ID"))
	@JoinColumn(name="Student_ID")
	@OrderBy("street ASC")
	public List<Address> getAdd() {
		return add;
	}


	public void setAdd(List<Address> add) {
		this.add = add;
	}


	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", add=" + add
				+ "]";
	}



}
