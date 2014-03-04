class InnerClass4{
public static void main(String as[]){
A a=new A();
a.m1();
}
}

class A{
int a=20;
static int b=30;
//1.	M2inn m2=new M2inn();
 A(){
	System.out.println("A def-con");
	}
	{
	System.out.println("A instance-block");
	}
static{
	System.out.println("A static block");
	}
void m2(){
System.out.println("A-m2()");
int x=200;
final int y=300;	
System.out.println(a);
System.out.println(b);
System.out.println(x);
System.out.println(y);
//1.	M2inn m2=new M2inn();

class M2inn{
	int x1=200;
	final int y1=300;
	M2inn(){
	System.out.println("M2inn def-con");
	}
	{
	System.out.println("M2inn instance-con");
	}
	
 public void show(){
  System.out.println("M2inn show()");
  System.out.println(a);
  System.out.println(b);
  //2. System.out.println(x);
  System.out.println(y);
  System.out.println(x1);
  System.out.println(y1);
  }
  /*3.
  static public void show1(){
  System.out.println("M2inn show1()");
    }
	*/
 }
 M2inn m2=new M2inn();
 m2.show();
 }
  public void m1(){
  System.out.println("A m1()");
  System.out.println(a);
  System.out.println(b);
  //1.	M2inn m2=new M2inn();
  m2();
   }
 }
/*
 1.	InnerClass4.java:4: cannot find symbol
	symbol  : class M2inn
	location: class A
	M2inn m2=new M2inn();
 2.	InnerClass4.java:36: local variable x is accessed from within inner class; needs  to be declared final
	System.out.println(x);
3.	InnerClass4.java:43: inner classes cannot have static declarations
	static public void show1(){	
 */