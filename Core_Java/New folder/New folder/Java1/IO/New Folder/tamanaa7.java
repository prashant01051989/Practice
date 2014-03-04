import java.io.*;
class tamanaa7 {
public static void main(String as[])throws IOException	{
BufferedReader br=new  BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter the file name :");
String fname=br.readLine();
FileInputStream fin=null;
try{
fin=new FileInputStream(fname);
}catch(FileNotFoundException fe){

int  ch;
while((ch=br.read())!=-1)
     System.out.println((char)ch);
	 fin.close();
	 }
}
}