class Hai{
int x=10;
}

class Hello{

void m1(int p){
System.out.println("m1 begin");
System.out.println(p);
p=p+10;
System.out.println(p);
System.out.println("m1 ends");
}

void m2(Hai hai){
System.out.println("m2 begin");
System.out.println( hai.x );
hai.x =hai.x +10;
System.out.println(hai.x );
System.out.println("m2 ends");

}
}

class CallByValue{
public static void main(String as[]){
Hello h=new Hello();
int a=100;
System.out.println(a);
h.m1(a);
System.out.println(a);
Hai hai=new Hai();
System.out.println(hai.x); 
h.m2(hai);
System.out.println(hai.x); 
}

}