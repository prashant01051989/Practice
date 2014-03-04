package com.test.pack2;
import com.test.pack1.A;
public class D{
public void showD(){
System.out.println("D ShowD()");
A a=new A();
System.out.println(a.a);
//1.	System.out.println(a.b);
//2.	System.out.println(a.c);
//3.	System.out.println(a.d);

}
}

/*
1.	Package3.java:9: b has private access in com.test.pack4.A
2.	C.java:9: c has protected access in com.test.pack4.A
	System.out.println(a.c);
3.	C.java:9: d is not public in com.test.pack4.A; cannot be accessed from outside package
	System.out.println(d);	
*/
