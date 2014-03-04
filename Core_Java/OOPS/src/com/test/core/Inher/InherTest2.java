package com.test.core.Inher;

class Inher2A {
	static int b = 20;
	int a = 10;

	public void inher2A_M1() {
		System.out.println("inher2A_M1 Instance Method");
		System.out.println("a: " + a);
	}

	public static void inher2A_M2() {
		System.out.println("inher2A_M2 Static Method");
		System.out.println("b: " + b);
	}

}

class Inher2B extends Inher2A {
	int c = 100;
	static int d = 200;

	public void inher2B_M1() {
		System.out.println("Inher2B--M1()");
		System.out.println("a: " + a);
		System.out.println("c: " + c);
	}

	public static void inher2B_M2() {
		System.out.println("inher2B_M2 Static Method");
		System.out.println("b: " + b);
		System.out.println("d: " + d);
	}
}

public class InherTest2 {

	public static void main(String[] args) {
		Inher2A ia = new Inher2A();
		Inher2A.inher2A_M2();
		ia.inher2A_M1();
		Inher2B ib = new Inher2B();
		Inher2B.inher2B_M2();
		ib.inher2B_M1();
		Inher2B.b = 200;
		Inher2A.inher2A_M2();
		Inher2B.inher2B_M2();
		ib.a = 100;
		ia.inher2A_M1();
		ib.inher2B_M1();

	}

}
