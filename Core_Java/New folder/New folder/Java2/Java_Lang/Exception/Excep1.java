class Excep1{
public static void main(String as[]){
System.out.println("Main-Begin");
/*
int a=Integer.parseInt(as[0]);
int x=10/a;
System.out.println(x);
*/
/*1.
try{
int a=Integer.parseInt(as[0]);
int x=10/a;
System.out.println(x);
}
*/
/*
try{
int a=Integer.parseInt(as[0]);
int x=10/a;
System.out.println(x);
}catch(Exception e){
	System.out.println(e);
	System.out.println("NOT OK ");
}
*/
/*
try{
int a=Integer.parseInt(as[0]);
int x=10/a;
System.out.println(x);
}
//2.
catch(Exception e){
	System.out.println("NOT OK");
	System.out.println(e);
}


catch(ArrayIndexOutOfBoundsException aiobe){
	System.out.println("Please enter Number ");
	System.out.println(aiobe);
}catch(NumberFormatException nfe){
	System.out.println("Please dont provide String");
	System.out.println(nfe);
}catch(ArithmeticException ae){
	System.out.println("Please not enter 0");
	System.out.println(ae);
}catch(Exception e){
	System.out.println("NOT OK");
	System.out.println(e);
}

*/
/*
try{
int a=Integer.parseInt(as[0]);
int x=10/a;
System.out.println(x);
}
//3.	System.out.println("Prashant");
catch(ArrayIndexOutOfBoundsException aiobe){
	System.out.println("Please enter Number ");
	System.out.println(aiobe);

}
//4.	System.out.println("Prashant");
catch(NumberFormatException nfe){
	System.out.println("Please dont provide String");
	System.out.println(nfe);
}catch(ArithmeticException ae){
	System.out.println("Please not enter 0");
	System.out.println(ae);
}catch(Exception e){
	System.out.println("NOT OK");
	System.out.println(e);
}
*/
/*
try{
int a=Integer.parseInt(as[0]);
int x=10/a;
System.out.println(x);
}catch(ArrayIndexOutOfBoundsException aiobe){
	System.out.println("Please enter Number ");
	System.out.println(aiobe);
}catch(NumberFormatException nfe){
	System.out.println("Please dont provide String");
	System.out.println(nfe);
}catch(ArithmeticException ae){
	System.out.println("Please not enter 0");
	System.out.println(ae);
}catch(Exception e){
	System.out.println("NOT OK");
	System.out.println(e);
}
*/
/*
try{
int a=Integer.parseInt(as[0]);
}
catch(ArrayIndexOutOfBoundsException aiobe){
	System.out.println("Please enter Number ");
	System.out.println(aiobe);

}catch(NumberFormatException nfe){
	System.out.println("Please dont provide String");
	System.out.println(nfe);
}
try{
int x=10/a;
System.out.println(x);
}
catch(ArithmeticException ae){
	System.out.println("Please not enter 0");
	System.out.println(ae);
}catch(Exception e){
	System.out.println("NOT OK");
	System.out.println(e);
}

*/


System.out.println("Main-End");
}
}

/*
1.	>	C:\Core_Java\Basic\Java_Lang\Exception>java Excep1
		Main-Begin
		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
			at Excep1.main(Excep1.java:4)
	>	C:\Core_Java\Basic\Java_Lang\Exception>java Excep1 as
		Main-Begin
		Exception in thread "main" java.lang.NumberFormatException: For input string: "as"
	>	C:\Core_Java\Basic\Java_Lang\Exception>java Excep1 0
		Main-Begin
		Exception in thread "main" java.lang.ArithmeticException: / by zero
2.	Excep1.java:36: exception java.lang.ArrayIndexOutOfBoundsException has already been caught catch(ArrayIndexOutOfBoundsException aiobe){   
3.	Excep1.java:9: 'try' without 'catch' or 'finally'
	try{
4.	Excep1.java:44: 'try' without 'catch' or 'finally'
	try{
	Excep1.java:50: 'catch' without 'try'
	catch(ArrayIndexOutOfBoundsException aiobe){
5.	Excep1.java:56: 'catch' without 'try'
	catch(NumberFormatException nfe){

*/