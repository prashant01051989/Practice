package prashant.java.p1;
public class C extends A1{
int b=11;
int c=22;
int d=33;

public void showA(){
 System.out.println("ShowA-C");
 A obj=new A();
 //System.out.println(obj.a);
 System.out.println(b);
 System.out.println(c);
 System.out.println(d);
 }
public void showA1(){
 System.out.println("ShowA-A1");
 //System.out.println(a);
 System.out.println(b);
 System.out.println(c);
 System.out.println(d);
 super.showA1();
 }
 }