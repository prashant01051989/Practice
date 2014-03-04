//package tamanna.java.io;
import java.io.*;
class Lab8{
	public static void main(String as[])
	{
		FileOutputStream fos=null;
		BufferedOutputStream bos=null;
		try
		{
			DataInputStream dis=new DataInputStream(System.in);
			fos=new FileOutputStream("anshu.txt",true);
			bos=new BufferedOutputStream(fos);
			PrintStream ps=System.out;
			ps.println("Enter Data");
			char ch=' ';
			while(ch!='\n')
			{
				ch=(char)dis.read();
				bos.write(ch);
			}
		}catch(Exception e)									
		{
			e.printStackTrace();
		}finally{
		try{
		if(bos!=null)
		bos.close();
		}catch(Exception e)									
		{
			e.printStackTrace();
		}
		}
	}
}