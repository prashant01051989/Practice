package com.test.exception;

class Hello2 {
	static {
		System.out.println("Hello2 static block begin");
		//int x=10/0;
		System.out.println("Hello2 static block end");
	}

	public int m1(String i){
		try{
			int x=Integer.parseInt(i);
			int y=10/x;
			System.out.println(y);
			return y;
		}
		//finally{}		
		/*catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
		}catch(ArithmeticException ae){
			System.out.println("Catch Begin");
			System.out.println(ae);
			
			System.out.println("Catch end");
			//System.exit(0);
			return 100;		
			
		}*/finally{
			System.out.println("Finally Begin");
			System.out.println("Resource cleanup done here.");
			System.out.println("Finally End");
			return 200;			
		}
		/*System.out.println("I am not ok");
		return 99;*/
	}
}

public class ExceptionTest2 {

	public static void main(String[] args) {
		System.out.println("Main-Begin");
		Hello2 h1=new Hello2();
		int x=h1.m1(args[0]);
		System.out.println(x);
		System.out.println("Main-End");

	}
}
