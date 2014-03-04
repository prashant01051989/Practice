package com.io.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;


public class FileTest12 {
public static void main (String as[]){
	BufferedReader br=null;
	try{
		Process pc=Runtime.getRuntime().exec("cmd /c dir D:\\Name.txt /tc");
		br=new BufferedReader(new InputStreamReader(pc.getInputStream()));
		String st=null;
		while((st=br.readLine())!=null){
			System.out.println(st);
		}
		File f=new File("D:\\Name.txt");
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		System.out.println(sdf.format(f.lastModified()));
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

}
