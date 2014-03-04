package com.io.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest6 {
public static void main (String as[]){
	File f1=new File("D:\\Prashant\\JAVA_LABS\\Core_Java\\IO_Practice\\a.text");
	FileOutputStream fos=null;
	String content="This is the text content	";
		try {

			if (f1.createNewFile()) {
				System.out.println("New file created");
			} else {
				System.out.println("Already file exist");
			}
			fos = new FileOutputStream(f1, true);
			byte[] b = content.getBytes();
			fos.write(b);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}

			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
	
}
}
