class Hai{
private int a=11;
protected int b=12;
int c=13;
public int d=14;

void haiIns(){
System.out.println("haiIns()");
System.out.println(a);
System.out.println(b);
System.out.println(c);
}
}

class Hello extends Hai{

void helloIns(){
System.out.println("helloIns()");
//1. System.out.println(a);
System.out.println(b);
System.out.println(c);
}
}

class C{
Hai hai=new Hai();
void haiIns(){
System.out.println("haiIns()");
//1. System.out.println(hai.a);
System.out.println(hai.b);
System.out.println(hai.c);
}
}
class Inher9{
public static void main(String as[]){
/*
Hai hai =new Hai();
hai.haiIns();
*/

Hello hello=new Hello();
hello.helloIns();

}
}

/*
1.	Inher9.java:19: a has private access in Hai
2.	Inher2.java:62: cannot find symbol
	symbol  : variable d
	location: class Hai
	System.out.println(Hai.d);
3.	Inher2.java:50: not a statement
	Hello.d;
*/