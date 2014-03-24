package com.anno.test;



public class Employee {

@Value(value="123")
private String id;
@Value(value="Prashant")
private String name;
@Value(value="9835620288")
private String phone;

@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + "]";
}


 
}
