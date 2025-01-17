package com.test.hibernate.persis;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
	private int sid;
	private String name;
	private String lname;
	private String city;
	private String status;
	private List<String> emails;
	private Set<Long> phones;
	private Map<String, Long> refs;
	private String[] courses;
	private List<Integer> marks;

	public Student() {
		super();
	}

	public Student(String name, String lname, String city, String status,
			List<String> emails, Set<Long> phones, Map<String, Long> refs,
			String[] courses, List<Integer> marks) {
		super();
		this.name = name;
		this.lname = lname;
		this.city = city;
		this.status = status;
		this.emails = emails;
		this.phones = phones;
		this.refs = refs;
		this.courses = courses;
		this.marks = marks;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public Set<Long> getPhones() {
		return phones;
	}

	public void setPhones(Set<Long> phones) {
		this.phones = phones;
	}

	public Map<String, Long> getRefs() {
		return refs;
	}

	public void setRefs(Map<String, Long> refs) {
		this.refs = refs;
	}

	public String[] getCourses() {
		return courses;
	}

	public void setCourses(String[] courses) {
		this.courses = courses;
	}

	public List<Integer> getMarks() {
		return marks;
	}

	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}

}
