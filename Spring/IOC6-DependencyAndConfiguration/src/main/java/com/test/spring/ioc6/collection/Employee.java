package com.test.spring.ioc6.collection;

import java.util.List;

public  class Employee extends Student{

	public List<String> getCompanies() {
		return companies;
	}

	public void setCompanies(List<String> companies) {
		this.companies = companies;
	}

	List <String> companies;
	
	
	
	
	
}
