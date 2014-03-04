package com.test.controlStatement;

public class IfTest {
public static void main(String[] args) {
	boolean bol;
	if(bol=true)
		System.out.println("if(bol=true) true");
	
	
	bol=false;
	
	if(bol){
		System.out.println("if(bol)- true");
	}
	else{
		System.out.println("if(bol)- false");
	}
	
	int x=11;
	int y=3;
	if(x<y){
	//if(boolean bol1=true)	
		System.out.println("if(11<3)");
	}else if(x<12){
		System.out.println("else if(11<12)"); 
	}else if(x>16){
		System.out.println("else if(10>16)");
	}
}
}
