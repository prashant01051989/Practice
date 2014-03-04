package com.test.core;

class VariableA{
	int a;
	int b;
	String c;
	static String st;
	static int i;
	
}

public class VariableTest {
	
	public static void main(String[] args) {
		//System.out.println(a);
		VariableA v=new VariableA();
		System.out.println(v.a);
		System.out.println(v.c);
		//System.out.println(st);
		System.out.println(v.st);
		VariableA va=null;
		System.out.println(va.st);
		System.out.println(VariableA.st);
	}

}
