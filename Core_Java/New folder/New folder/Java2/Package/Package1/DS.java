package com.test.pack2;
import com.test.pack1.AS; 
public class DS{
public void showDS(){
System.out.println("DS ShowDS()");

System.out.println(AS.a);
//1.	System.out.println(AS.b);
//2.	System.out.println(AS.c);
//3.	System.out.println(AS.d);
AS a=new AS();
a.showAS();
}
}

/*
1.	DS.java:8: b has private access in com.test.pack1.AS
	System.out.println(AS.b);
2.	DS.java:10: d is not public in com.test.pack1.AS; cannot be accessed from outside package
	System.out.println(AS.d);
3.	DS.java:10: d is not public in com.test.pack1.AS; cannot be accessed from outside package
	System.out.println(AS.d);
*/

