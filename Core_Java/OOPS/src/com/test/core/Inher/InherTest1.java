package com.test.core.Inher;

class Inher1A {

	int a = 10;

	static {
		System.out.println("Inher1A- static block");
	}
	{
		System.out.println("Inher1A- instance block");
	}

	public Inher1A() {
		System.out.println("Inher1A -def con");
	}

	static int b = 20;
}

class Inher1B extends Inher1A {
	int c = 100;
	static int d = 200;

	public Inher1B() {
		super();
		System.out.println("Inher1B -def con");
	}

	static {

		System.out.println("Inher1B- static block");
	}
	{
		System.out.println("Inher1B- instance block");
	}
}

public class InherTest1 {

	public static void main(String[] args) {
		// Inher1A ia = new Inher1A();
		Inher1B ib = new Inher1B();
	}

}
