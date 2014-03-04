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
void showB(){
System.out.println("ShowB");
//System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
}
}
class C {
void showC(){
System.out.println("ShowC");
A obj =new A();
//System.out.println(obj.a);
System.out.println(obj.b);
System.out.println(obj.c);
System.out.println(obj.d);
}
}
class tamana3{
public static void main(String as[]){
A a=new A();
a.showA();
B b=new B();
b.showB();
C c=new C();
c.showC();

}
}


