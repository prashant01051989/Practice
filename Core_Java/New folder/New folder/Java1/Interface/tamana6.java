
interface i1{
public final static int a=10;
public final int b=20;
public int c=30;
int d=40;
static int e=50;
final  int f=60;
public int g=70;
public abstract void m2();
void m1();
void show();
}


class hello implements i1{
public void m2(){
System.out.println("m2");
}
public void m1(){
System.out.println("m1");
}
public void m3(){
System.out.println("m3");
}
public void show(){
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
System.out.println(e);
System.out.println(f);
System.out.println(g);
}
}



class tamana6{
public static void main(String as[]){
hello a=new hello();
a.m1();
a.m2();
a.m3();
a.show();
i1 obj=new hello();
obj.m1();
obj.m2();
//obj.m3();
obj.show();
System.out.println(i1.a);
System.out.println(i1.d);
System.out.println(i1.c);
System.out.println(i1.b);
System.out.println(i1.f);
System.out.println(i1.e);
System.out.println(i1.g);
}
}


