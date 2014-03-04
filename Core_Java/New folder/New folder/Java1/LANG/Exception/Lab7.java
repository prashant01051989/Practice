import java.io.*;
import java.sql.*;

class AException extends IOException{}

class Hello{
void m1(int x)throws IOException,ArithmeticException{
if(x==1){
throw new ArithmeticException();
}else{
throw new ArithmeticException();
}
}
}

class Hai extends Hello{
/* OK
public void m1(int x){
System.out.println("Hai-m1");
}*/
/* OK
public void m1(int x)throws IOException,ArithmeticException{
System.out.println("Hai-m1");
}*/
/*OK
public void m1(int x)throws AException,ArithmeticException{
System.out.println("Hai-m1");
}*/
/* OK
public void m1(int x)throws Exception,ArithmeticException{
System.out.println("Hai-m1");
}*/
public void m1(int x)throws AException,ArithmeticException,SQLException{
System.out.println("Hai-m1");
}

}

class Lab7{
public static void main(String as[])throws IOException,ArithmeticException{
System.out.println("BEGINING");
Hello h=new Hello();
h.m1(1);
System.out.println("END");
}
}