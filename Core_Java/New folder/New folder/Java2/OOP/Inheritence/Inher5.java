class A{
int a=11;
void aIns(){
System.out.println("aIns()");
System.out.println(a);
}
}

class Hai extends A{
int b=21;


void haiIns(){
System.out.println("haiIns()");
System.out.println(a);
System.out.println(b);
}
}

class Hello extends Hai{
int c=31;


void helloIns(){
System.out.println("helloIns()");
System.out.println(a);
System.out.println(b);
System.out.println(c);
}

}

class Inher5{
public static void main(String as[]){
/*
A a=new A();
a.aIns();
*/
/*
Hai hai =new Hai();
hai.haiIns();
hai.aIns();
*/

Hello hello=new Hello();
hello.helloIns();
hello.haiIns();
hello.aIns();
}

}

