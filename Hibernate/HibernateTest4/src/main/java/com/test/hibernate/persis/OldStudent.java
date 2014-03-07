package com.test.hibernate.persis;

import java.util.List;

public class OldStudent extends Student{
private String company;
private String cemail;
private double ctc;
public OldStudent() {
	super();
}

public OldStudent(String sname, String city, String status, float totalFee,
		List<String> emails, List<Long> phones, String company, String cemail,
		double ctc) {
	super(sname, city, status, totalFee, emails, phones);
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
