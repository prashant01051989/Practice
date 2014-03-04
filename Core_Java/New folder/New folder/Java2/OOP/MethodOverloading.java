class Hello{

void sum(int a,int b){
System.out.println("int and int");
System.out.println(a+b);
}

void sum(int a,double b){
System.out.println("int and double");
System.out.println(a+b);
}

void sum(int a,long b){
System.out.println("int and long");
System.out.println(a+b);
}

void sum(int a,float b){
System.out.println("int and float");
System.out.println(a+b);
}

void sum(int a,byte b){
System.out.println("int and byte");
System.out.println(a+b);
}

void sum(int a, short b){
System.out.println("int and short ");
System.out.println(a+b);
}
}                             

class MethodOverloading{
public static void main(String as[]){
Hello h1=new Hello();
h1.sum(10,20);
h1.sum(10,20.0);
h1.sum(10,'a');
h1.sum(10,99967789123l);
h1.sum(10,20.0f);
}
}

/*

1.      				  
*/