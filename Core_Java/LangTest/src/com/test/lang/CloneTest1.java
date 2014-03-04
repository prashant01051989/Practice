package com.test.lang;

class A {
	int x;

	A(int x) {
		this.x = x;
	}
}

class B {
	int p;
	A aobj;

	B(int p, A aobj) {
		this.p = p;
		this.aobj = aobj;
	}
}

class C {
	int q;
	B bobj;

	C(int q, B bobj) {
		this.q = q;
		this.bobj = bobj;
	}
}

class Hello implements Cloneable {
	int a;
	C cobj;

	Hello() {
	}

	Hello(int a, C cobj) {
		this.a = a;
		this.cobj = cobj;
	}

	void show() {
		System.out.println(a +" \t"+cobj.q+" \t"+cobj.bobj.p+" \t"+cobj.bobj.aobj.x);		
	}

	@Override
	public Hello clone() throws CloneNotSupportedException {
			return (Hello) super.clone();		
	}

	/*
	 * public Hello myClone() { Hello h = null; Object obj = null; try { obj =
	 * this.clone(); } catch (CloneNotSupportedException c) {
	 * c.printStackTrace(); } h = (Hello) obj; return h; }
	 */
}

/*
 * class First implements Cloneable {
 * 
 * public First() { System.out.println("First def con"); }
 * 
 * public Object clone() { System.out.println("First clone method"); try {
 * return super.clone(); } catch (CloneNotSupportedException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); } } }
 * 
 * class Second extends First implements Cloneable {
 * 
 * int a;
 * 
 * public Second() { System.out.println("Second def con"); }
 * 
 * public Second(int a) { System.out.println("Second 1 arg con"); this.a = a; }
 * 
 * @Override public Object clone() { System.out.println("Second clone method");
 * return super.clone(); }
 * 
 * 
 * public Second myClone() { Second s = null; Object obj = null; try { obj =
 * super.clone(); } catch (CloneNotSupportedException c) { c.printStackTrace();
 * } s = (Second) obj; return s; }
 * 
 * }
 */

public class CloneTest1 {
	public static void main(String as[]) throws CloneNotSupportedException {
		A aobj = new A(10);
		B bobj = new B(20, aobj);
		C cobj = new C(30, bobj);
		Hello h = new Hello(40, cobj);
		Hello h1=h.clone();
		h.show();
		h1.show();
		System.out.println("**************************");
		h1.a=2000;
		h.show();
		h1.show();
		System.out.println("**************************");
		h.cobj.q=123;
		h.show();
		h1.show();
		
		
	}
}