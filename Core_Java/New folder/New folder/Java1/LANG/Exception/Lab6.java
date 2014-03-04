class NumberNotValidException extends Exception{
int a;
NumberNotValidException(){}
NumberNotValidException(int a){
this.a=a;
}
public String getMessage(){
String as=null;
return as.valueOf(a);
}
public String toString(){
return "Enter Invalid Number: "+getMessage();
}
}
class Check{

void checkNum(int num){
try{
if(num<10||num>20)
throw new NumberNotValidException(num);
else
System.out.println("Number is: "+num);
}catch(Exception e){
System.out.println(e);
}
}
}
class Lab6{
public static void main(String as[]){
System.out.println("BEGINING");
try{
int x=Integer.parseInt(as[0]);
Check c=new Check();
c.checkNum(x);
}catch(ArrayIndexOutOfBoundsException e){
System.out.println("PLEASE GIVE NUMBER");
System.out.println(e);
}catch(NumberFormatException e2){
System.out.println("PLEASE  GIVE INTEGER NUMBER");
System.out.println(e2);
}
System.out.println("END");
}
}