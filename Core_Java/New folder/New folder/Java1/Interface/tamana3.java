interface i1{
public final static int h=10;
public final int i=20;
public int j=30;
int k=40;
static int e=50;
final  int f=60;
public int g=70;
//public abstract void m2();
void m1();
void show();
}
class A{
private int a=10;
int b=20;
protected int c=30;
public int d=40;
public void show(){
System.out.println("ShowA");
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
}
}

class B extends A implements i1{
public void show(){
System.out.println("Show");
//System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
System.out.println(e);
System.out.println(f);
System.out.println(g);
System.out.println(h);
System.out.println(i);
System.out.println(j);
System.out.println(k);
super.show();
}
public void m1(){
System.out.println("B=m2");
}

}
/*class C {
void showC(){
System.out.println("ShowC");
A obj =new A();
//System.out.println(obj.a);
System.out.println(obj.b);
System.out.println(obj.c);
System.out.println(obj.d);
}
}
*/

class tamana3{
public static void main(String as[]){
B b=new B();
b.show();

}
}


