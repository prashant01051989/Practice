/*default constructor  checks at compile time*/
class A{
int a;
static int b=102;
static{
System.out.println("A-static");
}
{
System.out.println("A-Instance");
}

A(){
System.out.println("A defu-con");
}
A (int a){
System.out.println("A 1-arg-con");
this.a=a;
System.out.println(this.a);
}
void aIns(){
//3. this();
System.out.println("aIns()");
System.out.println(a);
System.out.println(b);
}
}

class Hai extends A{
int a;
int b=202;

static{
System.out.println("Hai-static");
}
{
System.out.println("Hai-Instance");
}
Hai(){
System.out.println("Hai def-con");
}
Hai(int a){
super(101);
System.out.println("Hai 1 arg-con");
this.a=a;

}
void mhai(){
System.out.println("mhai()");
System.out.println(a);
System.out.println(b);
System.out.println(this.a);
System.out.println(this.b);
System.out.println(super.a);
System.out.println(super.b);
}
}

class Hello extends Hai{
int a;
//2. int static b=302;
static int  b=302;

static{
System.out.println("Hello-static");
}
{
System.out.println("Hello-Instance");
}
Hello(){
this(301);
System.out.println("Hello def-con");
}
Hello(int a){
super(201);
System.out.println("Hello 1-arg-con");
System.out.println(a);
this.a=a;


}
void helloIns(){
System.out.println("helloIns()");
System.out.println(a);
System.out.println(b);
System.out.println(this.a);
System.out.println(this.b);
System.out.println(super.a);
System.out.println(super.b);
}
}

class Inher7{
public static void main(String as[]){

A a=new A();
a.aIns();

/*
A a=new A(101);
a.aIns();
*/
/*
A a=null;
System.out.println(a.b);
*/
/*
Hai hai =new Hai();
hai.mhai();
*/
/*
Hai hai =new Hai(201);
//hai.mhai();
System.out.println(hai.b);//When instance and static variable of super class  have same name then through reference variable instance variable of sub class will be call; 
*/

/*1. 
Hai hai =null;
System.out.println(hai.b);
*/

/*
Hello hello =new Hello(301);
hello.helloIns();
*/
/*
Hello hello =new Hello();
hello.helloIns();
*/

Hello hello =null;
System.out.println(hello.b);
}
}

/*
1.	Exception in thread "main" java.lang.NullPointerException
2.	Inher7.java:59: <identifier> expected
	int static b=302;
3.	Inher7.java:21: call to this must be first statement in constructor
	this();
*/