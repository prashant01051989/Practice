//Example using method level synchronization//
class Hello
{
	static synchronized  void m1()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println("m1()- "+i+" by "+Thread.currentThread().getName());
			try
			{
				Thread.sleep(500);
			}catch(Exception e){}
		}
	}
	synchronized  void m2()
	{
		for(int i=6;i<=11;i++)
		{
			System.out.println("m2()- "+i+" by "+Thread.currentThread().getName());
			try
			{
				Thread.sleep(500);
			}catch(Exception e){}
		}
	}
		 void m3()
	{
		for(int i=12;i<=17;i++)
		{
			System.out.println("m3()- "+i+" by "+Thread.currentThread().getName());
			try
			{
				Thread.sleep(500);
			}catch(Exception e){}
		}
	}
}

class A implements Runnable
{
	Hello h=null;
	A(Hello h,String name)
	{
		this.h=h;
		Thread t1=new Thread(this,name);
		t1.start();
		System.out.println(t1.getThreadGroup().getName());
		
	}
	public void run()
	{
		h.m1();
	}
}
class B implements Runnable
{
	Hello h=null;
	Hello h1=null;
	B(Hello h,Hello h1,String name)
	{
		this.h=h;
		this.h1=h1;
		Thread t2=new Thread(this,name);
		t2.start();
		System.out.println(t2.getThreadGroup().getName());
	
	}
	public void run()
	{
		//h.m2();
		h1.m1();
		//h.m3();
	}
}

class Lab6
{
	public static void main(String as[])
	{
		Hello h=new Hello();
		Hello h1=new Hello();
		new A(h,"A");
		new B(h,h1,"B");
		
	}
}


