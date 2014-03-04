package com.io.test;

import java.io.File;
import java.io.FilenameFilter;

public class FileTest10 {
	public static final String DIR="D:\\Ext";
	public static final String EXT=".js";
	public static void main(String as[]){
		new FileTest10().findExt(DIR,EXT);
	}
	public void findExt(String folder,String ext ){
		GenericExtFilter genric=new GenericExtFilter(ext);
		File f=new File(folder);
		String [] list=f.list(genric);
		if(list.length==0){
			return;
		}
		for (String file : list) {
			String temp = new StringBuffer(DIR).append(File.separator)
					.append(file).toString();
			System.out.println("file : " + temp);
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
