package ss;

class ThreadA implements Runnable{

	public void run() {
		for(int i=0;i<=10;i++){
			System.out.println(i+" by "+Thread.currentThread().getName());
		}		
	}
	public void run(int a) {
		for(int i=a;i<=10;i++){
			System.out.println(i+" by "+Thread.currentThread().getName());
		}		
	}
	
}



class ThreadTest3 {
public static void main(String as[]){
System.out.println("Main Begin");
System.out.println("");
ThreadA ta1=new ThreadA();
//ta1.run();
//ta1.run(1);
Thread t1=new Thread(new ThreadGroup("PRA"),ta1,"Anshu");
t1.start();
System.out.println(t1);
System.out.println("t1.activeCount(): "+t1.activeCount());
System.out.println("t1.getId(): "+t1.getId());
System.out.println("t1.isDaemon(): "+t1.isDaemon());
System.out.println("t1.isAlive(): "+t1.isAlive());
System.out.println("t1.getThreadGroup(): "+t1.getThreadGroup());
System.out.println("t1.getId(): "+t1.getId());
System.out.println("t1.getName(): "+t1.getName());
System.out.println("t1.getPriority(): "+t1.getPriority());


}
}
/*
1.	
*/
