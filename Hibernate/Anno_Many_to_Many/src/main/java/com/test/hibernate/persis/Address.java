package com.test.hibernate.persis;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private int addressId;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private Set<Student> stu;

	public Address() {
		super();
	}

	

	public Address(String street, String city, String state, String zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}


	@ManyToMany(mappedBy="add")
	public Set<Student> getStu() {
		return stu;
	}

	public void setStu(Set<Student> stu) {
		this.stu = stu;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Id
	@GeneratedValue
	@Column(name="Address_ID")
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street
				+ ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + "]";
	}
	

}
