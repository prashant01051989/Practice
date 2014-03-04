import java.util.Scanner;
class tamanaa4{
public static void main(String as[]){
System.out.println("Enter ID sex (M/F) Name: ");
Scanner sc=new Scanner(System.in);
int i=sc.nextInt();
char c=sc.next().charAt(0);
String st=sc.next();
System.out.println("ID= "+i);
System.out.println("Sex= "+c);
System.out.println("Name= "+"\""+st+"\"");
}
}