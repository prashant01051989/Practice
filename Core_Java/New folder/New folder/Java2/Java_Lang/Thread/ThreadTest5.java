package ss;

class HelloA extends Thread{
	HelloA(String name){
		super(name);
	}
	public void run() {
		for(int i=0;i<=10;i++){
			System.out.println(i+" by "+Thread.currentThread().getName());
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}		
	}
}



class ThreadTest5 {
public static void main(String as[]){
HelloA ha=new HelloA("A");
//1.	ha.setPriority(15);
ha.start();
HelloA hb=new HelloA("B");
ha.setPriority(3);
hb.start();
}
}

/*
 1. Exception in thread "main" java.lang.IllegalArgumentException
 * */
