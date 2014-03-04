import java.io.*;
import java.util.*;
class tamanaa2{
public static void main(String as[])throws IOException{
BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
System.out.println("Enter ID,sex (M/F),Name: ");
String s=br.readLine();
StringTokenizer str=new StringTokenizer(s,",");
String s1=str.nextToken();
String s2=str.nextToken();
String s3=str.nextToken();
s1=s1.trim();
s2=s2.trim();
s3=s3.trim();
int i=Integer.parseInt(s1);
char c=s2.charAt(0);
String st=s3;
System.out.println("ID= "+i);
System.out.println("Sex= "+c);
System.out.println("Name= "+"\""+st+"\"");


}
}