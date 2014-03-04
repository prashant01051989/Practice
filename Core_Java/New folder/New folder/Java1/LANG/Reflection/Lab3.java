
import java.lang.reflect.*;

class Hello {
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
public void show(){
System.out.println(a);
System.out.println(b);
}
}

class Lab3{
public static void main(String as[]){
try{
Class cls=Class.forName("Hello");
Hello h1=(Hello)cls.newInstance();

Method m[]=cls.getDeclaredMethods();
for(int i=0;i<m.length;i++){
System.out.print(m[i].getDeclaringClass()+"  "+m[i].getName()+"   "+m[i].getModifiers()+"   "+m[i].getReturnType());
Class c[]=m[i].getParameterTypes();
for(int j=0;j<c.length;j++){
System.out.print("  "+c[j]);
}
System.out.println(" ");
}
System.out.println(" ");
for(int i=0;i<m.length;i++){
System.out.println(m[i].getName()+"   "+m[i].toString());
if(m[i].toString().equals("public void Hello.show()")){
 Object o[]=null;
 m[i].invoke(h1,o);
}
}
}catch(Exception e){
 e.printStackTrace();
 }
}
}