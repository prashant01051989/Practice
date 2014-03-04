package ss;

class Hai extends Thread{

	public void run() {
		for(int i=0;i<=5;i++){
			System.out.println(i+" by "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
					e.printStackTrace();
		}
		}		
	}
}



class ThreadTest7 {
public static void main(String as[]){

Hai h=new Hai();
Hai h1=new Hai();
h.start();
h1.start();
}
}
