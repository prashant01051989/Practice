package com.thread.test;

public class ThreadTest1 {

	public static void main(String[] args) {
		Thread t=new Thread();
		System.out.println(t);
		System.out.println("Thread.activeCount(): " +Thread.activeCount());
		Thread t2=Thread.currentThread();
		System.out.println("Thread.currentThread() :"+t2);
		System.out.println("t2.isAlive() :"+t2.isAlive());
		System.out.println("t2.getName() :"+t2.getName());
		System.out.println("t2.getId() :"+t2.getId());
		System.out.println("t2.getPriority(): "+t2.getPriority());
		System.out.println("t2.getThreadGroup() :"+t2.getThreadGroup());
	}

}
