class Lab2
{
	public static void main(String as[])
	{
		Student s1=new Student(12,"sri");
		Student s2=new Student(13,"Dande");
		Student s3=new Student(14,"Nivas");
		Student s4=new Student(12,"Sri");
		Student s5=new Student(12,"Sri");
		System.runFinalization();
		System.gc();
		s2=s1;
		Runtime rt= Runtime.getRuntime();
		rt.runFinalization();
		System.gc();
		s3=null;
		s4=new Student(78,"Dande");
		m1();
		System.runFinalization();
		System.gc();
	}
		public static void m1(){
		Student s1=new Student(45,"Srinivas");
		Student s2=new Student(12,"Srinivas");
		}	
}	
	
class Student{
int sid;
String sname;
public Student(){}
public Student(int sid,String sname){
this.sid=sid;
this.sname=sname;
}
	public void finalize(){
	System.out.println("in finalize():Resource released");
	}
}
