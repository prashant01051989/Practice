package com.io.test;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileTest4 {
public static void main (String as[]){
	File f1=new File("D:\\Prashant\\JAVA_LABS\\Core_Java\\IO_Practice\\a.text");
	FileInputStream fis=null;
	BufferedInputStream bis=null;
	DataInputStream dis=null;
	
	try{
		
		fis=new FileInputStream(f1);
		bis=new BufferedInputStream(fis);
		dis=new DataInputStream(bis);
		while(dis.available()!=0){
			System.out.println(dis.readLine());
		}
		
	
	

	}catch(Exception e){
		e.printStackTrace();
	}finally {
		try {
			fis.close();
			bis.close();
			dis.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	
	
	}}
}
