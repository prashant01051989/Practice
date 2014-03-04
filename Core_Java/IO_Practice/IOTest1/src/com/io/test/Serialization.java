package com.io.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Serialization {
	public static void main (String as[]){
	Employees harry = new Employees("Harry Hacker", 50000, 1989, 10, 1);
	/* Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
	 carl.setSecretary(harry);
	 Manager tony = new Manager("Tony Tester", 40000, 1990, 3, 15);
	 tony.setSecretary(harry);*/
	/* Employees[] staff = new Employees[3];
	 staff[0] = carl;
	 staff[1] = harry;
	 staff[2] = tony;*/
	 try{
		 FileOutputStream fos=new FileOutputStream("D:\\Employee");
		 ObjectOutputStream oos=new ObjectOutputStream(fos);
		 oos.writeObject(harry);
		 oos.close();
		 FileInputStream fis=new FileInputStream("D:\\Employee");
		 ObjectInputStream ois=new ObjectInputStream(fis);
		 Employees  staffs=(Employees) ois.readObject();
		 ois.close();
		System.out.println(staffs);
		 /*//staff[1].raiseSalary(20);
		 
		 for(Employees emp:staffs){
			 System.out.println(emp);
		 }*/
	 }catch(Exception e){
		 e.printStackTrace();
	 }
}
}

class Employees implements Serializable {
	private String name;
	private double salary;
	private Date hireDay;

	public Employees() {
		System.out.println("Employee.......def.......");
	}

	public Employees(String name, double salary, int year, int month, int day) {
		super();
		System.out.println("Employee.......Per.......");
		this.name = name;
		this.salary = salary;
		GregorianCalendar gc = new GregorianCalendar(year, month - 1, day);
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

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	public String toString() {
		return getClass().getName() + "[name=" + name + ",salary=" + salary
				+ ",hireDay=" + hireDay + "]";
	}
}
/*
class Manager extends Employees {
	private Employees secretary;

	public Manager(String n, double s, int year, int month, int day) {
		super(n, s, year, month, day);
		secretary = null;
	}

	public Employees getSecretary() {
		return secretary;
	}

	public void setSecretary(Employees secretary) {
		this.secretary = secretary;
	}

	public String toString() {
		return super.toString() + "[secretary=" + secretary + "]";
	}
}*/
