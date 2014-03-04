class Stack{
int x;
void push(int a){
x=a;
}
int pop(){
return x;
}
}

class HelloThread implements Runnable{
Stack st=null;
public HelloThread(Stack st,String tname){
Thread t=new Thread(this,tname);
this.st=st;
t.start();
}
public void run(){
for(int i=1;i<=5;i++){
st.push(i);
System.out.println(i+" is pushed by HelloThread ");
try{
Thread.sleep(500);
}catch(Exception e){}
}
}
}
class HaiThread extends Thread{
Stack st=null;
public HaiThread(Stack st,String tname){
super(tname);
this.st=st;
start();
}
public void run(){
for(int i=101;i<=106;i++){
int x=st.pop();
System.out.println(x+" is poped by HaiThread ");
try{
Thread.sleep(500);
}catch(Exception e){}
}
}
}
class Lab12{
public static void main(String as[])throws Exception{
System.out.println("Main Begin");
Stack st=new Stack();
HelloThread h1=new HelloThread(st,"A");
HaiThread h2=new HaiThread(st,"B");
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