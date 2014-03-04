import java.io.*;
class tamanaa1{
public static void main(String as[])throws IOException{

//InputStreamReader obj=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
System.out.println("Enter ID: ");
int i=Integer.parseInt(br.readLine());
System.out.println("Enter sex (M/F) :");
char c=(char)br.readLine().charAt(0);
//br.skip(2);
System.out.println("Enter Name : ");
String st=br.readLine();
System.out.println("ID= "+i);
System.out.println("Sex= "+c);
System.out.println("Name= "+"\""+st+"\"");


}
}