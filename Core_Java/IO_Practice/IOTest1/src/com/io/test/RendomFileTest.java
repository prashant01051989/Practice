package com.io.test;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class RendomFileTest {
public static void main(String as[]){
	Employee [] staff=new Employee[3];
	staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
	staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
	staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
	try{
		DataOutputStream dos=new DataOutputStream(new FileOutputStream("D:\\emp.txt"));
		for(Employee e:staff)
			e.writeData(dos);
		dos.close();
		RandomAccessFile in=new RandomAccessFile("D:\\emp.txt","r");
		//System.out.println(in.length());
		int n=(int)(in.length()/Employee.RECORD_SIZE);
		Employee[] newStaff=new Employee[n];
		for(int i=n-1;i>=0;i--){
			newStaff[i]=new Employee();
			in.seek(i*Employee.RECORD_SIZE);
			newStaff[i].readData(in);
		}
		
		in.close();
		for (Employee e : newStaff)
			 System.out.println(e);
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
}
}

class Employee{
	private String name;
	private double salary;
	private Date hireDay;
	public static final int NAME_SIZE=2;
	public static final int RECORD_SIZE=2*NAME_SIZE+8+4+4+4;
	public Employee(){}
	
	public Employee(String name, double salary, int year, int month, int day) {
		super();
		this.name = name;
		this.salary = salary;
		GregorianCalendar gc=new GregorianCalendar(year,month-1,day);
		this.hireDay = gc.getTime();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getHireDay() {
		return hireDay;
	}
	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}
	public String toString()
	 {
		 return getClass().getName()
		 + "[name=" + name
		 + ",salary=" + salary
		 + ",hireDay=" + hireDay
		 + "]";
	 }
	public void writeData(DataOutputStream out) throws IOException{
		DataIO.writeFixedString(name,NAME_SIZE,out);
		//out.writeUTF(name);
		out.writeDouble(salary);
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(hireDay);
		out.writeInt(calendar.get(Calendar.YEAR));
		out.writeInt(calendar.get(Calendar.MONTH) + 1);
		out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
	}
	public void readData(RandomAccessFile in) throws IOException {
		name = DataIO.readFixedString(NAME_SIZE, in);
		//name=in.readUTF();
		salary = in.readDouble();
		int y = in.readInt();
		int m = in.readInt();
		int d = in.readInt();
		GregorianCalendar calendar = new GregorianCalendar(y, m - 1, d);
		hireDay = calendar.getTime();
		
	}
}

class DataIO
 {
 public static String readFixedString(int size, DataInput in)
 throws IOException
 {
 StringBuilder b = new StringBuilder(size);
 int i = 0;
 boolean more = true;
 while (more && i < size)
 {
 char ch = in.readChar();
 i++;
 if (ch == 0) 
	 more = false;
 else 
	 b.append(ch);
 }
in.skipBytes(2 * (size - i));
 return b.toString();
 }

 public static void writeFixedString(String s, int size, DataOutput out)
 throws IOException
 {
	 for (int i = 0; i < size; i++)
	 {
		 char ch = 0;
		 if (i < s.length()) 
		 ch = s.charAt(i);
		 
		 out.writeChar(ch);
	 }
 }
}