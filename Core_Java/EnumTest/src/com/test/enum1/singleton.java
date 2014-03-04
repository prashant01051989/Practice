package com.test.enum1;

public enum singleton{
	Instance;
	void m1(){
		System.out.println("It is singleton Object");
	}
	
	public static void main(String[] args) {
		singleton s=singleton.Instance;
		System.out.println(s);
		s.m1();
	}
}
