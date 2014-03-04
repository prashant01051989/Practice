package com.io.test;

import java.io.File;

public class FileTest3 {
public static void main (String as[]){
	try{
		
	
	File f1=new File("D:\\Prashant\\JAVA_LABS\\Core_Java\\IO_Practice\\a.text");
	System.out.println("f1.canExecute()   "+f1.canExecute());
	System.out.println("f1.canRead()  "+f1.canRead());
	System.out.println("f1.canWrite() "+f1.canWrite());
	f1.setExecutable(true);
	f1.setReadable(false);
	f1.setWritable(false);
	if(f1.createNewFile())
	System.out.println("File is created");
	else
		System.out.println("File is already existed");
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
}
}
