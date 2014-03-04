class Lab1{

public static void main(String as[]){
System.out.println("BEGINING");
try{
int a=Integer.parseInt(as[0]);
int x=10/a;
System.out.println("Answer: "+x);
}
//System.out.println("PRASHANT");'try' without 'catch' or 'finally'
catch(ArrayIndexOutOfBoundsException e){
System.out.println("PLEASE GIVE NUMBER");
System.out.println(e);
}
//System.out.println("PRASHANT");'catch' without 'try'
catch(ArithmeticException e1){
System.out.println("PLEASE DON'T GIVE 0 NUMBER");
System.out.println(e1);
}
catch(NumberFormatException e2){
System.out.println("PLEASE  GIVE INTEGER NUMBER");
System.out.println(e2);

}
finally//finally block must be placed after try block or catch block. 
{
System.out.println("END");
}
}
}