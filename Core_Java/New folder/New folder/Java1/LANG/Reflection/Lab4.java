import java.lang.reflect.*;
class Hello
{
	void main(String str1,int a)
	{
		System.out.println("str1 = "+str1);
		System.out.println("a = "+a);
	}
	public static final void main(String str[])
	{
		for(int i=0;i<str.length;i++){
		System.out.println("str = "+str[i]);
		}
		
	}
	
	 static  public void main1(String str[])
	{
		System.out.println(")))))))))))))");
		for(int i=0;i<str.length;i++){
		
		System.out.println("str = "+str[i]);
		}
		
	}
	public void main(int a,String str2) 
	{
		System.out.println("a = "+a);
		System.out.println("str2 = "+str2);
	}
	
	static void main(String str)
	{
		System.out.println("str = "+str);
	}
}
class Hai
{
	public void main(int a,String str2) 
	{
		System.out.println("a = "+a);
		System.out.println("str2 = "+str2);
	}
	void main(String str1,int a)
	{
		System.out.println("str1 = "+str1);
		System.out.println("a = "+a);
	}
	static void main(String str)
	{
		System.out.println("str = "+str);
	}
}
class Lab4
{
	public static void main(String as[]) 
	{
		try
		{	int j=0;
			Class cls=Class.forName(as[0]);
			Method []mm=cls.getDeclaredMethods();
				
			for(int i=0;i<mm.length;i++)
			{
				
				if(mm[i].toString().equals("public static void Hello.main(java.lang.String[])")||mm[i].toString().equals("public static final void Hello.main(java.lang.String[])"))
				{
					
					String st[]={"PRASHANT","PRASHANT1","PRASHANT2","PRASHANT3"};
					Object obj1[]={null};
					mm[i].invoke(null,obj1);
					j++;
					break;
					
				}
			}
			if(j==0)
			{
				try
				{
					throw new NoSuchMethodError();
				}catch(Error e){
					System.out.print(e);
				}
			}	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}