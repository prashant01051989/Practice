package com.io.test;

import java.io.FileWriter;
import java.io.IOException;

public class File_Test4 {
	public static void main(String[] args) throws IOException {
		FileWriter fos=new FileWriter("D:\\Name.txt");
		fos.write("This is FileTest4");
		fos.close();
		
	
	}	

}
