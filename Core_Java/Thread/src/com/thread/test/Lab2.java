package com.thread.test;

public class Lab2 {

	public static void main(String[] args) {
		System.out.println("Main()----------Started---------------");
		Hello hello1=new Hello("A");
		Hello hello2=new Hello("B");
		Hello hello3=new Hello("C");
		Thread t=Thread.currentThread();
		System.out.println(t);
		t.setName("Prashnat");
		for(int i=100;i<=105;i++){
			System.out.println(i+"   By "+ t.getName());
			try
			{
				//System.out.println("Main Thread sleep");
				Thread.sleep(500);
			}
			catch(Exception e){}
		}
		System.out.println("Main End");
	}

}

class Hello extends Thread{
	
	public  Hello(){}
	
	public  Hello(String name){
		super(name);
		start();
	}
	
	public void run(){
		for(int i=0;i<=5;i++){
			System.out.println(i+"  By  "+Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}