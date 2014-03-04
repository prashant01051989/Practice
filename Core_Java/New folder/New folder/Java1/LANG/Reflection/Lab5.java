import java.lang.reflect.*;

 class Hello{
public int a=10;
public int b;
public Hello (){}
public Hello(int b){
this.b=b;
} 
private Hello(int b,int c){
this.b=b;
} 
public class C{}
public void show(int a){
System.out.println(a);
System.out.println(b);
}
}

class Lab5{
public static void main(String as[]){
try{
Class cls=Class.forName("Hello");

Field f[]=cls.getDeclaredFields();
for(int i=0;i<f.length;i++){
System.out.println(f[i].getDeclaringClass()+"    "+f[i].getName()+"   "+f[i].toString()
+"   "+f[i].getModifiers()+"   "+f[i].getType());
}
for(int i=0;i<f.length;i++){
System.out.println(f[i].getInt("220"));
}

}catch(Exception e){
 e.printStackTrace();
 }
}
}