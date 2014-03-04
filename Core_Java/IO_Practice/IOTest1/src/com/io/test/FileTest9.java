package com.io.test;

import java.io.File;
import java.io.FilenameFilter;

public class FileTest9 {
	public static final String EXT=".js";
	public static final String DIR="D:\\Ext";
public static void main(String[] args) {
	new FileTest9().deleteFile(DIR,EXT);
}

public void deleteFile(String folder,String ext){
	GenericExtFilter genric=new GenericExtFilter(ext);
	File f=new File(folder);
	String [] fileList=f.list(genric);
	if(fileList.length==0)
		return;
	for(String file:fileList){
		String temp=new StringBuffer(folder).append(File.separator).append(file).toString();
		File f2=new File(temp);
		if(f2.delete()){
			System.out.println(f2.getName() +" is deleter");
		}
		
	}
}
public class GenericExtFilter implements FilenameFilter{
	private String ext;
	public GenericExtFilter(String ext){
		this.ext=ext;
	}
	@Override
	public boolean accept(File dir,String name) {
		System.out.println(name+" *****************");
			return (name.endsWith(ext));
	}
	
}
}
