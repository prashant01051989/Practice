package com.om.ser;

import java.io.*;

import com.om.ser1.Cat;
import com.om.ser2.Collar;



public class Ser1{
public static void main(String as[]){
	Collar col1=new Collar(10);
	Cat c=new Cat(col1,4);
Cat c1=null;
try{
FileOutputStream fos=new FileOutputStream("test.txt");
ObjectOutputStream os=new ObjectOutputStream(fos);
os.writeObject(c);
os.close();
}catch(Exception e){
e.printStackTrace();
}
try{
FileInputStream fis=new FileInputStream("test.txt");
ObjectInputStream ois=new ObjectInputStream(fis);
c1=(Cat)ois.readObject();

ois.close();
}catch(Exception e){
e.printStackTrace();
}
System.out.println(c1.getDog());
System.out.println(c1.getCol());

}
}