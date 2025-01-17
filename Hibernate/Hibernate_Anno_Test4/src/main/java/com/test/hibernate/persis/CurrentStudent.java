package com.test.hibernate.persis;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("CS")
@Table(name="CURRENTSTUDENT")
public class CurrentStudent extends Student {
	@Column(name = "Fee_Bal")
	private double feeBal;
	@Column(name = "Timing")
	private String timing;
	@Column(name = "Branch")
	private String branch;

	public CurrentStudent() {
		super();
	}

	public CurrentStudent(String sname, String city, String status,
			float totalFee, double feeBal, String timing, String branch) {
		super(sname, city, status, totalFee);
		System.out.println(">>>>>>>>>>>>>CurrnetClass<<<<<<<<<<<<<<<<<<<<<<");
		this.feeBal = feeBal;
		this.timing = timing;
		this.branch = branch;
	}

	public double getFeeBal() {
		return feeBal;
	}

	public void setFeeBal(double feeBal) {
		this.feeBal = feeBal;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

}
