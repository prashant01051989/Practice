package com.io.test;

import java.io.File;

public class FileTest2 {
public static void main (String as[]){
	try{
		System.out.println(File.pathSeparatorChar);
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		System.out.println(File.separatorChar);
		
	String filename="anshu.txt";
	String finalfile="";
	String workingdir=System.getProperty("user.dir");
	/*String osname=System.getProperty("os.name").toLowerCase();
	if(osname.indexOf("win")>=0){
		finalfile=workingdir+"\\"+filename;
	}else{
		finalfile=workingdir+"/"+filename;
	}*/
	finalfile=workingdir+File.separator+filename;
	System.out.println("Final filepath  "+finalfile);
	File f1=new File(finalfile);
	if (f1.createNewFile()){
	     System.out.println("Done");
	  }else{
	     System.out.println("File already exists!");
	  }

	}catch(Exception e){
		e.printStackTrace();
	}
	
	
}
}
