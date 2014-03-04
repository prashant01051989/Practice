class Hello{
public void m1(){
System.out.println("Hello-m1()");
try{
//throw new RuntimeException(); 
throw new Exception("");
}
catch(RuntimeException e){
e.printStackTrace();
}
catch(Error e){
e.printStackTrace();
}
catch(Exception e){
e.printStackTrace();
}

/*OK
catch(Throwable e){
e.printStackTrace();
}
*/
/*1. Not OK
catch(Object e){
e.printStackTrace();
}
*/
m2();
/*
try{
m2();
}catch(Exception e){
e.printStackTrace();
}
*/
}
void m2()throws ArithmeticException{
System.out.println("Hello-m2()");
try{
throw new ArithmeticException();
}catch(ArithmeticException e){
	e.printStackTrace();
	throw new ArithmeticException("Hi How R U?");
}
}
void m3(){
System.out.println("Hello-m2()");
}
}
class Hai extends Hello{
/*
public void m1()throws Error{
}
public void m2()throws Exception{
}
public void m3(){
}
*/
}
class Excep5{
public static void main(String sa[]){
Hello h=new Hello();
try{
h.m1();
}catch( Exception e){
e.printStackTrace();
}
}
}
/*
1.	Excep5.java:25: incompatible types
	found   : java.lang.Object
	required: java.lang.Throwable
	catch(Object e){
      
	Excep5.java:26: cannot find symbol
	symbol  : method printStackTrace()
	location: class java.lang.Object
	e.printStackTrace();
 
*/