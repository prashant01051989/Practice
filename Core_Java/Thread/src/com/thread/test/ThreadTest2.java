package com.thread.test;

public class ThreadTest2 {

	public static void main(String[] args) {
		MyThread2 mt=new MyThread2();
		mt.start();
		for(int i=0;i<50;i++){
			System.out.println ("i = " + i + ", i * i = " + i * i);
		}
		System.out.println("mt.isAlive() :"+mt.isAlive());
		mt.start();
	}

}


class MyThread2 extends Thread{
	
	public void run(){
		for(int count=1,row=1;row<20;row++,count++){
			for(int i=0;i<count;i++)
				System.out.print("*");
			System.out.println();
		}
	}
}
