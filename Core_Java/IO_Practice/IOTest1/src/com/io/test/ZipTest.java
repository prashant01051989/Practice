package com.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipTest {
	public static void main(String[] args) throws FileNotFoundException {
		
		String zipFile="D:\\archive.zip";
		String srcDir="D:\\RecordCenter\\web\\RecordCenter\\src\\main\\java\\com\\ironmountain\\recordcenter\\controller";
		
    	try{
    		byte[] buffer = new byte[1024];
    		FileOutputStream fos = new FileOutputStream(zipFile);
    		ZipOutputStream zos = new ZipOutputStream(fos);
    		/*FileInputStream fis1=new FileInputStream(zipFile);
    		ZipInputStream zis=new ZipInputStream(fis1);*/
    		File dir=new File(srcDir);
    		File file[]=dir.listFiles();
    		for(int i=0;i<file.length-2;i++){
    			FileInputStream fis=new FileInputStream(file[i]);
    			ZipEntry ze= new ZipEntry(file[i].getName());
    			zos.putNextEntry(ze);
    			int len;
        		while ((len = fis.read(buffer)) > 0) {
        			zos.write(buffer, 0, len);
        		}
        		zos.closeEntry();
        		fis.close();    		
    		}
    		   		   		
    		zos.close();
 
    		System.out.println("Done");
 
    	}catch(IOException ex){
    	   ex.printStackTrace();
    	}
	
	}
}
