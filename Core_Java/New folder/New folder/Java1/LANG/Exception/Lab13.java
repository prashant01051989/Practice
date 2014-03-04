class Hello{
void m1() throws ArithmeticException,ArrayIndexOutOfBoundsException{
try{
m2();
}catch(ArrayIndexOutOfBoundsException e){
System.out.println("m1-ok ok");
if(1==2){
throw new ArrayIndexOutOfBoundsException();
}else{
throw new ArithmeticException("Don't Do this");
}
}
}
void m2()throws ArrayIndexOutOfBoundsException{
m3();
}
void m3()throws ArrayIndexOutOfBoundsException{

try{
m4();
}catch(ArithmeticException e){
System.out.println("m3-ok ok");
ArrayIndexOutOfBoundsException aie=new ArrayIndexOutOfBoundsException();
throw aie;
}
}
void m4() throws ArithmeticException{
m5();
}
void m5()throws ArithmeticException{
int x=10/0;
}
} 
class tamanaa2{
public static void main(String as[]){
System.out.println("Main is begin");
try{
Hello h=new Hello();
h.m1();
}catch(Exception e){
System.out.println(e);
System.out.println(e.toString());
System.out.println(e.getMessage());
e.printStackTrace() ;
}
System.out.println("Main is end");
}
}

