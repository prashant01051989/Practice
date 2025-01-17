package com.io.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FilePermissionExample {

	
	public static void main(String[] args) {
		try {
			String fileName="B.txt";
			String workingDir=System.getProperty("user.dir");
			String yourOS=System.getProperty("os.name");
			String finalName=workingDir+"\\"+fileName;
			File file=new File(finalName);
			if(file.createNewFile()){
				System.out.println("New File has been created");
			}else{
				System.out.println("File already existed");
			}
			file.setExecutable(true);
			file.setReadable(true);
			file.setWritable(true);
			/*file.setExecutable(false);
			file.setReadable(false);
			file.setWritable(false);*/
			
			FileReader fr=new FileReader(finalName);
			BufferedReader br=new BufferedReader(fr);
			String content="";
			while((content=br.readLine())!=null){
				System.out.println(content);
			}
			
			br.close();
			fr.close();
			FileWriter fw=new FileWriter(finalName,true);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write("How r u??");
			bw.close();
			fw.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}

	}

}
