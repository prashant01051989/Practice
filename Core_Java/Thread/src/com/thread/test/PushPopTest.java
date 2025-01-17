package com.thread.test;

public class PushPopTest {
	
	public static void main(String[] args) {
		System.out.println("Main Begin......");
		Stack st=new Stack();
		HelloThread hello=new HelloThread(st,"HelloThread");
		HaiThread hai=new HaiThread(st,"HaiThread");
		System.out.println("Main End--------------");
	}

}

class Stack{
	int x;
	public void push(int i){
		this.x=i;
	}
	public int pop(){
		return x;
	}
}

class HelloThread implements Runnable{
	Stack st=null;
	public HelloThread(){}
	public HelloThread(Stack st,String name){
		this.st=st;
		Thread t=new Thread(this,name);
		t.start();
	}
	public void run(){
		for(int i=0;i<5;i++){
			st.push(i);
			System.out.println(i +"  is pushed by HelloThread");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}

class HaiThread extends Thread {
	Stack st=null;
	
	public HaiThread(){}
	public HaiThread(Stack st,String name){
		super(name);
		this.st=st;
		start();
	}
	
	public void run(){
		for(int i=0;i<5;i++){
			int x=st.pop();
			System.out.println(x+" is poped by HaiThread ");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
