import java.io.*;
import java.util.Date;
class Employee implements Serializable 
{
	private int id;
	private String name;
	private float sal;
	private Date doj;
	Employee(int id ,String name,float sal,Date doj)
	{
		this.id=id;
		this.name=name;
		this.sal=sal;
		this.doj=doj;
	}
	void display()
	{
		System.out.println(id+"\t"+name+"\t"+sal+"\t"+doj);
	}
	static Employee getData()throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter emp id: ");
		int id=Integer.parseInt(br.readLine());
		System.out.println("Enter emp name: ");
		String name=br.readLine();
		System.out.println("Enter emp salary: ");
		float sal=Float.parseFloat(br.readLine());
		Date date=new Date();
		Employee e=new Employee(id,name,sal,date);
		return e;
	}
	
}