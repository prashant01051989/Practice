package tamanna.java.io;
import java.io.*;
class Lab6{
	public static void main(String as[])
	{
		try
		{
			InputStreamReader isr=new InputStreamReader(System.in);
			Reader br=new BufferedReader(isr);
			PrintStream ps=System.out;
			ps.println("Enter Data");
			char ch=' ';
			do
			{
				int b=br.read();
				ch=(char)b;
				System.out.write(b);
			}while(ch!='\n');
		}catch(Exception e)									
		{
			e.printStackTrace();
		}
	}
}