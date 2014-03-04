import java.io.*;
class Lab13
{
	public static void main(String as[])
	{
		FileReader fr=null;
		FileWriter fw=null;
		BufferedReader br=null;
		BufferedWriter bw=null;
		try
		{
			fr=new FileReader("anshu.txt");
			br=new BufferedReader(fr);
			fw=new FileWriter("pra.txt",true);
			bw=new BufferedWriter(fw);
			PrintStream ps=System.out;
			
			int ch=0;
			while((ch=br.read())!=-1)
			{
				//ch=br.read();
				bw.write((char)ch);
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
				if(br!=null)
				br.close();
				if(bw!=null)
				bw.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}


}