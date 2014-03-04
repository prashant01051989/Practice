package ss;

class Account{
int bal=970;	
public void withdraw(int amt){
	if(bal>=amt){
		System.out.println(Thread.currentThread().getName()+" is going to withdraw:- "+bal);
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
		bal-=amt;
		System.out.println(Thread.currentThread().getName()+" is completed withdraw:- "+bal);
	}
	else{
		System.out.println("No Funds for "+Thread.currentThread().getName());
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
	
}
	public void run() {
		
		for(int i=0;i<5;i++){
			acc.withdraw(225);
			if(acc.getBal()<0){
				System.out.println("Amount is overdrawn.....");
			}
		}
		
	}
	
}

public class ThreadTes6 {
public static void main(String as[]){
Account acc=new Account(); 
AccThread a=new AccThread(acc);
Thread t=new Thread(a,"A");
Thread t1=new Thread(a,"B");
t.start();
t1.start();
//System.out.println(a);
}
}
