package com.test.exception;

import java.sql.SQLException;
import java.sql.SQLNonTransientException;

class Hello4 {
	/*case 1
	  public void m1(int i)throws Exception{
		System.out.println("Hello4 m1 starts..");
		if(i==1){
			throw new ArithmeticException();
		}else{
			throw new IndexOutOfBoundsException();
		}		
	}*/
	
	public void m1(int i)throws RuntimeException{
		System.out.println("Hello4 m1 starts..");
		if(i==1){
			throw new ArithmeticException();
		}else{
			throw new IndexOutOfBoundsException();
		}		
	}
}

class Hai4 extends Hello4{
	/*OK
	 public void m1(int i)throws RuntimeException{
			System.out.println("Hai4 m1 starts...");
	}
	*/
	/*OK
	public void m1(int i)throws ArithmeticException{
		System.out.println("Hai4 m1 starts...");
	}
	*/
	/* Not OK
	public void m1(int i)throws Exception{
		System.out.println("Hai4 m1 starts...");
	}
	*/
	/*OK
	public void m1(int i)throws SQLException{
		System.out.println("Hai4 m1 starts...");
	}
	
	*/
}

public class ExceptionTest4 {

	public static void main(String[] args) {
		System.out.println("Main-Begin");
		Hello4 h1=new Hello4();
		/*case 1
		  try {
			h1.m1(0);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		//h1.m1(0);
		Hello4 h2=new Hai4();
		h2.m1(10);
		System.out.println("Main-End");
	}
}
