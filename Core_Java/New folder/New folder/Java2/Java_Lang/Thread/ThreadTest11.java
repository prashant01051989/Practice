package ss;

class Stack{
	int x;
	boolean flag=false;
	public synchronized void push(int x){
		if(flag){
			try{
				wait();
			}catch(Exception e){
				e.printStackTrace();
			}
			this.x=x;
			System.out.println(x+"is pushed...");
			flag=true;
		}
	}
	public synchronized void pop(){
		if(!flag){
			try{
				wait();
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println(x+"is poped...");
		}
		flag=false;
		notify();
		
	}
}

class B3 implements Runnable{
	Stack st=null;
	B3(Stack st,String name){
		this.st=st;
		Thread t2=new Thread(this,name);
		t2.start();
	}
	public void run() {
		for(int i=0;i<=5;i++){
			st.pop();
		}
		
	}
	
}
class A3 implements Runnable{
	Stack st=null;
	A3(Stack st,String name){
		this.st=st;
		Thread t1=new Thread(this,name);
		t1.start();
	}
	public void run() {
		int a=2;
		for(int i=0;i<=5;i++){
			st.push(a++);
		}		
	}
	
}
class ThreadTest11 {
public static void main(String as[]){
Stack st=new Stack();
B3 obj2=new B3(st,"B3");
A3 obj1=new A3(st,"A3");
}
}
