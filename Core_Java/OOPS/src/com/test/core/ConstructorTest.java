package com.test.core;

public class ConstructorTest {

	public ConstructorTest() {
		System.out.println("ConstructoTest -def con");
		m1();
		int i = 10;
		System.out.println(i);
		{
			System.out.println("ConstructorTest()-method block");
		}
		m2();
	}

	public void m1() {
		System.out.println("ConstructorTest-m1()");
	}

	// public void static m2(){
	public static void m2() {
		System.out.println("ConstructorTest-m2()");
	}

	public static void main(String[] args) {
		// ConstructorTest();
		ConstructorTest ct = new ConstructorTest();
		
	}

}
