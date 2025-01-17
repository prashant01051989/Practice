package com.thread.test;

public class PriorityDemo {

	public static void main(String[] args) {
		BlockingThread bt = new BlockingThread();
		bt.setPriority(Thread.NORM_PRIORITY + 1);
		
		CalculatingThread ct = new CalculatingThread();
		ct.start();
		bt.start();
		System.out.println("Main thread....");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		bt.setFinished(true);
		ct.setFinished(true);
		
		System.out.println("Main end");
	}
}

class CalculatingThread extends Thread {
	private boolean finished = false;

	public void run() {
		System.out.println("CalculatingThread start...");
		int sum = 0;
		
		while (!finished){
			//System.out.println(finished);
			sum=sum+1;
		}
		System.out.println("CalculatingThread end..."+sum);
	}

	public void setFinished(boolean f) {
		System.out.println("CalculatingThread setFinished ");
		finished = f;
	}
}

class BlockingThread extends Thread {
	private boolean finished = false;

	public void run() {
		while (!finished) {
			System.out.println("BlockingThread start...");
			try {
				int i;
				do {
					System.out.println("BlockingThread start 2...");
					i = System.in.read();
					System.out.print(i + " ");
				} while (i != '\n');
				System.out.print('\n');
			} catch (java.io.IOException e) {
			}
			
		
		}
		System.out.println("BlockingThread end...");
	
	}

	public void setFinished(boolean f) {
		System.out.println("BlockingThread setFinished ");
		finished = f;
	}
}
