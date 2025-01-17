package com.thread.test;

public class PushPopTest1 {

	public static void main(String[] args) {
		System.out.println("Main Begin......");
		Stack1 st = new Stack1();
		HelloThread1 hello = new HelloThread1(st, "HelloThread");
		HaiThread1 hai = new HaiThread1(st, "HaiThread");
		System.out.println("Main End--------------");
	}

}

class Stack1 {
	int x;
	boolean bol=false;
	synchronized public void push(int i) {
		if(bol){
			try {
				wait();
			} catch (InterruptedException e) {
					e.printStackTrace();
			}
		}
		this.x = i;
		System.out.println(i + "  is pushed by HelloThread");
		bol=true;
		notify();
	}

	synchronized public int pop() {
		if(!bol){
			try {
				wait();
			} catch (InterruptedException e) {
					e.printStackTrace();
			}
		}
		System.out.println(x + " is poped by HaiThread ");
		
		bol=false;
		notify();
		return x;
		
	}
}

class HelloThread1 implements Runnable {
	Stack1 st = null;

	public HelloThread1() {}

	public HelloThread1(Stack1 st, String name) {
		this.st = st;
		Thread t = new Thread(this, name);
		t.start();
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			st.push(i);
			

		}
	}
}

class HaiThread1 extends Thread {
	Stack1 st = null;

	public HaiThread1() {}

	public HaiThread1(Stack1 st, String name) {
		super(name);
		this.st = st;
		start();
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			 st.pop();
			

		}
	}
}
