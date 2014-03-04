class Hello{
int a;
static int b;


static{
System.out.println("Static Block");
}

{
System.out.println("Instance Block");
}

Hello(){}

Hello(int a,int b){
System.out.println("Cons- Block");
this.a=a;
this.b=b;
}


void show(){
System.out.println("Show - method");
int x=10;
System.out.println(this);
//1. this=new Hello();
//2. this=123;
System.out.println(a);
System.out.println(b);
System.out.println(x);
show3();

}

static void show1(){
System.out.println("Static1 - method");
//3. System.out.println(this);
}

void show3(){
System.out.println("Show3 - method");
int x=100;
System.out.println(x);
}

}

class This{
public static void main(String as[]){
Hello h1=new Hello(10,20);
//h1.show();
//h1.show1();
h1.show();

}
}

/*

1.  this.java:26: cannot assign a value to final variable this
	this=new Hello();
				
2.  this.java:27: incompatible types
	found   : int
	required: Hello

3. this.java:36: non-static variable this cannot be referenced from a static context
	System.out.println(this);     				  
*/