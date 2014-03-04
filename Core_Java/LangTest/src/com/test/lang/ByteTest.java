package com.test.lang;

public class ByteTest {
	
	public void test(){
		System.out.println("Byte.MAX_VALUE  :"+Byte.MAX_VALUE);
		System.out.println("Byte.MIN_VALUE  :"+Byte.MIN_VALUE);
		System.out.println("Byte.TYPE  :"+Byte.TYPE);
		System.out.println("Byte.SIZE  :"+Byte.SIZE);
		Byte b1=new Byte((byte)10);
		System.out.println("b1 :"+b1);
		Byte b2=new Byte("100");
		System.out.println("b2 :"+b2);
		String s1=Byte.toString(b1);
		System.out.println("s1 :"+s1);
		String s2=b2.toString();
		System.out.println("s2 :"+s2);
		Byte b3=Byte.valueOf((byte)120);
		System.out.println("b3 :"+b3);
		Byte b4=Byte.valueOf("120");
		System.out.println("b4 :"+b4);
		//byte b4=Byte.parseByte("12s3");
		byte b5=Byte.parseByte("123");
		System.out.println("b5 :"+b5);
		byte b6=Byte.parseByte("-125");
		System.out.println("b6 :"+b6);
		short short1=b2.shortValue();
		System.out.println("short1 :"+short1);
		int i1=b2.intValue();
		System.out.println("i1 :"+i1);
		long l1=b2.longValue();
		System.out.println("l1 :"+l1);
		float f1=b2.floatValue();
		System.out.println("f1 :"+f1);
		byte b7=b2.byteValue();
		System.out.println("b7 :"+b7);
		System.out.println("b1.equals(b2) :"+b1.equals(b2));
		
		
	}
	public static void main(String[] args) {
		ByteTest b=new ByteTest();
		b.test();
	}

}
