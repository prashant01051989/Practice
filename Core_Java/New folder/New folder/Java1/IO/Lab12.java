import java.io.*;
class Lab12
{
	public static void main(String as[])
	{
		FileReader fr=null;
		try
		{
			fr=new FileReader("anshu.txt");
			PrintStream ps=System.out;
			int ch=0;
			while(ch!=-1)
			{
				ch=fr.read();
				ps.write(ch);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(fr!=null)
				fr.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}


}