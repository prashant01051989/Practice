package com.test.anno;

public class Student {

	@Insert("Prashant")
	private String name;
	@Insert("123456789")
	private String phone;
	@Insert("Bangalore")
	private String city;
	@Insert("DAV")
	private String school;
	public Student(){
		System.out.println("Stu con");
		
	}
	public String toString(){
		return name+"\t"+phone+"\t"+city+"\t"+school;
	}

}
