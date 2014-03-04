package com.test.exception;

public class CustomException extends Exception{
	
	int i;
	public CustomException(){	}
	
	public CustomException(int i){
		this.i=i;
	}
	
	@Override
	public String getMessage(){
		return "Please enter valid Number";
	}
	
	@Override
	public String toString(){
		return getMessage();
	}

}
