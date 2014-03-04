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

Hello(int x,int y){
System.out.println("Cons- Block");
a=x;
b=y;
}


void show(){
System.out.println("instance1 - method");
System.out.println(a);
System.out.println(b);
//show3();
//show4();
}


static void show1(){
System.out.println("Static1 - method");
//1. System.out.println(a);
System.out.println(b);
//3. show3();
//show4();
//4. void test(){}
{System.out.println("instance2 -Block");}
}

void show3(){
System.out.println("instance2 - method");
System.out.println(a);
System.out.println(b);

}


static void show4(){
System.out.println("Static2 - method");
System.out.println(b);

}




}

class Method{
public static void main(String as[]){
//Hello h1=new Hello(10,20);
//h1.show();
//h1.show1();
//Hello.show1();
//Hello h2;
//2. h2.show1();
Hello h3=new Hello(10,20);
h3.show();
h3.show1();
}
}

/*

1.  method.java:32: non-static variable a cannot be referenced from a static context
	System.out.println(a);
				
2. method.java:50: variable h2 might not have been initialized
	h2.show1();

3. method.java:36: non-static method show3() cannot be referenced from a static context
	show3(); 
4. method.java:38: illegal start of expression
	void test(){}

5. constructor.java:18: modifier static not allowed here
static Student(){}      				  
*/