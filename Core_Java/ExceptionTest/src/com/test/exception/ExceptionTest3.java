package com.test.exception;

public class ExceptionTest3 {

	public static void main(String[] args) {
		System.out.println("Main-Begin");
		try{
			System.out.println("try A start");
			System.out.println(10/0);
			try{
				System.out.println("try Inside try A start");
				//System.out.println(10/0);
				System.out.println("try Inside try A end");
			}catch(Exception e){
				System.out.println("catch Inside try A start");
				System.out.println("catch Inside try A end");
			}finally{
				System.out.println("finally Inside try A start");
				System.out.println("finally Inside try A end");
			}
			System.out.println("try A end");
			}catch(Exception e){
				System.out.println("catch A start");
				try{
					System.out.println("try Inside catch A start");
					System.out.println(10/0);
					System.out.println("try Inside catch A end");
				}catch(Exception ce){
					System.out.println("catch Inside catch A start");
					System.out.println("catchInside catch A end");
				}finally{
					System.out.println("finally Inside catch A start");
					System.out.println("finally Inside catch A end");
				}
				System.out.println("catch A end");
			}finally{
				System.out.println("Finally A start");
				try{
					System.out.println("try Inside finally A start");
					System.out.println(10/0);
					System.out.println("try Inside finally A end");
				}catch(Exception ce){
					System.out.println("catch Inside finally A start");
					System.out.println("catch Inside finally A end");
				}finally{
					System.out.println("finally Inside finally A start");
					System.out.println("fianlly Inside finally A end");
				}
				System.out.println("Finally A end");
			}
		System.out.println("Main-End");

	}
}
