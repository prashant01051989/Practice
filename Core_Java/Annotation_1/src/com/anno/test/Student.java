package com.anno.test;

@Copyright("Copyright to Infinite Computer Solutions 2013")
class Person{
	@RequestForEnhancement(id=10,synopsis="Provide time-table ", date="12/24/2008",engineer="Engineer")
	public static void travelling(){
		
	}
}

public class Student {
public static void main(String[] args) {
	System.out.println(Person.class.getAnnotation(Copyright.class).value());
}
}
 
