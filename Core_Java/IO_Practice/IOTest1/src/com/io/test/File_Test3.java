package com.io.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class File_Test3 {
	public static void main(String[] args) throws IOException {
		InputStreamReader osr=new InputStreamReader(System.in);
		int i;
		while((i=osr.read())!='\n'){
			System.out.print((char)i);
		}
		OutputStreamWriter osw=new OutputStreamWriter(System.out);
		osw.write("This is OutputStreamWriter Test");
		osw.flush();
	}

}
