interface I{
public final static int a=10;
int b=20;
public void m1();
public abstract void show();
}

class Hello implements I{
public void m1(){
System.out.println("Hello m1()");
System.out.println(a);
}
public void m2(){
System.out.println("Hello m2()");
System.out.println(a);
}
/*2.
public abstract void show(){
System.out.println("Hello-show()");
}
*/
public  void show(){
System.out.println("Hello-show()");
}
}

class Interface1{

public static void main(String as[]){
/*
System.out.println(Hello.a);
System.out.println(Hello.b);
System.out.println(I.a);
System.out.println(I.b);
*/
/*
Hello h=new Hello();
h.m1(); 
h.m2();
h.show();
*/
I h=new Hello();
h.m1(); 
h.show(); 
//1.	h.m2();
}
}
/*
1.	Interface1.java:33: cannot find symbol
	symbol  : method m2()
	location: interface I
	h.m2();
2.	Interface1.java:8: Hello is not abstract and does not override abstract method show() in Hello
	class Hello implements I{

	Interface1.java:17: abstract methods cannot have a body
	public abstract void show(){
        
*/