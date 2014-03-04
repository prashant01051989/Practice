package com.test.pack1;

public class BS{
public void showBS(){
System.out.println("BS ShowBS()");

System.out.println(AS.a);
//1.	System.out.println(AS.b);
System.out.println(AS.c);
System.out.println(AS.d);
}
}

/*
1.	BS.java:8: b has private access in com.test.pack6.AS
	System.out.println(AS.b);
	
*/

