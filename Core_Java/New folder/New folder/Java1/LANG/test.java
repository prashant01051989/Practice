class Hello{
static Hello h=null;
static{
h=new Hello();
}
private Hello(){
System.out.println("HELLO DC");
}
static Hello getHello(){
return h;}
}
class test{
public static void main(String as[]){
Hello i=Hello.getHello();
}
}
