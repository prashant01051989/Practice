package aa;

class Stack{
	int x;
	void push(int a){
		x=a;
	}
	int pop(){
		return x;
	}
}

class ThreadA implements Runnable{
	Stack st=null;
	public ThreadA(Stack st,String name){
		this.st=st;
		Thread t=new Thread(this,name);
		t.start();
	}
	public void run() {
		for(int i=1;i<=5;i++){
			st.push(i);
			System.out.println(i+" is pushed by "+Thread.currentThread().getName());
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		
	}
}
class ThreadB implements Runnable{
	Stack st=null;
	public ThreadB(Stack st,String name){
		this.st=st;
		Thread t=new Thread(this,name);
		t.start();
		run();
	}
	public void run() {
		for(int i=1;i<=5;i++){
			int x=st.pop();
			System.out.println(x+" is poped by "+Thread.currentThread().getName());
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}
public class ThreadTest4 {

	public static void main(String[] args) {
		Stack st=new Stack();
		ThreadA ta=new ThreadA(st,"A");
		ThreadB tb=new ThreadB(st,"B");
	}

}
