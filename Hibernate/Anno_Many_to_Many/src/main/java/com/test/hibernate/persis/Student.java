package com.test.hibernate.persis;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "Student")
@TableGenerator(name="STU_GEN",table="ID_GEN",pkColumnName="GEN_NAME",valueColumnName="GEN_VAL",pkColumnValue="STU_GEN",initialValue=1000,allocationSize=150)
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sid;
	private String sname;

//	private Set<Address> add;

	public Student() {
		super();
	}

	/*public Student(String sname, Set<Address> add) {
		super();
		this.sname = sname;
		this.add = add;
	}
*/
	@Id
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "Student_ID")
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	/*@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Address", joinColumns = @JoinColumn(name = "Student_ID"), inverseJoinColumns = @JoinColumn(name = "Address_ID"))
	public Set<Address> getAdd() {
		return add;
	}

	public void setAdd(Set<Address> add) {
		this.add = add;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", add=" + add
				+ "]";
	}
*/
}
