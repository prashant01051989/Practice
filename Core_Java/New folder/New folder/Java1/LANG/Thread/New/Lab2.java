class HelloThread extends Thread
{
	public HelloThread(String tname)
	{
		super(tname);
		start();
	}
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println(i+" By "+ Thread.currentThread().getName());
			try
			{
				//System.out.println(" Thread sleep");
				Thread.sleep(500);
			}
			catch(Exception e){}
		}
	}
}
 
class Lab2
{
	public static void main(String as[])throws Exception
	{
		System.out.println("Main Begin");
		HelloThread h1=new HelloThread("A");
		HelloThread h2=new HelloThread("B");
		HelloThread h3=new HelloThread("C");
		Thread t=Thread.currentThread();
		System.out.println(t);
		t.setName("Prashant");
		for(int i=101;i<=105;i++)
		{
			System.out.println(i+" By "+ t.getName());
			try
			{
				//System.out.println("Main Thread sleep");
				Thread.sleep(500);
			}
			catch(Exception e){}
		}
		System.out.println("Main End");
	}
}