package com.thread.test;

public class ActiveCountTest {
	public static void main(String[] args) {
		Thread[] threads = new Thread[Thread.activeCount()];
		int n = Thread.enumerate(threads);
		System.out.println(n);
		for (int i = 0; i < n; i++)
			System.out.println(threads[i].toString());
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
		System.out.println(Thread.currentThread());
		System.out.println(Thread.currentThread().getId());
		System.out.println(Thread.currentThread().getState());
		System.out.println(Thread.currentThread().countStackFrames());
		Thread.dumpStack();
		System.out.println(Thread.State.RUNNABLE);
	}
}
