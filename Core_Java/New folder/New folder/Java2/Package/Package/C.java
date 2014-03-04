package com.test.pack1;

public class C extends A{
public void showC(){
System.out.println("C ShowC()");
System.out.println(a);
//System.out.println(b);
System.out.println(c);
System.out.println(d);
A a=new A();
System.out.println(a.a);
//1.	System.out.println(a.b);
System.out.println(a.c);
System.out.println(a.d);
}
}

/*
1.	C.java:7: b has private access in com.test.pack1.A
	System.out.println(b);	
*/
