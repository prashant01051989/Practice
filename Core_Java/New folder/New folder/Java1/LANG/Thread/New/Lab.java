class NameRunnable implements Runnable
{
	NameRunnable(){}
	
	public void run() 
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println("Run by "+ Thread.currentThread().getName());
			try
			{
				Thread.sleep(500);
			}
			catch (InterruptedException ex) { }
		}
	}
}

public class Lab
{
	public static void main (String [] args)
	{
		System.out.println("Main Begin");
		Runnable nr = new NameRunnable();
		Thread t = new Thread(nr,"D");
		Thread t1 = new Thread(nr,"C");
		Thread t2 = new Thread(nr,"A");
		int j=Thread.activeCount();
		System.out.println("Thread.activeCount() :"+j);
		t.start();
		j=Thread.activeCount();
		System.out.println("Thread.activeCount() :"+j);
		t1.start();
		String st=t1.toString();
		System.out.println("t1.toString() :"+st);
		t2.start();
		j=Thread.activeCount();
		System.out.println("Thread.activeCount() :"+j);
		for(int i=1;i<=5;i++)
		{
			System.out.println(Thread.currentThread().getName());
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException ex){}
		}

		System.out.println("Main End");
	}
}