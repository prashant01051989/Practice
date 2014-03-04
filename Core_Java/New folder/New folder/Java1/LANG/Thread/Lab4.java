class HelloThread extends Thread{
public HelloThread(String tname){
super(tname);
start();
}
synchronized public void run(){
for(int i=10;i<=15;i++){
System.out.println(i+" BY "+Thread.currentThread().getName());
try{
Thread.sleep(500);
}catch(InterruptedException e){}
}
}

}


class Lab4{
public static void main(String as[])throws Exception{
System.out.println("Main Begin");

HelloThread h2=new HelloThread("B");
Thread      t=new  Thread(h2,"A");
t.start();
//h2.start();

System.out.println("Main End");
}
}