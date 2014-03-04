//package tamanna.java.io;
import java.io.*;
class Lab9{
	public static void main(String as[])
	{
		//FileOutputStream fos=null;
		BufferedInputStream bis=null;
		FileInputStream fis=null;
		
		try
		{
			fis=new FileInputStream("anshu.txt");
			//fos=new FileOutputStream("pra.txt");
			bis=new BufferedInputStream(fis);
			PrintStream ps=System.out;
			int ch=0;
			//boolean b=(ch!=-1);
			//ps.println(b);
			while(ch!=-1)
			{
				ch=bis.read();
				ps.write((char)ch);
			}
		}catch(Exception e)									
		{
			e.printStackTrace();
		}finally{
		try{
		if(bis!=null)
		bis.close();
		}catch(Exception e)									
		{
			e.printStackTrace();
		}
		}
	}
}