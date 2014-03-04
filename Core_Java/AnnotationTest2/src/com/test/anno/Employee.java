package com.test.anno;

public class Employee {
	@Data("Prashant")
private String name;
	@Data("1012602l")	
private String id;
	@Data("8892863018l")
private String phone;






public String toString(){
	return name+"\t"+id+"\t"+phone;
}

}
