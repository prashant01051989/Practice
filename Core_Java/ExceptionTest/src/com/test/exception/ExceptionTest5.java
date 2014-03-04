package com.test.exception;


class Hello5 {
	
	public void m1(int i)throws RuntimeException{
		System.out.println("Hello4 m1 starts..");
		try{
			throw new CustomException();
		}catch(CustomException ce){
			RuntimeException se=new RuntimeException("Number not valid exception");
			se.initCause(ce);
			throw se;
		}
	}
}

class Hai5 extends Hello5{
	@Override
	public void m1(int i){
		System.out.println("Hai5 m1 starts...");
		try{
			throw new Exception("Exception...........");
		}catch(Exception e){
			RuntimeException re=new RuntimeException();
			re.initCause(e);
			throw re;
		}
	}
	
}


public class ExceptionTest5 {
	
	public static void main(String[] args) {
		System.out.println("Main-Begin");
		/*
		try{
			Hello5 hello=new Hello5();
			hello.m1(5);
		}catch(RuntimeException e){
			System.out.println(e);
			CustomException ce=(CustomException) e.getCause();
			System.out.println(ce);
		}
		*/
		
		try{
			Hello5 hello=new Hai5();
			hello.m1(5);
			
		}catch(RuntimeException re){
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
			System.out.println(re);
			Exception e=(Exception) re.getCause();
			System.out.println(e);
			System.out.println(e.getMessage());
		}
		
		System.out.println("Main-End");
	}
}
