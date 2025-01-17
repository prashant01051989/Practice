package com.test.hibernate.persis;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("RS")
@Table(name="REGULARSTUDENT")
@PrimaryKeyJoinColumn(name="Percentage")
public class RegularStudent extends CurrentStudent {
	@Column(name = "Qualification")
	private String qualification;
	@Column(name = "Percentage",insertable=false,updatable=false)
	private String percentage;
	@Column(name = "YOE")
	private int yoe;

	public RegularStudent() {
		super();
	}

	public RegularStudent(String sname, String city, String status,
			float totalFee, double feeBal, String timing, String branch,
			String qualification, String percentage, int yoe) {
		super(sname, city, status, totalFee, feeBal, timing, branch);
		System.out.println(">>>>>>>>>>>>>RegularStudent<<<<<<<<<<<<<<<<<<<<<<");

		this.qualification = qualification;
		this.percentage = percentage;
		this.yoe = yoe;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public int getYoe() {
		return yoe;
	}

	public void setYoe(int yoe) {
		this.yoe = yoe;
	}

}
