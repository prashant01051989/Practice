class A{
int a=101;
void aIns(){
System.out.println("aIns()");
System.out.println(a);
}
}
class Hai extends A{
int a=201;
int b=202;

void haiIns(){
System.out.println("haiIns()");
System.out.println(a);
System.out.println(b);
System.out.println(this.a);
System.out.println(this.b);
System.out.println(super.a);
}
void haiIns1(){
System.out.println("haiIns1()");
int a=103;
int b=104;
System.out.println(a);
System.out.println(b);
System.out.println(this.a);
System.out.println(this.b);
System.out.println(super.a);
}

}

class Hello extends Hai{
int a=301;
int b=302;
int c=303;

void helloIns(){
System.out.println("helloIns()");
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(this.a);
System.out.println(this.b);
System.out.println(this.c);
System.out.println(super.a);
System.out.println(super.b);

}
void helloIns1(){
System.out.println("helloIns1()");
int a=304;
int b=305;
int c=306;
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(this.a);
System.out.println(this.b);
System.out.println(this.c);
System.out.println(super.a);
System.out.println(super.b);
System.out.println(new A().a);
}

}

class Inher6{
public static void main(String as[]){
/*
A a=new A();
a.aIns();
*/
/*
Hai hai =new Hai();
hai.haiIns();
hai.haiIns1();
*/

Hello hello=new Hello();
hello.helloIns();
hello.helloIns1();

}

}

/*

*/