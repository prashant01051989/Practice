class Hai{
int a=11;
static int b=12;

static {
System.out.println("Hai-SB");
System.out.println(b);
}
{
System.out.println("Hai-IB");
System.out.println(a);
System.out.println(b);

}
static void haiStatic(){
System.out.println("haiStatic()");
System.out.println(b);
}
void haiIns(){
System.out.println("haiIns()");
System.out.println(a);
System.out.println(b);
}
}

class Hello extends Hai{
int c=21;
static int d=22;
static {
System.out.println("Hello-SB");
System.out.println(d);

}
{
System.out.println("Hello-IB");
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
}
static void helloStatic(){
System.out.println("helloStatic()");
System.out.println(b);
//1. System.out.println(c);
System.out.println(d);
}
void helloIns(){
System.out.println("helloIns()");
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
}
}

class Inher2{
public static void main(String as[]){
/*Hai hai =new Hai();
Hai.haiStatic();
hai.haiStatic();
hai.haiIns();
System.out.println(hai.a);
System.out.println(Hai.b);
System.out.println(hai.b);*/
//2. System.out.println(Hai.d);

/*Hello hello=new Hello();
//Hello.helloStatic();
//hello.helloStatic();
//Hello.haiStatic();
//hello.haiStatic();
//hello.haiIns();
//hello.helloIns();
System.out.println(Hello.b);
System.out.println(Hello.d);
System.out.println(hello.a);
System.out.println(hello.c);*/

//3. Hello.d;



}

}

/*
1.	Inher2.java:44: non-static variable c cannot be referenced from a static
2.	Inher2.java:62: cannot find symbol
	symbol  : variable d
	location: class Hai
	System.out.println(Hai.d);
3.	Inher2.java:50: not a statement
	Hello.d;
*/