package com.test.hibernate.persis;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("OS")
@Table(name="OLDSTUDENT")
public class OldStudent extends Student {
	@Column(name = "Company")
	private String company;
	@Column(name = "cEmail")
	private String cemail;
	@Column(name = "CTC")
	private double ctc;

	public OldStudent() {
		super();
	}

	public OldStudent(String sname, String city, String status, float totalFee,
			String company, String cemail, double ctc) {
		super(sname, city, status, totalFee);
		System.out.println(">>>>>>>>>>>>>OldStudent<<<<<<<<<<<<<<<<<<<<<<");
		this.company = company;
		this.cemail = cemail;
		this.ctc = ctc;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public double getCtc() {
		return ctc;
	}

	public void setCtc(double ctc) {
		this.ctc = ctc;
	}

}
