class ThreadTest1 {

public static void main(String as[])throws Exception{
System.out.println("main Begin");
System.out.println("");

System.out.println("Thread.activeCount(): "+Thread.activeCount());
System.out.println("Thread.currentThread(): "+Thread.currentThread());
System.out.println("Thread.currentThread().getId(): "+Thread.currentThread().getId());
System.out.println("Thread.currentThread().isDaemon(): "+Thread.currentThread().isDaemon());
//1.	Thread.currentThread().setDaemon(true);

Thread.currentThread().sleep(5000);
System.out.println("Thread.currentThread().isAlive(): "+Thread.currentThread().isAlive());
System.out.println("Thread.currentThread().getThreadGroup(): "+Thread.currentThread().getThreadGroup());
Thread.currentThread().dumpStack();
Thread.currentThread().join();
System.out.println("Thread.currentThread().getState(): "+Thread.currentThread().getState());
System.out.println("Thread.holdsLock(Thread.currentThread()): "+Thread.holdsLock(Thread.currentThread()));
StackTraceElement []ste=Thread.currentThread().getStackTrace();
System.out.println("ste.length: "+ste.length);
for(StackTraceElement s:ste){
System.out.println("s.getClassName(): "+s.getClassName());
System.out.println("s.getMethodName(): "+s.getMethodName());
}
System.out.println("");
System.out.println("Main End");
}
}

/*
1.	Exception in thread "main" java.lang.IllegalThreadStateException
*/
