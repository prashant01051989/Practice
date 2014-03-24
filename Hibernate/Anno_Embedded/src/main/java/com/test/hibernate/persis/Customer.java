package com.test.hibernate.persis;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {

	private int custId;
	private String custName;
	private String email;
	private Address custAdd;

	
	@Id
	@Column(name="Cust_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Embedded
	@AttributeOverrides({@AttributeOverride(name="street",column=@Column(name="Road")),
						@AttributeOverride(name="City",column=@Column(name="Sahar")),
						@AttributeOverride(name="state",column=@Column(name="province")),
						@AttributeOverride(name="zipcode",column=@Column(name="Postal_Code"))})
	
	public Address getCustAdd() {
		return custAdd;
	}

	public void setCustAdd(Address custAdd) {
		this.custAdd = custAdd;
	}

}
