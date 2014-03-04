class Account{
int bal=1600;
public  void withdraw(int amt){
if(bal>=amt){
System.out.println(Thread.currentThread().getName()+" is going to withdraw."+bal);
try{
Thread.sleep(1200);
}catch(Exception e){}
bal-=amt;
System.out.println(Thread.currentThread().getName()+"is completed withdraw...."+bal);
}else{
System.out.println("No Funds for"+Thread.currentThread().getName());
}
}
public int getBal(){
return bal;
}
}
class AccThread implements Runnable{
Account acc=null;
AccThread(Account acc){
this.acc=acc;
Thread t1=new Thread(this,"A");
Thread t2=new Thread(this,"B");
t1.start();
t2.start();
}
public void run(){
for(int i=0;i<6;i++){
acc.withdraw(400);
if(acc.getBal()<0){
System.out.println("Amount is Overdrawn..");
}
}
}
}

class Lab6{
public static void main(String as[])throws Exception{
Account acc=new Account();
new AccThread(acc);
}
}