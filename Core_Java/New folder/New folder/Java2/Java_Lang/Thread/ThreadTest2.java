class HelloThread extends Thread{
public HelloThread(){
}
public HelloThread(String tname){
super(new ThreadGroup("Anshu"),tname);
}
public void run(){

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


class ThreadTest2 {
public static void main(String as[]){
System.out.println("Main Begin");
System.out.println("");
System.out.println(Thread.MIN_PRIORITY);
System.out.println(Thread.MAX_PRIORITY);
System.out.println(Thread.NORM_PRIORITY);

HelloThread ht=new HelloThread("A");

System.out.println("ht.getThreadGroup(): "+ht.getThreadGroup());
HelloThread ht1=new HelloThread();
System.out.println(ht1);
System.out.println("ht1.activeCount(): "+ht1.activeCount());
System.out.println("ht1.getId(): "+ht1.getId());
System.out.println("ht1.isDaemon(): "+ht1.isDaemon());
System.out.println("ht1.isAlive(): "+ht1.isAlive());
System.out.println("ht1.getThreadGroup(): "+ht1.getThreadGroup());
System.out.println("ht1.getId(): "+ht1.getId());
System.out.println("ht1.getName(): "+ht1.getName());
System.out.println("ht1.getPriority(): "+ht1.getPriority());
ht1.start();
//1. ht1.start();
//Runtime rt=Runtime.getRuntime();
//rt.exit(0);
ht1.dumpStack();
System.out.println("ht1.isAlive(): "+ht1.isAlive());
}
}
/*
1.	Thread-0Exception in thread "main" java.lang.IllegalThreadStateException
*/