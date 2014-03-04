package ss;

class A2 extends Thread{
	A2(ThreadGroup tg,String name){
		super(tg,name);
		
	}
	synchronized  public void run(){
		for(int i=1;i<=5;i++){
			System.out.println("by "+Thread.currentThread().getName()+" under Group-"+Thread.currentThread().getThreadGroup().getName());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
	}
}
class B2 implements Runnable{
	B2(ThreadGroup tg){
		Thread t=new Thread(tg,this,"B2");
		Thread t1=new Thread(tg,this,"B4");
		t.start();
		t1.start();
		
	}
	public void run(){
		for(int i=1;i<=5;i++){
			System.out.println("by "+Thread.currentThread().getName()+" under Group-"+Thread.currentThread().getThreadGroup().getName());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		}
	}
}
class ThreadTest10 {
public static void main(String as[]){
ThreadGroup tg1=new ThreadGroup("OM1");
ThreadGroup tg2=new ThreadGroup("OM2");
A2 t=new A2(tg1,"T");
A2 t1=new A2(tg1,"T1");
t.start();
t1.start();
}
}
