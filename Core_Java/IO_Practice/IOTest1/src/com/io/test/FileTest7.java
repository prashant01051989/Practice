package com.io.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest7 {
public static void main (String as[]){
	File f1=new File("D:\\Prashant\\JAVA_LABS\\Core_Java\\IO_Practice\\a.text");
	FileWriter  fr=null;
	BufferedWriter bw=null;
	String content="This is the text content to write into the file.";
		try {

			if (f1.createNewFile()) {
				System.out.println("New file created");
			} else {
				System.out.println("Already file exist");
			}
			fr=new FileWriter(f1,true);
			bw=new BufferedWriter(fr);
			bw.write(content);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
}
}
