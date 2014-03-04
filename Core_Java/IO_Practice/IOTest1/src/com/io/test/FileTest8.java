package com.io.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest8 {
	public static void main(String[] args) {
		File f=null;
		String finalFile="";
		String fileName="File.txt";
		String workingDir=System.getProperty("user.dir");
		String os=System.getProperty("os-name");
		
		String content="This is the content to write into the file";
		
		FileWriter fw=null;
		BufferedWriter bw=null;
		
		FileReader fr=null;
		BufferedReader br=null;
		
		try{
			if(os=="win"){
				finalFile=workingDir+File.separator+fileName;
			}else{
				finalFile=workingDir+File.separator+fileName;
			}
			
			f=new File(finalFile);
			if(f.createNewFile()){
				System.out.println("New file is created");
			}else{
				System.out.println("File is already created");
			}
			fw=new FileWriter(f,true);
			bw=new BufferedWriter(fw);
			bw.write(content);
			bw.close();
			fr=new FileReader(f);
			br=new BufferedReader(fr);
			if((content=br.readLine())!=null){
				System.out.println(content);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
				try {
					if(br!=null)
					br.close();
					if(fr!=null)
						fr.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		}
		
		if(f.delete()){
			System.out.println(f.getName()+" is deleted");
		}else{
			System.out.println(f.getName()+" not deleted");
		}
	}

}
