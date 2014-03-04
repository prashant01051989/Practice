package com.test.core;

class Final {
	//static final int i;
	/*static final int i;
	i=100;*/
	static final int i=10;
	public void m1() {
		System.out.println("final m1()");
		System.out.println(i);
	}
}

public class FinalTest {

	public static void main(String[] args) {
		Final f=new Final();
		System.out.println(Final.i);
		
	}

}
