class Hello{
int a=10;
static  int b=20;
static final int c=20;

{
System.out.println("Instance Block");
System.out.println(a);
System.out.println(b);
}

static{
System.out.println("Static Block1");
//1. System.out.println(a);
System.out.println(b);

{
System.out.println("Instance Block");
}
}

static{
System.out.println("Static Block2");
}
}

class Block{
public static void main(String as[]){
/*Hello h1 =new Hello();
Hello h2=new Hello();
*/
//Hello h1;
//new Hello();
//Hello h1=null;
System.out.println(Hello.b);
//System.out.println(Hello.c);

}
}

/*

1. block.java:13: non-static variable a cannot be referenced from a static context
	System.out.println(a);  	   ^
*/