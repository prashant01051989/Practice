import java.io.*;

class IOTest1{
public static void main(String as[]){
try{
DataInputStream dis=new DataInputStream(System.in);
System.out.println("Enter First Number");
int a=dis.readInt();
System.out.println(a);
System.out.println("Enter second number");
int b=dis.readInt();
int sum=a+b;
System.out.println(sum);
}catch(Exception e){
e.printStackTrace();
}
}
}