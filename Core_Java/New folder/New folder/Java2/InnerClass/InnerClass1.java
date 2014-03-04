 class A{
 int a=20;
 private int b=30;
 A(){
	System.out.println("A def-con");
	}
	{
	System.out.println("A instance-block");
	}

	static{
	System.out.println("A static block");
	}
 class Ain{
	int x=200;
	final int y=300;
	//3.	static int z=400;
	Ain(){
	System.out.println("Ain def-con");
	}
	{
	System.out.println("Ain instance-con");
	}
	/*3
	static{
	System.out.println("Ain instance-con");
	}*/
	public void m1in(){
  System.out.println("Ain m1in()");
  System.out.println(x);
  System.out.println(y);
  }
  public void m2in(){
  System.out.println("Ain m2in()");
  System.out.println(a);
  System.out.println(b);
  }
 }
  public void m1(){
  System.out.println("A m1()");
  System.out.println(a);
  //2.	System.out.println(x);
  Ain ain=new Ain();
  System.out.println(ain.x);
  ain.m1in();
  ain.m2in();
  }
 }
 
class InnerClass1{
public static void main(String as[]){
 /*
 A a=new A();
 a.m1();
 */
//1.	 A.Ain ain=new A.Ain();
/*
A.Ain ain=new A().new Ain();
 ain.m1in();
 */
/*
A a=new A();
A.Ain ain=a.new Ain(); 
 ain.m1in();
 */
 /*
A a=new A();
 a.m1();
*/
 }
 }
 /*
 1.	InnerClass1.java:22: an enclosing instance that contains A.Ain is required
	A.Ain ain=new A.Ain();
 2.	InnerClass1.java:13: cannot find symbol
	symbol  : variable x
	location: class A
	System.out.println(x);
3.	InnerClass1.java:11: inner classes cannot have static declarations
        static{	
	
 */