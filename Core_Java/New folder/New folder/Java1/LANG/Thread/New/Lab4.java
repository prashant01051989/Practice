class Lab4
{
	public static void main(String as[])throws Exception
	{
		System.out.println("Main Begin");
		Thread t=Thread.currentThread();
		System.out.println(t);
		t.setName("Prashant");
		t.setPriority(10);
		System.out.println("t.getPriority(): "+t.getPriority());
		System.out.println(t);
		boolean b=t.isAlive();
		System.out.println(b);
		for(int i=101;i<=105;i++)
		{
			System.out.println(i+" By "+ t.getName());
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e){}
		}
		System.out.println("Main End");
	}
}