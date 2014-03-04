class Hai
{
}

class Hello implements Cloneable
{
int x;
Hello (int x)
{
this.x=x;
}
void show(){
System.out.println(x);
}


public Hello myclone()
	{
		Hello h=null;
		Object o=null;
		try
		{
		o=this.clone();
		}catch(CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		h=(Hello)o;
		return h;

	}
}
class Test_object
{
	public static void main(String as[])
	{
			Hai h1=null;
			System.out.println("h1: "+h1);
			Hai h2=new Hai();
			System.out.println("h2: "+h2);
			Hai h3=new Hai();
			System.out.println("h3.getClass(): "+h3.getClass());
			System.out.println("h3.hashCode(): "+h3.hashCode());
			h3=h2;
			Hello h4=new Hello(20);
			h4.show();
			System.out.println("h4.hashCode(): "+h4.hashCode());
			System.out.println("h2.getClass(): "+h2.getClass());
			System.out.println("h2.equals(h3): "+h2.equals(h3));
			System.out.println("h2.hashCode(): "+h2.hashCode());
			System.out.println("h3.hashCode(): "+h3.hashCode());
			Hello h5=new Hello(15);
			h5=h4.myclone();
			h5.show();
			System.out.println("h5.toString() "+h5.toString());
	
	
	
	
	
	}
}
/*
---------output---------
E:\Navin\lang\object>java Lab3
null
Hello@82ba41
*/
/*
**1.if a reference variable contains null then S.O.P(h1)=null;
**2.if a reference variable declare like this Hello h2=new Hello() then
	S.O.P(h2)=classname@hexadecimal number.
*/