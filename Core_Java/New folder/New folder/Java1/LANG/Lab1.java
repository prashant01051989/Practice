class Student
{
	private int sid;
	private String sname;
	public Student(int sid,String sname)
	{
		this.sid=sid;
		this.sname=sname;
	}
	public void finalize()
	{
		System.out.println("in fianlize():-Resource released");
	}
}
class Lab1
{
	public static void main(String as[])
	{
		Student s1=new Student(12,"Sri");
		Student s2=new Student(13,"Dande");
		Student s3=new Student(14,"Nivas");
		Student s4=new Student(12,"Sri");
		Student s5=new Student(12,"Sri");
		System.runFinalization();
		System.gc();
		s2=s1;
		System.runFinalization();
		System.gc();
		s3=null;
		s4=new Student(78,"Dande");
		m1();
		System.runFinalization();
		System.gc();
		
	}

	public static void m1()
	{
		Student s1=new Student(45,"Srinivas");
		Student s2=new Student(45,"Srinivas");
	}
}

/*
------output------
E:\Navin\lang\GC>java Lab1
in fianlize():-Resource released
in fianlize():-Resource released
in fianlize():-Resource released
in fianlize():-Resource released
in fianlize():-Resource released
*/