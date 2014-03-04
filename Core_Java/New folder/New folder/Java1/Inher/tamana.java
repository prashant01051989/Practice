class A{
int a=10;
static int b=200;
static {
System.out.println("A-SB");
//System.out.println(a);
System.out.println(b);
}
{
System.out.println("A-IB");
System.out.println(a);
System.out.println(b);
}
void showA(){
System.out.println("ShowA");
System.out.println(a);
System.out.println(b);
}
}

class B extends A{
int c=20;
static int d=300;
static {
System.out.println("B-SB");
//System.out.println(a);
System.out.println(b);
//System.out.println(c);
System.out.println(d);
}
{
System.out.println("B-IB");
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
}
void showB(){
System.out.println("ShowB");
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
}
}
class C extends B{
int e=30;
static int f=400;
static {
System.out.println("C-SB");
//System.out.println(a);
System.out.println(b);
//System.out.println(c);
System.out.println(d);
//System.out.println(e);
System.out.println(f);
}
 {
System.out.println("C-IB");
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
System.out.println(e);
System.out.println(f);
}
void showC(){
System.out.println("ShowC");
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
System.out.println(e);
System.out.println(f);
}
}

class tamana{
public static void main(String as[]){
C c=new C();
c.showC();
}
}


