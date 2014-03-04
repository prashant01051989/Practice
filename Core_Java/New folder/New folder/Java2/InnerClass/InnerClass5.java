abstract class Animal1{
abstract void eating();
}
interface Animal2{
abstract void eating1();
}
abstract class Animal3{
int a=1234;
abstract void eating3();
}
class Hai {
void m1(){
System.out.println("Hai-m1()");
}
}
class Hai1 extends Hai {
void m1(){
System.out.println("Hai1-m1()");
}
}
class Hello{
int a=10;
final int b=20;
Animal1 a1=new Animal1(){
public void eating(){
System.out.println("Animal1 is eating");
System.out.println(a);
}
};
Animal2 a2=new Animal2() {
public void eating1(){
System.out.println("Animal2 is eating");
System.out.println(b);
}
};
Animal3 a3=new Animal3() {
public void eating3(){
System.out.println("Animal3 is eating");
}
};
public void show(){
int x=100;
Animal2 a2=new Animal2(){
public void eating1(){
int y=200;
System.out.println("Animal2 is eating");
//1.	System.out.println(x);
System.out.println(y);
System.out.println(b);
}
};
a2.eating1();
}
Hai h1=new Hai();
Hai h2=new Hai1();
Hai h3=new Hai(){
void m1(){
System.out.println("Annonymus inner class Hai-m1()");
}
};

void show1(){
h1.m1();
h2.m1();
h3.m1();
}
}
class InnerClass5{
public static void main(String as[]){
/*
Hello h=new Hello();
h.a1.eating();
h.a2.eating1();
*/
/*
Hello h1=new Hello();
h1.show();
h1.a3.eating3();
System.out.println(h1.a3.a);
*/
Hello h1=new Hello();
h1.show1();
}
}
/*
1. 	InnerClass5.java:28: local variable x is accessed from within inner class; needs
	to be declared final
	System.out.println(x);
*/