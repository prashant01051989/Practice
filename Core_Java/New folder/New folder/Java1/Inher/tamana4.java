class A{
private int a=10;
int b=20;
protected int c=30;
public int d=40;
void showA(){
System.out.println("ShowA");
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
}
}

class B extends A{
private int a=11;
int b=21;
protected int c=31;
public int d=41;
void showB(){
System.out.println("ShowB");
System.out.println(a);
System.out.println(super.b=3698);
System.out.println(c);
System.out.println(d);
}
}

class tamana4{
public static void main(String as[]){
B b=new B();
b.showB();
A a=new A();
a.showA();
}
}


