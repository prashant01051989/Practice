class Hello {
int m1(String s){
try{
int a=Integer.parseInt(s);
int x=10/a;
System.out.println("Answer: "+x);
System.exit(0);
return x;
}catch(Exception e){
e.printStackTrace();
return 11;
}
finally{
System.out.println("Resource Cleanup can be done here");
System.out.println("I am ok");
return 88;
}
//System.out.println("I am not ok");
//return 99;
}
void m2(){
try{
int x=10/0;
}
finally{
System.out.println("I am inside finally");
}
System.out.println("I am Outside finally");
}

}
class Lab3{
public static void main(String as[]){
System.out.println("BEGINING");
Hello h=new Hello();
int s=h.m1(as[0]);
h.m2();
System.out.println(s);
System.out.println("END");

}
}