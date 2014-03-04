import java.io.*;
class Lab15
{
	public static void main(String as[])
	{
		System.out.println("File.pathSeparator\t:"+File.pathSeparator);
		System.out.println("File.pathSeparatorChar\t:"+File.pathSeparatorChar);
		System.out.println("File.separator\t:"+File.separator);
		System.out.println("File.separatorChar\t:"+File.separatorChar);
		File []far=File.listRoots();
		System.out.println(far.length);
		System.out.println("FileName"+"\t"+"is Directory"+"\t"+"is File"+"\t\t"+"is Absolute"+"\t"+"getPath");
		for(int i=0;i<far.length;i++)
		{
			System.out.println(far[i].getName()+"\t\t"+far[i].isDirectory()+"\t\t"+far[i].isFile()+"\t\t"+far[i].isAbsolute()+"\t\t"+far[i].getPath());
		}
		File f1=new File("c:/","hi.txt");
	
	}
	
}