class A{
//case-1,2
/*
void m(){
System.out.println("A-m()");
}
*/
//case-1,2
/*
void m1(){
System.out.println("A-m1()");
}
*/
//case-3,4
/*
void m1(int a,char c){
System.out.println("A-m1()");
}
*/
//case-5
/*
void m1(){
System.out.println("B-m1()");
}
*/
//case-6
/*
private void m1(){
System.out.println("B-m1()");
}
*/
//case-7
/*
protected void m1(){
System.out.println("B-m1()");
}
*/
//case-8
/*
public void m1(){
System.out.println("B-m1()");
}
*/
//case-9
/*
final void m4(){
System.out.println("A-m4()");
}*/

//case-10
static void m5(){
System.out.println("A-m5()");
}
}

class B extends A
{
/*
//case-1,2
void m2(){
System.out.println("B-m2()");
}
*/
/*
//case-1,2
void m1(){
System.out.println("B-m1()");
}
*/
//case-3
/*
void m1(int d,char e){
System.out.println("B-m1()");
}
*/
//case-4
/*
void m1(char e,int d){
System.out.println("B-m1()");
}
*/
//case-5
/*
int  m1(){
System.out.println("B-m1()");
return 10;
}
*/
//case-6
/*
private void m1(){
System.out.println("B-m1()");
}
*/
//case-7
/*
protected void m1(){
System.out.println("B-m1()");
}
*/
//case-8
/*
protected void m1(){
System.out.println("B-m1()");
}
*/

/*void m4(){
System.out.println("B-m3()");
}*/
//case-9
/*
void m5(){
System.out.println("B-m5()");
}
*/
//case-10
static void m5(){
System.out.println("B-m5()");
}

}

class Inher10{
public static void main(String as[]){
//case-1
/*
A a =new A();
a.m();
a.m1();

B b=new B();
b.m1(); 
b.m2();
b.m();
*/
//case-2
/*
A a=new B();
a.m1(); //To Know method is overriding or not
a.m();
//6. a.m2();
*/
//case-3
/*
A a=new B();
a.m1(10,'a'); 
*/
//case-4
/*
A a=new B();
//1. a.m1('a',10); 
*/

//case-5
/*2.
A a=new B();
int k=a.m1(); 
*/
//case-6
/*3.
A a=new B();
a.m1();
*/
//case-7
/*
A a=new B();
a.m1();
*/
//case-8
/*4.
A a=new B();
a.m4();
*/
//case-9
/*5.
A a=new B();
a.m5();
*/

//case-10
A a=new B();
a.m5();//A class static method will be called.
B b=new B();
b.m5();//B class static method will be called.
}
}

/*
1.	Inher10.java:47: m1(int,char) in A cannot be applied to (char,int)
	b.m1('a',10);	
	
2.	Inher10.java:30: m1() in B cannot override m1() in A; attempting to use incompatible return type
	found   : int
	required: void
	int  m1(){

	Inher10.java:65: incompatible types
	found   : void
	required: int
	int k=a.m1();
3.	Inher10.java:142: m1() has private access in A
	a.m1();
4	Inher10.java:53: m1() in B cannot override m1() in A; attempting to assign weaker access privileges; was public   
5.	Inher10.java:67: m4() in B cannot override m4() in A; overridden method is final    

*/