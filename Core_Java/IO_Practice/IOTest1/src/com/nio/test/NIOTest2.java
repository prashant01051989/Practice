package com.nio.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest2 {
public static void main(String[] args) throws Exception {
	
	FileInputStream fis=new FileInputStream("D:\\Name.txt");
	FileChannel from=fis.getChannel();
	
	
	FileOutputStream fos=new FileOutputStream("D:\\To.txt",true );
	FileChannel to=fos.getChannel();
	
	long position =0;
	long count=from.size();
	
	to.transferFrom(from, position, count);
	
	fis.close();
	fos.close();
	
	
}
}
