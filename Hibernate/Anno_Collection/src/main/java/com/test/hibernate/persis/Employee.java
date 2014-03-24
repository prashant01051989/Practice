package com.test.hibernate.persis;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "NAME")
	private String name;
	private long salary;
	@Embedded
	private Address empAdd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Address getEmpAdd() {
		return empAdd;
	}

	public void setEmpAdd(Address empAdd) {
		this.empAdd = empAdd;
	}

	

}
