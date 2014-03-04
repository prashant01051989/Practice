package com.test.pack1;

public class B{
public void showB(){
System.out.println("B ShowB()");

A a=new A();
System.out.println(a.a);
//1.	System.out.println(a.b);
System.out.println(a.c);
System.out.println(a.d);
}
}

/*
1.	B.java:9: b has private access in com.test.pack1.A
System.out.println(a.b);
	
*/

