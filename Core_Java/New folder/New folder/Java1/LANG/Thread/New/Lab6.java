//Example using block level synchronization//

import java.util.ArrayList;

class Hello
{
	void m1(ArrayList al)
	{
		synchronized(al)
		{
			System.out.println("m1 begin by"+Thread.currentThread().getName());
			for(int i=0;i<al.size();i++)
			{
				System.out.println(al.get(i) +" by "+Thread.currentThread().getName());
				try
				{
					Thread.sleep(500);
				}catch(Exception e){}
			}
			System.out.println("m1 end by"+Thread.currentThread().getName());
		}
	}
	void m2(ArrayList al)
	{
		synchronized(al)
		{
			System.out.println("m2 begin by"+Thread.currentThread().getName());
			for(int i=0;i<al.size();i++)
			{
				System.out.println(al.get(i)+" by "+Thread.currentThread().getName());
				try
				{
					Thread.sleep(500);
				}catch(Exception e){}
			}
			System.out.println("m2 end by"+Thread.currentThread().getName());
		}
	}
}
class A implements Runnable
{
	Hello h=null;
	ArrayList al=null;
	A(Hello h,ArrayList al)
	{
		Thread t=new Thread(this,"A");
		this.h=h;
		this.al=al;
		t.start();
	}
	public void run()
	{
		h.m2(al);
	}
}
class B implements Runnable
{
	Hello h=null;
	ArrayList al=null;
	B(Hello h,ArrayList al)
	{
		Thread t=new Thread(this,"B");
		this.h=h;
		this.al=al;
		t.start();
	}
	public void run()
	{
		h.m1(al);
	}
}
class Lab6
{
	public static void main(String as[])
	{
		ArrayList al=new ArrayList();
		al.add("11");
		al.add("22");
		al.add("33");
		al.add("44");
		al.add("55");
		Hello h=new Hello();
		new A(h,al);
		new B(h,al);
	}
}
