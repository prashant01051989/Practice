
class A{
int a=101;
static int b=102;
final static int c=103;
static{
System.out.println("A-static");
}
{
System.out.println("A-Instance");
}

A(){
System.out.println("A defu-con");
}

}

class Hai extends A{
int a=201;
static int b=202;
final static int c=203;
static{
System.out.println("Hai-static");
}
{
System.out.println("Hai-Instance");
}
Hai(){
System.out.println("Hai def-con");
}

}

class Inher8{
public static void main(String as[]){

/*
A a=new A();
System.out.println(a.a);
System.out.println(a.b);
System.out.println(a.c);
*/

//System.out.println(A.b);
//System.out.println(A.c);

/*
A a=null;
//System.out.println(a.b);
System.out.println(a.c);
*/

/*Hai hai =new Hai();
System.out.println(hai.a);
System.out.println(hai.b);
System.out.println(hai.c);
*/
//System.out.println(Hai.b);
//System.out.println(Hai.c);

}
}

/*
1.	Exception in thread "main" java.lang.NullPointerException
2.	Inher7.java:59: <identifier> expected
	int static b=302;
*/