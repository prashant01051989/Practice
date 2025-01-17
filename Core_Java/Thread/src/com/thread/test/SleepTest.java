package com.thread.test;

public class SleepTest {

	public static void main(String... args) {
		System.out.println("Main Started...............");
		SleepThread st = new SleepThread();
		st.start();
		//while(st.isAlive())
		try {
			//Thread.sleep(10);
			st.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("PI :"+st.pi);
	}

}

class SleepThread extends Thread {
	boolean negative = true;
	double pi; // Initializes to 0.0, by default

	public void run() {
		for (int i = 3; i < 1000000000; i += 2) {
			if (negative)
				pi -= (1.0 / i);
			else
				pi += (1.0 / i);
			negative = !negative;
		}
		pi += 1.0;
		pi *= 4.0;
		
		System.out.println("Finished calculating PI.................");
	}
}
