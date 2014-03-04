 interface I{}
 class A{
 int a=20;
 private int b=30;
 
 final class Ain{
  public void m2in(){
  System.out.println("Ain m2in()");
  }
 }
 private class Ain1{
  public void m2in(){
  System.out.println("Ain1 m2in()");
  }
 }
 interface  AIin{
  public void m2in();
  }
  
 protected  class Ain3 implements AIin{
  public void m2in(){
  System.out.println("Ain3 m2in()");
  }
 }
  
 }
 
class InnerClass2{
public static void main(String as[]){
 
A a=new A();
A.AIin ain=new A().new Ain3();
ain.m2in();
 }
 }
 /*
 1.	
 */