
class Hello{
void m1()throws ArrayIndexOutOfBoundsException,ArithmeticException{
try{
m2();
}catch(Object e){
System.out.println("m1-OK OK");
if(1==2){
throw new ArrayIndexOutOfBoundsException();
}else{
throw new ArithmeticException("Don't Do This");
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
System.out.println("m3 -OK OK");
throw new ArrayIndexOutOfBoundsException();
}
}

void m4()throws ArithmeticException{
m5();
}

void m5()throws ArithmeticException{
int x=10/0;
}
}



class Lab8{
public static void main(String as[]){
System.out.println("BEGINING");
try{
Hello h=new Hello();
h.m1();
}catch(Exception e){
System.out.println(e);
System.out.println(e.getMessage());
e.printStackTrace();
}
System.out.println("END");
}
}