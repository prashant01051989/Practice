class Hello{

static{
System.out.println("Hello static-begin");

//case1.	int a=10/0;
System.out.println("Hello static-end");
}
{
System.out.println("Hello ins-begin");
//2.	int a=10/0;
//3.	Hello h=new Hello();
System.out.println("Hello ins-end");
}
Hello(){
System.out.println("Hello con-begin");
//2.	int a=10/0;
System.out.println("Hello con-end");
}

int m1(String s){
try{
int x=Integer.parseInt(s);
int y=10/x;
System.out.println(y);
return y;
}/*5
finally{
System.out.println("finally2 begin");
}
*/
catch(NumberFormatException e){
System.out.println("catch begin");
System.out.println(e);
//System.exit(0);
System.out.println("catch end");

}
catch(Exception e){
System.out.println("catch begin");
System.out.println(e);
//System.exit(0);
System.out.println("catch end");
return 100;
}

finally{
System.out.println("finally begin");
System.out.println("Resource Cleanup can be done here-prefer me than finalize() method");
System.out.println("i am ok");
System.out.println("finally end");
return 200;
}
/*4.
System.out.println("i am not ok");
return 99;
*/
}
void m2(){
try{
int x=10/0;
}finally{
System.out.println("I am inside finally");
}
System.out.println("I am outside finally");
}
}

class Excep2{
public static void main(String as[]){
System.out.println("Main-Begin");
//case1.
//1. Hello h=new Hello();

Hello h=new Hello();
int s=h.m1(as[0]);
System.out.println(s);
/*
h.m2();
System.out.println(s);
*/
System.out.println("Main-End");
}
}

/*
1.	Main-Begin
	Hello static-begin
	Exception in thread "main" java.lang.ExceptionInInitializerError
        at Excep2.main(Excep2.java:46)
	Caused by: java.lang.ArithmeticException: / by zero
      
2.	Exception in thread "main" java.lang.ArithmeticException: / by zero
3.	Thrown when a circularity has been detected while initializing a class.
4.	Excep2.java:39: unreachable statement
	System.out.println("i am not ok");
5.	Excep2.java:32: 'catch' without 'try'
	catch(Exception e){

*/