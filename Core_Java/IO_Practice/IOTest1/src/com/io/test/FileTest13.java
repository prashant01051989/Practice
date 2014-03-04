package com.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;



public class FileTest13 {
public static void main (String as[]){
	InputStream is=null;
	OutputStream os=null;
	File f1=null;
	File f2=null;
	String source="a.txt";
	String destin="b.txt";
	String path=System.getProperty("user.dir");
	String sourcePath=null;
	String destinPath=null;
	try {
		sourcePath=path+File.separator+source;
		destinPath=path+File.separator+destin;
		
		f1=new File(sourcePath);
		f2=new File(destinPath);
		f1.createNewFile();
		f2.createNewFile();
		is=new FileInputStream(f1);
		os=new FileOutputStream(f2);
		
		byte []bytes=new byte[1024];
		int length;
		while((length = is.read(bytes)) > 0){
			os.write(bytes, 0, length);
		}
		is.close();
		os.close();
		System.out.println(f1.length());
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
