//package tamanna.java.io;
import java.io.*;
class Lab10{
	public static void main(String as[])
	{
		FileInputStream fis=null;
		BufferedInputStream bis=null;
		FileOutputStream fos=null;
		BufferedOutputStream bos=null;
		try
		{
			fis=new FileInputStream("anshu.txt");
			bis=new BufferedInputStream(fis);
			fos=new FileOutputStream("pra.txt",true);
			bos=new BufferedOutputStream(fos);
			PrintStream ps=System.out;
			int ch=0;
			while(ch!=-1)
			{
				ch=bis.read();
				bos.write(ch);
			}
		ps.println("Done");
		}catch(Exception e)									
		{
			e.printStackTrace();
		}finally{
		try{
		if(bis!=null)
		bis.close();
		if(bos!=null)
		bos.close();
		}	catch(Exception e)									
			{
				e.printStackTrace();
			}
		}
	}
}