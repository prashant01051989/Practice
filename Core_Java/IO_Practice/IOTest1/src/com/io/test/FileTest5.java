package com.io.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileTest5 {
public static void main (String as[]){
	File f1=new File("D:\\Prashant\\JAVA_LABS\\Core_Java\\IO_Practice\\a.text");
	
	FileReader fr=null;
	BufferedReader br=null;
	try{
		if(f1.createNewFile()){
			System.out.println("New file created");
		}else{
			System.out.println("Already file exist");
		}
		String content="";
		fr=new FileReader(f1);
		br=new BufferedReader(fr);		
		while((content=br.readLine()) != null){
			System.out.println(content);
		}
	
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		try {
			fr.close();
			br.close();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	
	
	}}
}
