package com.test.pack2;
import com.test.pack1.AS;
public class ES extends AS{
public void showES(){
System.out.println("ES ShowES()");
System.out.println(a);
//1.	System.out.println(b);
System.out.println(c);
//2.	System.out.println(d);

System.out.println(AS.a);
//1.	System.out.println(AS.b);
System.out.println(AS.c);
//2.	System.out.println(AS.d);
}
}

/*
1.	ES.java:7: b has private access in com.test.pack1.AS
	System.out.println(b);
2.	ES.java:9: d is not public in com.test.pack1.AS; cannot be accessed from outside package
	System.out.println(d);

*/
