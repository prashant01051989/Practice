package com.thread.test;

public class NeedForSynchronizationDemo {

	public static void main(String[] args) {
		FinTrans ft = new FinTrans();
		TransThread tt1 = new TransThread(ft, "DepositeThread");
		TransThread tt2 = new TransThread(ft, "Withdrawal Thread");
		tt1.start();
		tt2.start();
		
	}

}

class FinTrans {
	public static String transName;
	public static double amount;
	synchronized public void update(String transName,double amount){
		this.transName=transName;
		this.amount=amount;
		System.out.println(this.transName + "  " + this.amount);
	}
	
}

class TransThread extends Thread {
	private FinTrans ft;

	public TransThread(FinTrans ft, String name) {
		super(name);
		this.ft = ft;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			if (getName().equals("DepositeThread")) {
				ft.update("Deposit", 2500);
			}else {
				ft.update("WithDrawal", 2000);
	
			}
		}
	}
}