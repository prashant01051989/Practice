class A{
int a=10;
int b=20;
A(){
System.out.println("A-DC");
sum();
}
void sum(){
System.out.println("This is a sum method "+(a+b));
}
}
class B extends A{
B(){
super();
System.out.println("B-DC");
}
}
class C extends B{
C(){
super();
System.out.println("C-DC");
}
}
class D extends C{
D(){
super();
System.out.println("D-DC");
}
}
class E extends D{
E(){
super();
System.out.println("E-DC");
}
}

class tamanaa1{
public static void main(String as[]){
System.out.println("Main is begin");
E e=new E();
System.out.println("Main is end");
}
}