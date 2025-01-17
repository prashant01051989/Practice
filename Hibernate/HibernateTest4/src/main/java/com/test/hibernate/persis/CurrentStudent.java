package com.test.hibernate.persis;

import java.util.List;

public class CurrentStudent extends Student{
private double feeBal;
private String timing;
private String branch;
public CurrentStudent() {
	super();
}

public CurrentStudent(String sname, String city, String status, float totalFee,
		List<String> emails, List<Long> phones, double feeBal, String timing,
		String branch) {
	super(sname, city, status, totalFee, emails, phones);
	this.feeBal = feeBal;
	this.timing = timing;
	this.branch = branch;
}

public double getFeeBal() {
	return feeBal;
}
public void setFeeBal(double feeBal) {
	this.feeBal = feeBal;
}
public String getTiming() {
	return timing;
}
public void setTiming(String timing) {
	this.timing = timing;
}
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}

}
