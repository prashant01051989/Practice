import java.io.*;
class tamanaa6 {
public static void main(String as[])throws IOException	{
DataInputStream dis=new DataInputStream(System.in);
FileOutputStream fout=new FileOutputStream("anshu.txt",true);
BufferedOutputStream bout=new  BufferedOutputStream(fout,1024);
char ch;
while((ch=(char)dis.read())!='@')
     bout.write(ch);
	 bout.close();
	 }
}