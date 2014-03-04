class Hello{
void m1() throws Exception,ArrayIndexOutOfBoundsException{

try{
m2();
}catch(Throwable e){
System.out.println("m1-ok ok");
if(1==2){
throw new Exception();
}else{
throw new ArithmeticException("Don't Do this");
}
}
}
void m2()throws ArrayIndexOutOfBoundsException,Throwable{
m3();
}
void m3()throws Throwable,Exception,Error{

try{
m4();
}catch(Error e){
System.out.println("m3-ok ok");
throw new Error();
}
}
void m4() throws Throwable {
m5();
}
void m5()throws Exception{
int x=10/0;
}
}

class Lab {
public static void main(String as[]){
try{
Hello h=new Hello();
h.m1();
}catch(Exception e){
System.out.println(e);
System.out.println(e.getMessage());
e.printStackTrace();
}
}
}