package ss;

class Hello{

	synchronized  void m1() {
	for(int i=1;i<=5;i++){
		System.out.println("m1- "+i+" By "+Thread.currentThread().getName());
		try {
			Thread.sleep(500);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
	}
	
	synchronized  void m2() {
		for(int i=1;i<=5;i++){
			System.out.println("m2- "+i+" By "+Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class A implements Runnable{
	Hello h=null;
	A(Hello h,String name){
		this.h=h;
		Thread t=new Thread(this,name);
		t.start();
		System.out.println(Thread.currentThread().getName());
	}
	public void run() {
		h.m2();		
	}
}
class B implements Runnable{
	Hello h=null;
	B(Hello h,String name){
		this.h=h;
		Thread t=new Thread(this,name);
		t.start();
		System.out.println(Thread.currentThread().getName());
	}
	public void run() {
		h.m1();		
	}
}


class ThreadTest8 {
public static void main(String as[]){
Hello h=new Hello();
new B(h,"B");
new A(h,"A");
}
}
