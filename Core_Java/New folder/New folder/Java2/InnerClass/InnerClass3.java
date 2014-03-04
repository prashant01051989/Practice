 class A{
 int a=20;
 static  int b=30;
 Ain ain=new Ain();
 A(){
	System.out.println("An def-con");
	}
	{
	System.out.println("A instance-block");
	}

	static{
	System.out.println("A static block");
	}
 static class Ain{
	int x=200;
	static int y=400;
	Ain(){
	System.out.println("Ain def-con");
	}
	{
	System.out.println("Ain instance-block");
	}

	static{
	System.out.println("Ain static block");
	}
	public void m1in(){
	System.out.println("Ain m1in()");
	System.out.println(x);
	}
	static public void m2in(){
	System.out.println("Ain m2in()");
	System.out.println(y);
	}
	public void m3in(){
	System.out.println("Ain m3in()");
	//2.	System.out.println(a);
	}
 }
  public void m1(){
  System.out.println("A m1()");
  System.out.println(a);
  Ain ain1=new Ain();
  System.out.println(ain1.x);
  ain1.m1in();
  System.out.println(Ain.y);
  Ain.m2in();
  }
 }
 
class InnerClass3{
public static void main(String as[]){
 /*
 A a=new A();
 a.m1();
 */
/* 
A.Ain ain=new A.Ain();// Only inner class static block will execute not outer class static block will execute
ain.m1in();
*/

//1.	A.Ain ain=new A().new Ain();



/*1.
A a=new A();
A.Ain ain=a.new Ain(); 
*/
A a=new A();
a.m1();

}
}
 /*
 1.	InnerClass3.java:54: qualified new of static class
	A.Ain ain=new A().new Ain();
 2.	InnerClass3.java:37: non-static variable a cannot be referenced from a static context
        System.out.println(a);
  
 */