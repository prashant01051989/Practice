class Hai{
int a;
static int b;

static {
System.out.println("Hai-SB");
System.out.println(b);
}
{
System.out.println("Hai-IB");
System.out.println(a);
System.out.println(b);
}
public Hai(){
System.out.println("Hai-Con");
}
public Hai(int a,int b){
System.out.println("Hai-2-Con");
this.a=a;
this.b=b;
}
static void haiStatic(){
System.out.println("haiStatic()");
System.out.println(b);
}
void haiIns(){
System.out.println("haiIns()");
System.out.println(a);
System.out.println(b);
}
}

class Hello extends Hai{
int c;
static int d;

static {
System.out.println("Hello-SB");
System.out.println(d);
}

{
System.out.println("Hello-IB");
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
}

public Hello(){
System.out.println("Hello-Con");
}
public Hello(int c,int d){
System.out.println("Hello-Con");
this.c=c;
this.d=d;
}
static void helloStatic(){
System.out.println("helloStatic()");
System.out.println(b);
System.out.println(d);
}

void helloIns(){
System.out.println("helloIns()");
System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
}
}

class Inher4{
public static void main(String as[]){
/*
Hai hai =new Hai(11,12);
Hai.haiStatic();
hai.haiStatic();
hai.haiIns();
System.out.println(hai.a);
System.out.println(Hai.b);
System.out.println(hai.b);
*/
/*
//Hello hello=new Hello(21,22);
//Hello.helloStatic();// only static block of super class sub class and helloStatic will be execute
//hello.helloStatic();
//Hello.haiStatic(); // only static block of super class and haiStatic will be execute
//hello.haiStatic();
//hello.haiIns();
//hello.helloIns();
//System.out.println(Hello.b);// only static block of super class and hello.b will be execute
//System.out.println(Hello.d);
//System.out.println(hello.a);
//System.out.println(hello.c); */

/*
Hai.b=13;
System.out.println(Hai.b);
System.out.println(Hello.b);

Hello.b=23;
System.out.println(Hai.b);
System.out.println(Hello.b);
*/




}

}

/*

*/