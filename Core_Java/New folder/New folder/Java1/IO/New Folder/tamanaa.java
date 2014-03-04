import java.io.*;
import java.util.*;
class tamanaa{
public static void main(String as[])throws IOException{
InputStreamReader i1=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(i1);

int x=0;
int y=1;
int z=x+y;
System.out.println("Enter the number of terms you want :");
int n=Integer.parseInt(br.readLine());
if (n==0)
System.out.println(x);

if(n>=1) 
{
System.out.println(x);
System.out.println(y);
z=x+y;
}
for(int i=2;i<=n;i++){

System.out.println(z);
x=y;
y=z;
z=x+y;
}
 }
}