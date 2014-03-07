package com.test.hibernate.persis;

import java.util.List;

import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.MapKey;

@Entity
@Table(name="STUDENT")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SID")
	private int sid;
	@Column(name = "NAME")
	private String name;
	@Column(name = "LNAME")
	private String lname;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATUS")
	private String status;
	@CollectionOfElements
	@JoinTable(name = "EMAILS", joinColumns = @JoinColumn(name = "SID"))
	@Column(name = "EMAIL")
	private List<String> emails;
	@CollectionOfElements
	@JoinTable(name = "PHONES", joinColumns = @JoinColumn(name = "SID"))
	@IndexColumn(name="IDX",base=0)
	@Column(name = "PHONE")
	private Set<Long> phones;
	@CollectionOfElements
	@JoinTable(name = "REFS", joinColumns = @JoinColumn(name = "SID"))
	@MapKey(columns=@Column(name = "NAME"))
	@Column(name = "PHONE",columnDefinition="long")
	private Map<String, Long> refs;
	// private String[] courses;
	

	public Student() {
		super();
	}

	public Student(String name, String lname, String city, String status,
			List<String> emails, Set<Long> phones, Map<String, Long> refs) {
		super();
		this.name = name;
		this.lname = lname;
		this.city = city;
		this.status = status;
		this.emails = emails;
		this.phones = phones;
		this.refs = refs;
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


}