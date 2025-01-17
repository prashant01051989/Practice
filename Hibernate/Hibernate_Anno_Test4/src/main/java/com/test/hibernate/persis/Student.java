package com.test.hibernate.persis;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name="STUDENT")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
/*@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Student", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("S")*/
//@Inheritance(strategy=InheritanceType.JOINED)
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "SID")
	private int sid;
	@Column(name = "SNAME")
	private String sname;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "totalFee")
	private float totalFee;

	public Student() {
		super();
	}

	public Student(String sname, String city, String status, float totalFee) {
		super();
		this.sname = sname;
		this.city = city;
		this.status = status;
		this.totalFee = totalFee;

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

}
