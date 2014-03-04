package prashant.java.p1;

public class A{
private int a=10;
public int b=20;
int c=30;
protected int d=40;
public void showA(){
 System.out.println("ShowA-A");
 System.out.println(a);
 System.out.println(b);
 System.out.println(c);
 System.out.println(d);
 }
}
 class A1 extends A{
 public void showA1(){
 System.out.println("ShowA-A1");
 //System.out.println(a);
 System.out.println(b);
 System.out.println(c);
 System.out.println(d);
 }
}