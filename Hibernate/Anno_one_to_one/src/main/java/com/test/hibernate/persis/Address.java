package com.test.hibernate.persis;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address implements Serializable{
	
	
	//private int addressId;
	private AddressPK apk;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	//private Student stu;

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



/*@OneToOne(mappedBy = "add")
	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}
*/


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
	public AddressPK getApk() {
		return apk;
	}



	public void setApk(AddressPK apk) {
		this.apk = apk;
	}
	

/*	@Id
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
	}*/
	

}
