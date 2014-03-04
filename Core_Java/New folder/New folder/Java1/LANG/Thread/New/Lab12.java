class HelloThread implements Runnable{
public HelloThread(String tname){
Thread t=new Thread(this,tname);
t.start();
System.out.println(Thread.currentThread().getName()); 
}
public void run(){
for(int i=1;i<=5;i++){
System.out.println(i+"  by "+Thread.currentThread().getName());
try{
Thread.sleep(500);
}catch(Exception e){}
}
}
}
class Lab5{
public static void main(String as[]){
System.out.println("Main Begin");
HelloThread h1=new HelloThread("A");
Thread t=Thread.currentThread();
System.out.println(t);
t.setName("Prashant");
for(int i=101;i<=105;i++){
System.out.println(i+" By "+ t.getName());
try{
Thread.sleep(500);
}catch(Exception e){}
}
System.out.println("Main End");
}
}