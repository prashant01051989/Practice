package com.io.test;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class DeleteFileWithExtention {

	public static void main(String[] args) {
		

	}

}


class DeleteFile{
	
	
	
	public String[] getFileList(){
		try{
			String workingDir=System.getProperty("user.dir");
			String fileName="ZipFile\\B.txt";
			String finalName="";
			finalName=workingDir+"\\"+fileName;
			File file=new File(finalName);
			String []files=file.list(filter) ;
			;
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

class GenericFilter implements FilenameFilter{
	

	@Override
	public boolean accept(File dir,String name) {
		return false;
	}
	
}