class Lab10{
public static void main(String as[]){
Myclass obj=new Myclass();
Thread t1=new Thread (obj,"T1");
Thread t2=new Thread (obj,"T2");
t1.setPriority(2);
t2.setPriority(Thread.NORM_PRIORITY);
t1.start();
t2.start();
}
}
class Myclass extends Thread {
int count=0;
public void run(){
for(int i=1;i<=10;i++){
count++;
try{
Thread.sleep(500);
}catch(InterruptedException e){}
System.out.println("Completed thread: "+Thread.currentThread().getName());
}
System.out.println(Thread.currentThread().getName()+" prority is: "+Thread.currentThread().getPriority());
}
}
