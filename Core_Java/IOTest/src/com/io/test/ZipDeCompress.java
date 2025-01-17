package com.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipDeCompress {

	public static void main(String[] args) throws IOException {
		
		String input="D:\\LABS\\JAVA_LABS\\Core_Java\\IOTest\\ZipFile.zip";
		String output="D:\\LABS\\JAVA_LABS\\Core_Java\\IOTest\\ZipFile";
		FileInputStream fis=null;
		ZipInputStream zis=null;
		FileOutputStream fos=null;
		byte[] buffer = new byte[1024];
		
		try {	
			
			File dir=new File(output);
			if(!dir.exists()){
				dir.mkdir();
			}
					
			fis=new FileInputStream(input);
			zis=new ZipInputStream(fis);
			
			ZipEntry ze=zis.getNextEntry();
			
			while(ze!=null){
				File newFile=new File(output+File.separator+ze.getName());
				System.out.println("file unzip : "+ newFile.getAbsoluteFile());
				fos=new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				ze=zis.getNextEntry();
				fos.close();
			}
			zis.closeEntry();
			zis.close();
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			fis.close();
			
		}
	}

}
