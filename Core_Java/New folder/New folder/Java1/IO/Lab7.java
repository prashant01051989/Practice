//package tamanna.java.io;
import java.io.*;
class Lab7{
	public static void main(String as[])
	{
		try
		{
			BufferedInputStream bis=new BufferedInputStream(System.in);
			PrintStream ps=System.out;
			ps.println("Enter Data");
			char ch=' ';
			int x=0;
			byte i=45;
			do
			{
				//ps.write(i);
				x=bis.read();
				ps.println(x);
				//ps.println("");
				ps.write(x);
				ch=(char)x;
				ps.println("*********");
				ps.write(ch);
				ps.println("");
				//String a="PRASHANT";
				//ps.write(a);->write(java.lang.String) has private access in java.io.PrintStream.
			}while(x!=10);
		}catch(Exception e)									
		{
			e.printStackTrace();
		}
	}
}