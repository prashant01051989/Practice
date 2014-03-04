class Lab1
{
	public static void main(String as[])
	{
		System.out.println("Main Begin");
		Thread t=Thread.currentThread();
		System.out.println(t);
		System.out.println(t.getName());
		System.out.println(t.getPriority());
		System.out.println(t.getThreadGroup());
		System.out.println("Main End");
	}
}