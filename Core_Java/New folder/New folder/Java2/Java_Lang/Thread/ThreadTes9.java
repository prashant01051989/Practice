package ss;

import java.util.ArrayList;

class Hee{

	 void m1(ArrayList<String> al) {
	synchronized (al) {
		System.out.println("m1- begin"+" By "+Thread.currentThread().getName());
	 for(int i=1;i<al.size();i++){
		System.out.println(al.get(i)+" By "+Thread.currentThread().getName());
		try {
			Thread.sleep(500);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
	}
	System.out.println("m1- end"+" By "+Thread.currentThread().getName());
 }
	 void m2(ArrayList<String> al) {
			 synchronized  (al) {
				System.out.println("m2- begin"+" By "+Thread.currentThread().getName());
			 for(int i=1;i<al.size();i++){
				System.out.println(al.get(i)+" By "+Thread.currentThread().getName());
				try {
					Thread.sleep(500);
					} catch (InterruptedException e) {
					e.printStackTrace();
					}
				}
			}
			System.out.println("m2- end"+" By "+Thread.currentThread().getName());
		 }
}

class A1 implements Runnable{
	Hee h=null;
	ArrayList<String> al=null;
	A1(Hee h,ArrayList<String> al){
		this.h=h;
		this.al=al;
		Thread t=new Thread(this);
		t.start();
		System.out.println(Thread.currentThread().getName());
	}
	public void run() {
		h.m2(al);		
	}
}
class B1 implements Runnable{
	Hee h=null;
	ArrayList<String> al=null;
	B1(Hee h,ArrayList<String> al){
		this.h=h;
		this.al=al;
		Thread t=new Thread(this);
		t.start();
		System.out.println(Thread.currentThread().getName());
	}
	public void run() {
		h.m1(al);		
	}
}


class ThreadTes9 {
public static void main(String as[]){
ArrayList<String> al=new ArrayList<String>();
al.add("11");
al.add("22");
al.add("33");
al.add("44");
al.add("55");
Hee h=new Hee();
new A1(h,al);
new B1(h,al);
}
}
