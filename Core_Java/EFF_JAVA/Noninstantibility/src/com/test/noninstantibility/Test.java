package com.test.noninstantibility;

import java.util.HashMap;

abstract class Student{
	private Student(){
	throw new AssertionError();	
	}
	 static void m1(){
		Student stu=new Student();
	}
}

/*class Employee extends Student{
	
}*/
public class Test {
	
public static void main(String[] args) {
	//Student stu=new Student();
	Student.m1();
	Map m=new HashMap();
}

	
	
}
