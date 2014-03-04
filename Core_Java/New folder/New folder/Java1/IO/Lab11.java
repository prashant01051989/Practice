import java.io.*;

class Lab11
{
	public static void main(String as[])
	{
		FileWriter fr=null;
		try
		{
			InputStreamReader ir=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(ir);
			fr=new FileWriter("anshu.txt",true);
			PrintStream ps=System.out;
			char ch=' ';
			while((ch=(char)br.read())!='@')
			{
		     //ch=(char)br.read();
		     fr.write(ch); 
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