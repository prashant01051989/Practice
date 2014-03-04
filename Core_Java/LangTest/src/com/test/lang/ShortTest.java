package com.test.lang;

public class ShortTest {

	public void test() {
		System.out.println("Short.MAX_VALUE :"+Short.MAX_VALUE);
		System.out.println("Short.MIN_VALUE :"+Short.MIN_VALUE);
		System.out.println("Short.TYPE :"+Short.TYPE);
		System.out.println("Short.SIZE :"+Short.SIZE);
		Short s1=new Short((short)200);
		System.out.println("s1 :"+s1);
		Short s2=new Short("200");
		System.out.println("s2 :"+s2);
		short s3=Short.parseShort("2000");
		System.out.println("s3 :"+s3);
		
		String st1=Short.toString(s2);		
		System.out.println("st1 :"+st1);
		Short s4=Short.valueOf((short)500);
		System.out.println("s4 :"+s4);
		Short s5=Short.valueOf("500");
		System.out.println("s5 :"+s5);
		System.out.println("Short.reverseBytes((short)5) :"+Short.reverseBytes((short)5));
		int i1=s2.intValue();
		System.out.println("i1 :"+i1);
		long l1=s2.longValue();
		System.out.println("l1 :"+l1);
		float f1=s2.floatValue();
		System.out.println("f1 :"+f1);
		byte b1=s2.byteValue();
		System.out.println("b1 :"+b1);
		short s6=s4.shortValue();
		System.out.println("s4 :"+s6);
	}

	public static void main(String[] args) {
		ShortTest st=new ShortTest();
		st.test();
	}

}
