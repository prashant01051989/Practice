package com.test.hibernate.persis;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Student")
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
	
	@ManyToOne(cascade=CascadeType.ALL)
//case-1 @JoinColumn(name="Address_ID")
//case 2	@JoinTable(name="Student_Address",joinColumns=@JoinColumn(name="Student_ID"),inverseJoinColumns=@JoinColumn(name="Address_ID"))
	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", add=" + add
				+ "]";
	}



}
