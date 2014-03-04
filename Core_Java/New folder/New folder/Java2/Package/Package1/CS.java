package com.test.pack1;

public class CS extends AS{
public void showCS(){
System.out.println("CS ShowCS()");
System.out.println(a);
//1.	System.out.println(b);
System.out.println(c);
System.out.println(d);
System.out.println(AS.a);
//1.	System.out.println(AS.b);
System.out.println(AS.c);
System.out.println(AS.d);

}
}

/*
1.	CS.java:7: b has private access in com.test.pack1.AS
	System.out.println(b);

*/
