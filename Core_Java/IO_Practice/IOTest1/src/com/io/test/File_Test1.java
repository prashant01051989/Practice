package com.io.test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class File_Test1 {
	public static void main(String[] args) throws IOException {
		PrintWriter pw=new PrintWriter(new FileWriter("\\Name.txt"),true);
		pw.println("This is Print Writter Test");
		pw.close();
	}

}
