import java.lang.reflect.*;

final class Hello {
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

class Lab2{
public static void main(String as[]){
try{
Class cls=Class.forName("Hello");
Hello h=null;

Constructor con[]=cls.getDeclaredConstructors();
for(int i=0;i<con.length;i++){
System.out.print(con[i].getDeclaringClass()+"  "+con[i].getName()+"   ");
Class c[]=con[i].getParameterTypes();
for(int j=0;j<c.length;j++){
System.out.print("  "+c[j]);
}
System.out.println(" ");
}
System.out.println(" ");
for(int i=0;i<con.length;i++){
System.out.println(con[i].getName()+"   "+con[i].toString()+"  "+con[i].getModifiers());
if(con[i].toString().equals("public Hello(int)")){
Object o[]={new Integer(99)};
 h=(Hello)con[i].newInstance(o);
}
}
h.show();
}catch(Exception e){
 e.printStackTrace();
 }
}
}