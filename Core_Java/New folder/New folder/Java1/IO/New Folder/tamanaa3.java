import java.io.*;
import java.util.*;
class tamanaa3{
public static void main(String as[])throws IOException{
BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
System.out.println("Enter two numbers: ");
String s=br.readLine();
StringTokenizer str=new StringTokenizer(s,",");
String s1=str.nextToken();
String s2=str.nextToken();
s1=s1.trim();
s2=s2.trim();
int i=Integer.parseInt(s1);
int i1=Integer.parseInt(s2);
System.out.println("Result of addition= "+(i+i1));
System.out.println("Result of substraction= "+(i-i1));
System.out.println("Result of multiplication= "+(i*i1));
System.out.println("Result of division= "+(i/i1));
}

}