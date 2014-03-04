class Hai{
int a=10;
void m1(){
System.out.println("m1()");
System.out.println(a);
}
}

class Hello extends Hai{
int b=20;
void show(){
System.out.println("Show()");
System.out.println(a);
System.out.println(b);
}
}

class Inher1{
public static void main(String as[]){
Hai hai =new Hai();
System.out.println(hai.a);
//1. System.out.println(hai.b);
hai.m1();
//2. hai.show();

/*Hello hello=new Hello();
System.out.println(hello.b);
System.out.println(hello.a);
hello.show();
hello.m1();*/

}
}


//3. class A extends A{}

/*
1.	symbol  : variable b
	location: class Hai
	System.out.println(hai.b);
2.	Inher1.java:25: cannot find symbol
	symbol  : method show()
	location: class Hai
	hai.show();
3.	Inher1.java:17: cyclic inheritance involving A
	class A extends A{}
*/