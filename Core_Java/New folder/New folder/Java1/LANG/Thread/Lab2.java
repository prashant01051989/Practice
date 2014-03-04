class HelloThread extends Thread{
public HelloThread(){}
public HelloThread(String s){
super(s);
}
 public void run(){
for(int i=10;i<=15;i++){
System.out.println(i+" BY "+Thread.currentThread().getName());
try{
Thread.sleep(500);
}catch(InterruptedException e){}
}
}
}

class Lab2{
public static void main(String as[])throws Exception{
System.out.println("Main Begin");

HelloThread h1=new HelloThread("A");
System.out.println(h1);
System.out.println(h1.getName());
System.out.println(h1.getPriority());
System.out.println(h1.getThreadGroup());
h1.setPriority(5);
h1.start();
//h1.stop();
h1.interrupt();
System.out.println(h1.isInterrupted());
System.out.println(h1.isAlive());
h1.suspend();
h1.resume();
h1.join(1000);

HelloThread h2=new HelloThread();
Thread      t=new  Thread(h2,"B");
System.out.println(t);
System.out.println(t.getName());
System.out.println(t.getPriority());
System.out.println(t.getThreadGroup());
t.setPriority(7);
t.setDaemon(true);
System.out.println(t.isDaemon());
t.start();
t.join();


Thread t1=new  Thread(new HelloThread(),"C");
System.out.println(t1);
System.out.println(t1.getName());
System.out.println(t1.getPriority());
System.out.println(t1.getThreadGroup());
t1.setPriority(9);
System.out.println(t1.getPriority());
t1.start();

System.out.println(Thread.activeCount());

for(int i=0;i<=5;i++){
System.out.println(i+" BY "+Thread.currentThread().getName());
try{
Thread.sleep(500);
}catch(InterruptedException e){}
}
System.out.println("Main End");
}
}