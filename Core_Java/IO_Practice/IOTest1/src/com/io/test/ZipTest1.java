package com.io.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipTest1 {
	public static void main(String[] args) throws FileNotFoundException {
		
		String zipFile="D:\\archive.zip";
		String srcDir="D:\\RecordCenter\\web\\RecordCenter\\src\\main\\java\\com\\ironmountain\\recordcenter\\controller";
		
    	try{
    		byte [] b=new byte[1024];
    		FileOutputStream fos=new FileOutputStream(zipFile);
    		ZipOutputStream zos=new ZipOutputStream(fos);
    		File f=new File(srcDir);
    		File [] lists=f.listFiles();
    		for(int i=0;i<lists.length-2;i++){
    			FileInputStream fis=new FileInputStream(lists[i]);
    			ZipEntry ze=new ZipEntry(lists[i].getName());
    			zos.putNextEntry(ze);
    			int len;
    			while((len=fis.read(b))>0){
    				zos.write(b);
    			}
    			zos.closeEntry();
        		fis.close();   
    		}
    		zos.close();
    		System.out.println("DONE");
    		
    		FileInputStream fis=new FileInputStream(zipFile);
    		ZipInputStream zis=new ZipInputStream(fis);
    		ZipEntry entry;
    		while((entry=zis.getNextEntry())!=null){
    			Scanner sc=new Scanner(zis);
    			while(sc.hasNextLine()){
    				System.out.println(sc.nextLine());
    			}
    		}
    		zis.closeEntry();
    		zis.close();
    		fis.close();
    		
    	}catch(IOException ex){
    	   ex.printStackTrace();
    	}
	
	}
}
