package com.io.test;

import java.io.File;

public class DeleteExample {


	public static void main(String[] args) {
		try {
			String workingDir=System.getProperty("user.dir");
			String fileName="B.txt";
			String finalName="";
			finalName=workingDir+"\\"+fileName;
			
			File file=new File(finalName);
			
			if(file.delete())
			System.out.println("File deleted");
			else{
				System.out.println("File not deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
