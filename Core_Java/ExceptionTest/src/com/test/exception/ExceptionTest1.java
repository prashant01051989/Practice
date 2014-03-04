package com.test.exception;

public class ExceptionTest1 {

	public static void main(String[] args) {
		System.out.println("Main-Begin");
		/*
		Integer a=Integer.parseInt(args[0]);
		int x=10/a;
		System.out.println(x);
		*/
		
		/* try without catch
		try{
			Integer a=Integer.parseInt(args[0]);
			int x=10/a;
			System.out.println(x);
		}*/
		
		/*try{
			Integer a=Integer.parseInt(args[0]);
			int x=10/a;
			System.out.println(x);
			
			}catch(Exception e){
				System.out.println(e);
				System.out.println(e.getLocalizedMessage());
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
				System.out.println(e.getClass());
				e.getStackTrace();
				e.printStackTrace();
				System.out.println("Not Ok");				
			}*/
		
		
		/* Statement between try and catch
		try{			
		}
		//System.out.print(" ");
		catch(Exception e){}
		*/
		
		/* Exception class should be subclass to superclass
		try{
			Integer a=Integer.parseInt(args[0]);
			int x=10/a;
			System.out.println(x);
			}catch(Exception e){
				System.out.println(e);
			}
			//catch(ArrayIndexOutOfBoundsException e){}
		*/
		
		try{
			Integer a=Integer.parseInt(args[0]);
			int x=10/a;
			System.out.println(x);
			
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println(e);
				System.out.println("ArrayIndexOutOfBoundsException");				
			}catch(NumberFormatException nfe){
				System.out.println(nfe);
				System.out.println("ArrayIndexOutOfBoundsException");
			}catch(ArithmeticException ae){
				System.out.println(ae);
				System.out.println("**ArithmeticException");
			}catch(Exception e){
				System.out.println(e);
				System.out.println("**Exception");
			}
		
		
		
		
		System.out.println("Main-End");
		
		
	}
}
