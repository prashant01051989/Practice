class Lab2{

public static void main(String as[]){
System.out.println("BEGINING");
String s=null;
try{
s=as[0];
}catch(ArrayIndexOutOfBoundsException e){
System.out.println("PLEASE GIVE NUMBER");
System.out.println(e);
}
int a=0;
try{
a=Integer.parseInt(s);
}catch(NumberFormatException e2){
System.out.println("PLEASE  GIVE INTEGER NUMBER");
System.out.println(e2);
}
try{
int x=10/a;
System.out.println("Answer: "+x);
}catch(ArithmeticException e1){
System.out.println("PLEASE DON'T GIVE 0 NUMBER");
System.out.println(e1);
}
System.out.println("END");

}
}