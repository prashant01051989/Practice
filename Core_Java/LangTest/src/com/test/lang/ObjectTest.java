package com.test.lang;


public class ObjectTest {
	public ObjectTest(){
		super();
	}
	
	public static void main(String[] args) {
		
		System.out.println(ObjectTest.class);
		ObjectTest ot=new ObjectTest();
		Class c=ot.getClass();
		System.out.println(c);
		System.out.println(int.class);
		System.out.println(void.class);
		System.out.println(ot.hashCode());
		System.out.println(ot.hashCode());
		System.out.println(ot.toString());
		System.out.println();
		
		
	}
	

}
