
class Hai{
public void finalize(){
System.out.println("Hai-finalize");
}
}

class Hello{


void m1(){
System.out.println("m1-begin");
//hai=null;
Hai hai1=new Hai();
Hai hai2=new Hai();
Hai hai3=new Hai();
System.out.println("m1-end");
}
void m2(){
System.out.println("m2-begin");
Runtime rt=Runtime.getRuntime();
rt.runFinalization();
rt.gc();
Hai hai=new Hai();
System.out.println("m1-end");
}
public void finalize(){
System.out.println("Hello-finalize");
}
}
/*
class A{
void show(){
Hello h1=new Hello();
h1.m1();
h1.m2();
System.runFinalization();
System.gc();
Hello h2=new Hello();
h2.m1();
h2.m2();
System.runFinalization();
System.gc();
}
public void finalize(){
System.out.println("A-finalize");
}
}
*/
class GC2{
public static void main(String as[]){
Runtime rt=Runtime.getRuntime();
/*
Hello h=new Hello();
h.m1();
h.m2();
Hai hai=new Hai();
hai=null;
Hai hai1=new Hai();
hai1=hai;
rt.runFinalization();
rt.gc();
*/
/*
A a=new A();
a.show();
rt.runFinalization();
rt.gc();
*/
}
}