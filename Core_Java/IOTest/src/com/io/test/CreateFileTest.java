package com.io.test;

import java.io.File;
import java.io.IOException;

public class CreateFileTest {
	public static void main(String[] args) throws IOException {
		
		File file=new File("D:\\LABS\\JAVA_LABS\\Core_Java\\IOTest\\ATestFile.txt");
		if(file.createNewFile()){
			System.out.println("New File Created");
		}else{
			System.out.println("File already exist");
		}
		
	}

}
