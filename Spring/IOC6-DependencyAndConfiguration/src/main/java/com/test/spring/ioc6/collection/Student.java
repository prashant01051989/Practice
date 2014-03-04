package com.test.spring.ioc6.collection;

import java.util.List;
import java.util.Set;

public abstract class Student {

	public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	public Set<Long> getPhones() {
		return phones;
	}
	public void setPhones(Set<Long> phones) {
		this.phones = phones;
	}
	public int getSid() {
		return sid;
	}
	int sid;
	List<String> cities ;
	Set<Long> phones;
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	
	
	
}
