interface I1{
public final static int a=10;
int b=20;
int c=30;
}
interface I2 extends I1{
public final static int a=100;
public void m1();
//3.	public static void m2();
public void m2();
}

interface I3{
public final static int x=1000;
int y=2000;
int z=3000;
}
interface I4{
public void m3();
}
interface I5 extends I3,I4{
public abstract void show();
public void m3();
}
class Hello implements I2,I5{
int z=5000;
public void m1(){
System.out.println("Hello m1()");
}
public void m2(){
System.out.println("Hello m2()");
}
public void m3(){
System.out.println("Hello m3()");
}
public  void show(){
System.out.println("Hello-show()");
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(z);
System.out.println(I1.a);
System.out.println(I1.b);
System.out.println(I1.c);
System.out.println(I2.a);
System.out.println(I2.b);
System.out.println(I2.c);

}
}

class Interface2{

public static void main(String as[]){
/*
Hello h=new Hello();
h.m1();
h.m2();
h.m3();
h.show();
*/
/*
I2 h=new Hello();
h.m1();
h.m2();
//1.	h.m3();
//1.	h.show();
System.out.println(h.a);
System.out.println(h.b);
System.out.println(h.c);
//2.	System.out.println(h.z);
*/

I5 h=new Hello();
//1.	h.m1();
//1.	h.m2();
h.m3();
h.show();
System.out.println(h.x);
System.out.println(h.y);
System.out.println(h.z);

}
}
/*
1.	Interface2.java:45: cannot find symbol
	symbol  : method m3()
	location: interface I2
	h.m3();	
2.	Interface2.java:69: cannot find symbol
	symbol  : variable z
	location: interface I2
	System.out.println(h.z);
3.	Interface2.java:9: modifier static not allowed here
	public static void m2();
        
*/