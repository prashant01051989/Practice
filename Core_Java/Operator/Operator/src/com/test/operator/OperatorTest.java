/*package com.test.operator;

interface Foo {
}

class A implements Foo {
}

class B extends A {
}

class C {
}

class Operator {

	public void arithmeticTest() {
		int x = 10;
		int y = 20;
		int z = x + y;
		byte b = 10;
		byte c = b;
		// ** byte d=b+c;
		byte d = (byte) (b + c);
		System.out.println(z);
		System.out.println("Anshu" + 20 + 30);
		System.out.println(20 + 30 + "Anshu ");
		System.out.println("Anshu" + (20 + 30));
		System.out.println(null == null);
		Operator op = null;
		boolean bol = op.equals(null);
		System.out.println(bol);
	}

	public void relationalTest() {
		int x = 10;
		int y = 20;
		A a = new A();
		A b = new A();
		System.out.println(x > y);
		System.out.println(true == true);
		System.out.println(true == false);
		// * System.out.println(true>false);
		System.out.println(a == b);
		// System.out.println(a>b);
		// System.out.println(x>a);
		System.out.println(5.0 > 5);
		System.out.println('a' > 44);

	}

	public void instanceofTest() {

		A a = new A();
		A b = new B();
		C c = new C();
		System.out.println("a instanceof Object :" + (a instanceof Object));
		System.out.println("a instanceof  A " + (a instanceof A));
		System.out.println("a instanceof  Foo :" + (a instanceof Foo));
		System.out.println("a instanceof  B :" + (a instanceof B));

		System.out.println("b instanceof Object :" + (b instanceof Object));
		System.out.println("b instanceof  A :" + (b instanceof A));
		System.out.println("b instanceof  B :" + (b instanceof B));
		System.out.println("b instanceof  Foo :" + (b instanceof Foo));

		// System.out.println("c instanceof  A :"+(c instanceof A));

		String st = "Prashant";
		String[] st1 = new String[5];
		st1[0] = "Anshu";
		System.out.println("st instanceof Object :" + (st instanceof Object));
		System.out.println("st instanceof String :" + (st instanceof String));

		// ** System.out.println(st1 instanceof Arrays);
		System.out.println(st1[0] instanceof String);
		System.out.println((st1 instanceof Object));
		// * System.out.println(st1 instanceof String);
		System.out.println("null instanceof String: "+(null instanceof String));
		//**System.out.println("null instanceof null: "+(null instanceof null));

	}

	public void increment_DecrementTest() {
		int x = 1;

		// System.out.println(x + x++ + ++x);
		// System.out.println(x);
		// System.out.println(++x * ++x + x++ + ++x);
		System.out.println(++x + x-- + x-- * ++x);
	}

	public void shortCircuitTest() {
		if ((isSmall(10)) && isSmall(5) | 4 > 3) {
			System.out.println("Result is true");
		} else {
			System.out.println("Result is false");
		}
	}

	public void nonShortCircuitTest() {
		if ((isSmall(10)) & isSmall(5)) {
			System.out.println("Result is true");
		} else {
			System.out.println("Result is false");
		}
	}

	

	private static boolean isSmall(int i) {
		if (i > 9) {
			System.out.println(i + " is greater than 9");
			return true;
		} else {
			System.out.println(i + " is smaller than 9");
			return false;
		}
	}
	
	public void conditionalTest() {
		int x = 10;
		int y = 20;
		String st = (x > y) ? "X is greate than Y " : "X is smaller than Y";
		System.out.println(st);
	}
	
	public void shiftTest(){
		int x=1;
		int y=-1;
		System.out.println(x>>1);
		System.out.println(y>>1);
		System.out.println(x<<1);
		System.out.println(y<<1);
		System.out.println(y>>>1);
		System.out.println(x>>>1);
	}

}

public class OperatorTest {
	public static void main(String[] args) {
		Operator op = new Operator();
		// op.arithmeticTest();
		// op.relationalTest();
		//op.instanceofTest();
		// op.increment_DecrementTest();
		// op.shortCircuitTest();
		// op.nonShortCircuitTest();
		// op.conditionalTest();
		op.shiftTest();
	}
}
*/