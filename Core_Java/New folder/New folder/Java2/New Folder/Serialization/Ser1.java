import java.io.*;
class Cat implements Serializable{
int a=10;
final int b=20;
static int  c=30;
transient int d=40;
}

public class Ser1{
public static void main(String as[]){
Cat c=new Cat();
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
System.out.println(c1.a);
System.out.println(c1.b);
System.out.println(c1.c);
System.out.println(c1.d);
}
}