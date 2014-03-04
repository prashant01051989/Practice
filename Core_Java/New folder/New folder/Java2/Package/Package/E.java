package com.test.pack2;
import com.test.pack1.A;
public class E extends A{
public void showE(){
System.out.println("E ShowE()");
System.out.println(a);
//1.	System.out.println(b);
System.out.println(c);
//System.out.println(d);
A a=new A();
System.out.println(a.a);
//1.	System.out.println(a.b);
//3.	System.out.println(a.c);
//2.	System.out.println(a.d);

}
}

/*
1.	Package3.java:9: b has private access in com.test.pack4.A
2.	C.java:9: d is not public in com.test.pack4.A; cannot be accessed from outside package
	System.out.println(d);	
3.	D.java:14: c has protected access in com.test.pack4.A
	System.out.println(a.c);
*/
