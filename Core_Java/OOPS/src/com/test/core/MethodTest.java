package com.test.core;

public class MethodTest {

	public MethodTest() {
		System.out.println("MethodTest- Constructor");
	}

	public void m1() {
		System.out.println("MethodTest-m1()");
		m3();
		m2(true);
		// m4(){}
		{
			System.out.println("M1 block");
		}
		// MethodTest();
		// static int s=10;
		final int f = 30;
	}

	// public static void m2(boolean b=true)) {
	public static void m2(boolean b) {
		System.out.println("MethodTest-m2()");
	}

	public void m3() {
		System.out.println("MethodTest-m3()");
		int i;
		//System.out.println(i);
		i=10;
		System.out.println(i);
	}

	/*
	 * private static void main(String[] args) {
	 * 
	 * }
	 */
	public static void main(String[] arg) {
		// m1();
		MethodTest mt = new MethodTest();
		 mt.m1();
		// m2();
	}

}
