package com.io.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class File_Test2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("D:\\Name.txt");
		BufferedInputStream bis=new BufferedInputStream(fis);
		FileOutputStream fos=new FileOutputStream("D:\\Name.txt");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		PushbackInputStream pis=new PushbackInputStream(bis);
		DataOutputStream dos=new DataOutputStream(bos);
		DataInputStream dis=new DataInputStream(bis);
		//System.out.println((char)pis.read());
		int b=pis.read();
		//System.out.println((char)b);
		if(b==((int)'?')){
			System.out.println("Right");
		}else{
			System.out.println("Wrong");
			pis.unread(b);
		}
		
		/*for(int i=1;i<=10;i++)
		dos.writeUTF("This is  "+i+" number.");
		dos.close();
	
		while(dis.available()!=0){
			System.out.println(dis.readUTF());
		}*/
		fis.close();
		dis.close();
		pis.close();
	}

}
