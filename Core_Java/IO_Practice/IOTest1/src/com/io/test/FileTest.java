package com.io.test;

import java.io.InputStream;
import java.io.OutputStream;


public class FileTest {
public static void main (String as[]){
	try{
				
		InputStream is=System.in;
		int i;
		
		while((i=is.read())!='\n'){
		System.out.println((char)i);
		//is.skip(4);
		}
		is.close();
		
		
		/*
		System.out.println(System.out.getClass().getSimpleName());
		OutputStream os=System.out;
		for(int i=65;i<=70;i++){
			os.write(i);
		}
		os.flush();
		//os.close();
*/		
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
}
}
