package com.thread.test;

public class UserDaemonThreadDemo {

	public static void main(String[] args) {

		if (args.length == 0) {
			new Daemon().start();
		} else {
			Daemon d = new Daemon();
			d.setDaemon(true);
			d.start();
			
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Daemon extends Thread {
	public void run() {
		System.out.println("Demon :" + isDaemon());
		while (true){
			System.out.println("While");
		}
	}
}
