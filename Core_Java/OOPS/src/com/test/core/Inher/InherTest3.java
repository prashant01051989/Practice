package com.test.core.Inher;

import java.util.ArrayList;
import java.util.List;

class Inher3A {
	int a = 10;
	static int b = 20;

	public void inher3A_M1() {
		System.out.println("inher3A_M1 Instance Method");
		System.out.println("a: " + a);
	}

	public static void inher3A_M2() {
		System.out.println("inher3A_M2 Static Method");
		System.out.println("b: " + b);
	}

}

class Inher3B extends Inher3A {
	int a = 100;
	static int b = 200;

	public void inher3B_M1() {
		int a=1000;
		System.out.println("Inher3B--M1()");
		System.out.println("a: " + a);
		System.out.println("this.a: " + this.a);
		System.out.println("super.a: " + super.a);
	}

	public static void inher3B_M2() {
		int b=2000;
		System.out.println("inher3B_M2 Static Method");
		System.out.println("b: " + b);
		System.out.println("Inher3B.b: " + Inher3B.b);
		System.out.println("Inher3A.b: " + Inher3A.b);
	}
	public void inher3B_M3(int a){
		System.out.println("inher3B_M3 Static Method");
		super.a=a;
	}
}

public class InherTest3 {

	public static void main(String[] args) {
		Inher3A.inher3A_M2();
		Inher3A ia = new Inher3A();
		ia.inher3A_M1();
		Inher3B.inher3B_M2();
		Inher3B ib = new Inher3B();
		ib.inher3B_M1();
		Inher3B.b = 200;
		Inher3A.b=20000;
		Inher3A.inher3A_M2();
		Inher3B.inher3B_M2();
		ib.a =1000;
		ib.inher3B_M3(500);
		ib.inher3B_M1();
		List<String> li=new ArrayList<String>();
		li.contains("AAA");
		"sTRING".equals("SS");
		
	}

}
