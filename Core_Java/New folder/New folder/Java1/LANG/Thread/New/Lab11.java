class NameRunnable extends Thread {

public void run(){
System.out.println(this.getPriority());

for(int i=1;i<=5;i++){
System.out.println("Run by "+Thread.currentThread().getName());
try {
Thread.sleep(500);
}catch(InterruptedException ex){ }
}
}
}

class Name extends Thread {

public void run(){
System.out.println(this.getPriority());
for(int i=1;i<=5;i++){
System.out.println("Run by "+Thread.currentThread().getName());
try {
Thread.sleep(500);
}catch(InterruptedException ex){ }
}
}
}

public class Lab1 {

public static void main (String [] args){
System.out.println("Main Begin");
new Thread(new NameRunnable(),"A").start();
new Thread(new Name(),"B").start();
 
for(int i=1;i<=5;i++){
System.out.println("Run by "+Thread.currentThread().getName());
try {
Thread.sleep(500);
} catch (InterruptedException ex) { }
}

System.out.println("Main End");
}
}