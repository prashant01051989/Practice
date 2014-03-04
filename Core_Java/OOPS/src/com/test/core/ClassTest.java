package com.test.core;

//public class ClassA{}
class ClassA {
	static int a;
	final static int b = 0;
	static {
		System.out.println("ClassA -static block");
	}
	{
		System.out.println("ClassA - instance block");
	}

	public ClassA() {
		System.out.println("ClassA- Def Con");
	}
}

public class ClassTest {

	public static void main(String[] args) {
		ClassA a;
		ClassA a1 = null;
		// System.out.println(ClassA.a);
		// System.out.println(ClassA.b);
		ClassA a2 = new ClassA();

	}

}
