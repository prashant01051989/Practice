package com.nio.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest1 {
public static void main(String[] args) throws Exception {
	
	FileOutputStream fos=new FileOutputStream("D:\\Name.txt",true );
	FileChannel fc1=fos.getChannel();
	ByteBuffer bb1= ByteBuffer.allocate(1024);
	
	String msg="This is String message for nios";
	byte[] bytes= msg.getBytes();
	for(int i=0;i<bytes.length;i++){
		bb1.put(bytes[i]);
	}
	bb1.flip();
	fc1.write(bb1);
	
	FileInputStream fis=new FileInputStream("D:\\Name.txt");
	FileChannel fc=fis.getChannel();
	ByteBuffer bb=ByteBuffer.allocate(1024);
	System.out.println(bb.capacity());
	System.out.println(bb.hasArray());
	System.out.println(bb.hasRemaining());
	System.out.println(bb.remaining());
	int limit=fc.read(bb);
	while(limit != -1){
		bb.flip();
		while(bb.hasRemaining()){
			System.out.print((char)bb.get());
		}
		bb.clear();
		limit=fc.read(bb);
	}
	fc.close();
	fos.close();
	
	
}
}
