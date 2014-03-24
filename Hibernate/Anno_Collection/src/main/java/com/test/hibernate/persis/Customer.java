package com.test.hibernate.persis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
@Access(AccessType.PROPERTY)
public class Customer {

	private int custId;
	private Set<String> custNames;
	private List<Address> custAdds;
	private String email;
	private Map<PhoneType, String> phones;
	

	@Id
	@Column(name = "Cust_ID")
	@GeneratedValue
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	@ElementCollection
	@CollectionTable(name = "Name", joinColumns = @JoinColumn(name = "Cust_ID"))
	public Set<String> getCustNames() {
		return custNames;
	}

	public void setCustNames(Set<String> custNames) {
		this.custNames = custNames;
	}

	@Embedded
	@ElementCollection
	@OrderBy("street ASC")
	@CollectionTable(name = "Address", joinColumns = { @JoinColumn(name = "Cust_ID") })
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "Road")),
			@AttributeOverride(name = "City", column = @Column(name = "Sahar")),
			@AttributeOverride(name = "state", column = @Column(name = "province")),
			@AttributeOverride(name = "zipcode", column = @Column(name = "Postal_Code")) })
	public List<Address> getCustAdds() {
		return custAdds;
	}

	public void setCustAdds(List<Address> custAdds) {
		this.custAdds = custAdds;
	}

	@ElementCollection
	@CollectionTable(name = "CUST_PHONE", joinColumns={@JoinColumn(name="Cust_ID")})
	@MapKeyEnumerated(EnumType.STRING)
	@MapKeyColumn(name = "PHONE_TYPE")
	@Column(name = "PHONE_NUM")
	public Map<PhoneType, String> getPhones() {
		return phones;
	}

	public void setPhones(Map<PhoneType, String> phones) {
		this.phones = phones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
