package com.test.lang;

class ClassA{
	static {
		System.out.println("Static -ClassA");
	}
}

public class ClassTest {

	public static void main(String[] args) {
		ClassTest ct=new ClassTest();
		Class cl=ct.getClass();
		System.out.println(cl);
		System.out.println(cl.toString());
		System.out.println(int.class.toString());
		try {
			Class.forName("ClassA");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
