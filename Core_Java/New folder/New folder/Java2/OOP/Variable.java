class Hello{
int a=10;
static int b=20;
void show(){
System.out.println(a);
System.out.println(b);

}
}

class Variable{
public static void main(String as[]){
Hello h1 =new Hello();
h1.show();
Hello h2=new Hello();
h2.show();
h1.a=1000;
h1.b=2000;
h1.show();
h2.show();
System.out.println(h1.a);
System.out.println(h1.b);
//1. System.out.println(Hello.a);
System.out.println(Hello.b);
Hello h3=null;
//2. System.out.println(h3.a);
System.out.println(h3.b);
Hello h4;
//3. System.out.println(h4.a);
//3. System.out.println(h4.b);

}

}
/*

1. variable.java:23: non-static variable a cannot be referenced from a static context
   System.out.println(Hello.a);

2. Exception in thread "main" java.lang.NullPointerException
        at Variable.main(variable.java:26)     
3. variable.java:29: variable h4 might not have been initialized
   System.out.println(h4.a);                       

*/