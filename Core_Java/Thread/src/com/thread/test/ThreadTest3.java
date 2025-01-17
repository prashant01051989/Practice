package com.thread.test;

public class ThreadTest3 {

	public static void main(String[] args) {
		HelloThread3 ht = new HelloThread3();
		new ThreadA("A", ht);
		new ThreadB("B", ht);
	}

}

class HelloThread3 {

	synchronized public void m1() {
		for (int i = 0; i < 5; i++) {
			System.out.println("m1()- " + i + " by "
					+ Thread.currentThread().getName());
			//m2();
		}
	}

	synchronized public void m2() {
		for (int i = 0; i < 5; i++) {
			System.out.println("m2()- " + i + " by "
					+ Thread.currentThread().getName());
		}
	}

	public void m3() {
		for (int i = 12; i <= 17; i++) {
			System.out.println("m3()- " + i + " by "
					+ Thread.currentThread().getName());
		}
	}
}

class ThreadA implements Runnable {
	HelloThread3 h;

	public ThreadA() {
	}

	public ThreadA(String name, HelloThread3 h) {
		this.h = h;
		Thread t = new Thread(this, name);
		t.start();
	}

	public void run() {
		this.h.m1();
	}
}

class ThreadB implements Runnable {
	HelloThread3 h;

	public ThreadB() {
	}

	public ThreadB(String name, HelloThread3 h) {
		this.h = h;
		Thread t = new Thread(this, name);
		t.start();
	}

	public void run() {
		this.h.m3();
	}
}
