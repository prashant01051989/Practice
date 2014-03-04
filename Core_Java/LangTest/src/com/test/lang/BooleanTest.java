package com.test.lang;

public class BooleanTest {

	public void test() {
		System.out.println("Boolean.FALSE :" + Boolean.FALSE);
		System.out.println("Boolean.TRUE :" + Boolean.TRUE);
		System.out.println("Boolean.TYPE :" + Boolean.TYPE);
		Boolean bol = new Boolean(true);
		System.out.println("bole :" + bol);
		Boolean bol1 = new Boolean("true");
		System.out.println("bol1 :" + bol1);
		Boolean bol2 = Boolean.valueOf(true);
		System.out.println("bol2 :" + bol2);
		Boolean bol3 = Boolean.valueOf("true");
		System.out.println("bol3 :" + bol3);
		System.out.println("Boolean.parseBoolean(yes) :"+Boolean.parseBoolean("Yes"));
		System.out.println("Boolean.parseBoolean(true) :"+Boolean.parseBoolean("true"));
		System.out.println("Boolean.parseBoolean(null) :"+Boolean.parseBoolean(null));
		System.out.println("Boolean.parseBoolean(True) :"+Boolean.parseBoolean("True"));
		boolean bol4=bol3.booleanValue();
		System.out.println("bol4 :"+bol4);
		String st=Boolean.toString(bol4);
		System.out.println("st :"+st);
		String st1=bol3.toString();
		System.out.println("st1 :"+st1);
		System.out.println("bol3.equals(bol2) :"+bol3.equals(bol2));
		System.out.println("bol2.hashCode() :"+bol2.hashCode());
		
	}

	public static void main(String[] args) {
		BooleanTest bt = new BooleanTest();
		bt.test();

	}

}
