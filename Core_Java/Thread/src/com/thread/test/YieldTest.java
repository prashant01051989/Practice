package com.thread.test;

public class YieldTest extends Thread {

	static boolean finished = false;
	static int sum = 0;

	public static void main(String[] args) {
	YieldTest t1=	new YieldTest();
	t1.setPriority(6);
	t1.start();
		for (int i = 1; i <= 50; i++) {
			sum++;
			System.out.println(">>>>>>>>>>>>>>>"+sum);
			/*if (args.length == 0)
				Thread.yield();*/
		}
		finished = true;
	}

	public void run() {
		
		while (!finished)
			System.out.println("sum = " + sum);
	}

}