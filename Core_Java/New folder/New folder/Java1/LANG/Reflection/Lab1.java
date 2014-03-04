package com.jlc.p1;
import java.lang.reflect.*;

interface i1{}
interface i2{}

class B{}
class A extends B{
}

final class Hello extends A implements i1,i2{
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

class Lab1{
public static void main(String as[]){
try{
Class cls=Class.forName("com.jlc.p1.Hello");
Object obj=cls.newInstance();
Hello h=(Hello)obj;
System.out.println(cls.getDeclaringClass());
System.out.println(cls);
System.out.println(cls.getName());
System.out.println(cls.toString());
System.out.println(cls.isInterface());
//System.out.println(cls.isArray());
//System.out.println(cls.isPrimitive());
System.out.println(cls.getClassLoader());
System.out.println(cls.getSuperclass());
System.out.println(cls.getGenericSuperclass());
System.out.println(cls.getPackage());
System.out.println(cls.getModifiers());
Class c1[]=cls.getInterfaces();
for(int i=0;i<c1.length;i++){
System.out.println(c1[i]+" ");
}

Class c2[]=cls.getClasses();
System.out.println(c2.length);
for(int i=0;i<c2.length;i++){
System.out.println(c2[i]+" ");
}
c2=cls.getDeclaredClasses();
System.out.println(c2.length);
for(int i=0;i<c2.length;i++){
System.out.println(c2[i]+" ");
}

Field f1[]=cls.getFields();
System.out.println(f1.length);
for(int i=0;i<f1.length;i++){
System.out.println(f1[i]+" ");
}
Field f=cls.getField("a");
System.out.println(f);

f1=cls.getDeclaredFields();
System.out.println(f1.length);
for(int i=0;i<f1.length;i++){
System.out.println(f1[i]+" ");
}

Method m[]=cls.getMethods();
System.out.println(m.length);
for(int i=0;i<m.length;i++){
System.out.println(m[i]+" ");
}

m=cls.getDeclaredMethods();
System.out.println(m.length);
for(int i=0;i<m.length;i++){
System.out.println(m[i]+" ");
}

Constructor con[]=cls.getConstructors();
System.out.println(con.length);
for(int i=0;i<con.length;i++){
System.out.println(con[i]+" ");
}
con=cls.getDeclaredConstructors();
System.out.println(con.length);
for(int i=0;i<con.length;i++){
System.out.println(con[i]+" ");
}
}catch(Exception e){
 e.printStackTrace();
 }
}
}