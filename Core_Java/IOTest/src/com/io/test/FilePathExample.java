package com.io.test;

import java.io.File;

public class FilePathExample {

	public static void main(String[] args) {
		try {
			String fileName="Anshu.doc";
			String finalFile="s";
			String workingDir=System.getProperty("user.dir");
			
			String your_OS=System.getProperty("os.name").toLowerCase();
			
			if(your_OS.indexOf("win")>=0){
				finalFile=workingDir+"\\"+fileName;
			}else if(your_OS.indexOf("nix")>=0){
				finalFile=workingDir+"/"+fileName;
			}
			
			
			System.out.println(finalFile);
			
			File file=new File(finalFile);
			if(file.createNewFile()){
				System.out.println("New File Created");
			}else{
				System.out.println("File already exist");
			}
			
			
		} catch (Exception e) {
			;
		}

	}

}
