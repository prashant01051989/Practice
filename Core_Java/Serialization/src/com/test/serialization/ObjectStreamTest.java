package com.test.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class ObjectStreamTest {

	public static void main(String[] args) throws IOException {
		Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		carl.setSecretary(harry);
		Manager tony = new Manager("Tony Tester", 40000, 1990, 3, 15);
		tony.setSecretary(harry);

		Employee[] staff = new Employee[3];

		staff[0] = carl;
		staff[1] = harry;
		staff[2] = tony;
		System.out.println("*********************Before Serialization**************");
		for (int i = 0; i < staff.length; i++) {
			System.out.println(staff[i]);
		}
		
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		
		try {
			String fileName="Employee.txt";
			String finalName="";
			String workingDir=System.getProperty("user.dir");
			finalName=workingDir+"\\"+fileName;
			fos=new FileOutputStream(finalName);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(staff);
			
			fis=new FileInputStream(finalName);
			ois=new ObjectInputStream(fis);
			Employee []newStaff=(Employee[]) ois.readObject();
			System.out.println("*********************After Desrialization**************");
			for (int i = 0; i < newStaff.length; i++) {
				System.out.println(newStaff[i]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(fos!=null)
				fos.close();
			if(oos!=null)
				oos.close();
		}

	}
}

class Employee implements Serializable {
	private String name;
	private Date hireDate;
	private double salary;

	public Employee() {
	}

	public Employee(String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		hireDate = calendar.getTime();
	}

	public String getName() {
		return name;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", hireDate=" + hireDate
				+ ", salary=" + salary + "]";
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

}

class Manager extends Employee {
	private Employee secretary;

	public Manager(String n, double s, int year, int month, int day) {
		super(n, s, year, month, day);
		secretary = null;
	}

	public void setSecretary(Employee secretary) {
		this.secretary = secretary;
	}

	@Override
	public String toString() {
		return "Manager [secretary=" + secretary + "]";
	}

}
