public interface i1{
int a=10;
int b=20;
int c=30;

}
interface i2 extends i1{
void m3();
void m1();
}

interface i3{
int x=100;
int y=200;
int c=300;
}
interface i4{
void m2();
}
interface i5 extends i3,i4{
void m3();
void show();
}

class hello implements i2,i5{
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
System.out.println(x);
System.out.println(y);
//System.out.println(c);
System.out.println(i2.c);
System.out.println(i5.c);
}
}

class tamana7{
public static void main(String as[]){
i2 obj=new hello();
obj.m1();
obj.m3();
//obj.show();
i5 obj1=new hello();
obj1.m2();
obj1.m3();
obj1.show();
}
}


