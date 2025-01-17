package com.thread.test;

public class DeadLockTest {

	public static void main(String[] args) {
		 String st1 = "A";
		 String st2 = "B";
		Thread t1 = new TransThread1("A",st1,st2);
		Thread t2 = new TransThread1("B",st1,st2);
	}
}

class TransThread1 extends Thread {
	private String st1 ="";
	private String st2 = "";

	public TransThread1(String name,String st1,String st2) {
		super(name);
		
		this.st1=st1;
		this.st2=st2;
		start();
	}

	public void run() {
		for(int i=0;i<500;i++){
			
			if (getName().endsWith("A")) {
				synchronized (st1) {
					synchronized (st2) {
						System.out.println("A");
					}
				}
			} else {
				synchronized (st2) {
					synchronized (st1) {
						System.out.println("B");
					}
				}
			}
		}
	}
}
