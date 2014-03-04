package com.test.lang;

/*class A {
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
		System.out.println(a);
		System.out.println(cobj.q);
		System.out.println(cobj.bobj.p);
		System.out.println(cobj.bobj.aobj.x);
	}

	public Hello myClone() {
		Hello h = null;
		Object obj = null;
		try {
			obj = this.clone();
		} catch (CloneNotSupportedException c) {
			c.printStackTrace();
		}
		h = (Hello) obj;
		return h;
	}
}*/

public class CloneTest {
	public static void main(String as[]) {
		A aobj = new A(10);
		B bobj = new B(20, aobj);
		C cobj = new C(30, bobj);
		Hello h = new Hello(40, cobj);
		// h.show();

		/*
		 * System.out.println(h.cobj.bobj.aobj.x); h.cobj.bobj.aobj.x=100;
		 * System.out.println(h.cobj.bobj.aobj.x); Hello h1=h.myClone();
		 * System.out.println(h1.cobj.bobj.aobj.x); h1.cobj.bobj.aobj.x=1000;
		 * System.out.println(h1.cobj.bobj.aobj.x);
		 */

		System.out.println(h.cobj.q);
		h.cobj.q = 1000;
		System.out.println(h.cobj.q);
		Hello h1=null ; //h.clone();
		System.out.println(h1.cobj.q);
		h1.cobj.q = 2000;
		System.out.println(h1.cobj.q);

		System.out.println(h.equals(h1));
		System.out.println(h.cobj.equals(h1.cobj));
		System.out.println(h.cobj.bobj.equals(h1.cobj.bobj));
		System.out.println(h.cobj.bobj.aobj.equals(h1.cobj.bobj.aobj));
	}
}