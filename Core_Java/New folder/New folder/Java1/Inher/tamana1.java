class A{
int a;
int x=200;
static {
System.out.println("A-SB");
}
{
System.out.println("A-IB");
}
A()
{
System.out.println("A-DCB");
}
A(int a){
System.out.println("A-PCB");
this.a=a;
}
}

class B extends A{
int b;
int x=300;
static {
System.out.println("B-SB");
}
{
System.out.println("B-IB");
}
B()
{
System.out.println("B-DCB");
}
B(int b){
super(b);
System.out.println("B-PCB");
super(b);
this.b=b;
}
void m1(){
System.out.println(super.x);
}
void showB(){
System.out.println("ShowB");
System.out.println(x);
System.out.println(this.x);
System.out.println(super.x);
}
}
class C extends B{
int c;
int x=400;
static {
System.out.println("C-SB");
}
{
System.out.println("C-IB");
}
C()
{
System.out.println("C-DCB");
}
C(int c){
super(c);
System.out.println("C-PCB");
this.c=c;
}
void showC(){
System.out.println("ShowC");
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(x);
System.out.println(super.x);
m1();
showB();

}
}

class tamana1{
public static void main(String as[]){
C c=new C();
c.showC();
}
}


