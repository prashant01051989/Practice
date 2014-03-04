package com.thread.test;

public class ThreadNameTest {

	public static void main(String[] args) {
		NameThread nt = new NameThread("Anshu");
		nt.start();
		NameThread nt1 = new NameThread();
		nt1.start();
	}
}

class NameThread extends Thread {

	public NameThread() {
	}

	public NameThread(String name) {
		super(name);
		//setName(name);
	}

	public void run() {
		System.out.println("getName() :" + getName());
	}
}
