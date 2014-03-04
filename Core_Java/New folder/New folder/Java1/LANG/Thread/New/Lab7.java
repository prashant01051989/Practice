class Hai 
{
	void m1()
	{
		System.out.println("This is an object of class Hai");
	}
}

class Hello
{
	Hai ha=new Hai();
	void m2(String hai)
	{
		synchronized(hai)
		{
			System.out.println("m2() begin by "+Thread.currentThread().getName());
			for(int i=0;i<=5;i++)
			{
				System.out.println(hai);
				ha.m1();
			}
			System.out.println("m2() End by "+Thread.currentThread().getName());
		}
	}
	
	void m3(String ha)	
	{
		synchronized(ha)
		{
			System.out.println("m3() begin by "+Thread.currentThread().getName());
			for(int i=0;i<=5;i++)
			{
				System.out.println(ha);
				//ha.m1();
			}
			System.out.println("m3() End by "+Thread.currentThread().getName());
		}
	}
}

class A implements Runnable
{
	Hello he=null;
	String ha=null;
	A(Hello he,String ha)
	{
		Thread t1=new Thread(this,"A");
		this.he=he;
		this.ha=ha;
		t1.start();
	}
	public void run()
	{
		he.m3("ANSHU");
	}
}
class B implements Runnable
{
	Hello he=null;
	String ha=null;

	B(Hello he,String ha)
	{
		Thread t2=new Thread(this,"B");
		this.he=he;
		this.ha=ha;
		t2.start();
	}
	public void run()
	{
		he.m2("PRASHANT");
	}
}

class Lab7
{
	public static void main(String as[])
	{

		String st="PRASHANT";
		Hello he=new Hello();
		new A(he,st);
		new B(he,st);
	}
}