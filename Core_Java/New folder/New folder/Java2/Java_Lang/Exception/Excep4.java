import java.io.*;
import java.sql.*;
class Hello{
static //1. throws Exception
{
System.out.println("Hello static-begin");
//	int a=10/0;
System.out.println("Hello static-end");
}
{
System.out.println("Hello ins-begin");
//	int a=10/0;
System.out.println("Hello ins-end");
}
void m1(int x) throws ArithmeticException,IndexOutOfBoundsException{
System.out.println("Hello-m1-start");
if(x==1){
throw new ArithmeticException();
}
else{
throw new IndexOutOfBoundsException();
}

}
}

class Hai extends Hello{
/* OK
public void m1(int x){
System.out.println("Hai-m1-start");
}
*/
/*OK
public void m1(int x)throws ArithmeticException,IndexOutOfBoundsException{
System.out.println("Hai-m1-start");
}
*/
/*NOT OK
public void m1(int x)throws Exception,IOException{
System.out.println("Hai-m1-start");
}
*/
/*
public void m1(int x)throws SQLException{
System.out.println("Hai-m1-start");
}
*/
}

class Excep4{
public static void main(String as[]){
System.out.println("Main-Begin");
try{
Hello h=new Hello();
h.m1(1);
}catch(Exception e){
e.printStackTrace();
}
System.out.println("Main-End");
}
}
/*
1.	Excep4.java:4: illegal start of type
	static throws Exception{
1.	Excep4.java:26: m1(int) in Hai cannot override m1(int) in Hello; overridden method does not throw java.lang.Exception
	public void m1(int x)throws Exception,IOException{
2.	Excep4.java:32: m1(int) in Hai cannot override m1(int) in Hello; overridden method does not throw java.sql.SQLException
	public void m1(int x)throws SQLException{
    
*/