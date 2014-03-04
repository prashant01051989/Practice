class Hello{
public static int a=0; 
int b;
int c;
public Hello(){
System.out.println("Hello-def-con");
}
public Hello(int a,int b){
System.out.println("Hello-2Arg-con");
this.a=a;
this.b=b;
}
/*
public int hashCode(){
return ++a;
}
*/
/*
public boolean equals(Object obj){
Hello h=(Hello)obj;
if(this.a==h.a && this.b==h.b)
return true;
else
return false;
}
*/
/*
public String toString(){
return "This is toString method of Hello class not Object classs";
}
*/
}
class Obj1{
public static void main(String as[]){

Hello h=new Hello();
Class cls=h.getClass();
System.out.println(cls);

System.out.println(cls.getName());

System.out.println(h.hashCode());
Hello h1=new Hello();
System.out.println(h1.hashCode());
System.out.println(h1.equals(h));

Hello h3=h1;
System.out.println(h3.equals(h1));

Hello h4=new Hello(10,20);
Hello h5=new Hello(10,20);
System.out.println(h4.equals(h5));

Hello h6=new Hello(10,20);
Hello h7=new Hello(10,30);
System.out.println(h7.equals(h6));
//Hello h8;
Hello h8=null;
System.out.println(h8);
h8=new Hello();
System.out.println(h8);
}
}