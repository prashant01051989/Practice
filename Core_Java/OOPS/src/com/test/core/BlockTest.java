package com.test.core;

 class BlockA{
	 int i=10;
	 static int b=20;
	 static{
		 System.out.println("Static block of BlockA ");
		 int b=200;
		 System.out.println(b);
		 System.out.println(BlockA.b);
		 //static int c=20;
		 final int c=20;
	 }
	 
	 static{
		 System.out.println("BlockA - 2nd static block");
		// static{ }
	 }
	 {
		 System.out.println("BlockA - 2nd instance block");		 
	 }
	 {
		 System.out.println("Instance block of BlockA");
		 int i=1000;
		 System.out.println(i);
		 System.out.println(b);
		 System.out.println(this.i);	
		 {
			 System.out.println("inner instance block of BlockTest");
			 
		 }
	 }
}


public class BlockTest {

	public static void main(String[] args) {
		BlockA b1=null;
		//System.out.println(b1.b);
		BlockA b2=new BlockA();
		
	}
	
}
