package com.test.hibernate.persis;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("WS")
@Table(name="WEEKENDSTUDENT")
public class WeekendStudent extends CurrentStudent {
	@Column(name = "Company")
	private String company;
	@Column(name = "CEmail")
	private String cemail;
	@Column(name = "CTC")
	private double ctc;

	public WeekendStudent() {
		super();
	}

	public WeekendStudent(String sname, String city, String status,
			float totalFee, double feeBal, String timing, String branch,
			String company, String cemail, double ctc) {
		super(sname, city, status, totalFee, feeBal, timing, branch);
		System.out.println(">>>>>>>>>>>>>WeekendStudent<<<<<<<<<<<<<<<<<<<<<<");

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
