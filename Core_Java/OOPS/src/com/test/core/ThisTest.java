package com.test.core;

class This {
	int a = 10;
	int b = 20;

	public This() {
		this(1000, 2000);
		System.out.println("This def-con");

	}

	public This(int a, int b) {
		System.out.println("This 2 -arg cons");
		this.a = a;
		this.b = b;
		System.out.println(a);
		System.out.println(b);
		System.out.println(this);
		// this=new ThisTest();
		System.out.println(this.getClass());
	}

	public void m1() {
		// this();
		int a = 100;
		int b = 200;
		System.out.println(a);
		System.out.println(b);
		System.out.println(this.a);
		System.out.println(this.b);
	}

}

public class ThisTest {

	public static void main(String[] args) {
		This t = new This();
		t.m1();
		// System.out.println(this);
	}

}
