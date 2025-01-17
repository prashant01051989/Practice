package com.test.builder;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class StackTest {
public static void main(String[] args) throws IOException {
	final PipedOutputStream pout=new PipedOutputStream();  
	final PipedInputStream pin=new PipedInputStream();  
	pout.connect(pin);
	Thread t1=new Thread(){
		public void run(){
			for(int i=65;i<=95;i++){
				try{
					pout.write(i);
					Thread.sleep(500);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	};
	Thread t2=new Thread(){
		public void run(){
			for(int i=65;i<=95;i++){
			try {
				System.out.println((char)pin.read());
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
			
		}
	};
	t1.start();
	t2.start();


}
}  