import java.lang.reflect.*;

class A{
 static public void main(String as[]){
	System.out.println("sssssssss");
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
					Object obj1[]={st};
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