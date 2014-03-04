package com.test.lang;

public class IntTest {

	public void test() {
		System.out.println("Integer.MAX_VALUE :" + Integer.MAX_VALUE);
		System.out.println("Integer.MAX_VALUE :" + Integer.MAX_VALUE);
		System.out.println("Integer.TYPE :" + Integer.TYPE);
		System.out.println("Integer.SIZE :" + Integer.SIZE);
		Integer i1 = new Integer(100);
		System.out.println("i1 :" + i1);
		Integer i2 = new Integer("200");
		System.out.println("i2 :" + i2);
		int i3 = Integer.parseInt("1258");
		System.out.println("i3 :" + i3);
		String st1 = Integer.toString(i2);
		System.out.println("st1 :" + st1);
		Integer i4 = Integer.valueOf("12369");
		System.out.println("i4 :" + i4);
		Integer i5 = Integer.valueOf(12369);
		System.out.println("i5 :" + i5);
		byte b1 = i2.byteValue();
		System.out.println("b1 :" + b1);
		short s6 = i2.shortValue();
		System.out.println("s4 :" + s6);
		int i6 = i2.intValue();
		System.out.println("i6 :" + i6);
		long l1 = i2.longValue();
		System.out.println("l1 :" + l1);
		float f1 = i2.floatValue();
		System.out.println("f1 :" + f1);
		String st2 = i1.toString();
		System.out.println("st2 :" + st2);
		System.out.println("Integer.reverse(1) :" + Integer.reverse(10000));
		System.out.println("Integer.bitCount(100) :" + Integer.bitCount(100));
		System.out.println(Integer.decode("1236"));
	}

	public static void main(String[] args) {
		IntTest it = new IntTest();
		it.test();
	}

}
