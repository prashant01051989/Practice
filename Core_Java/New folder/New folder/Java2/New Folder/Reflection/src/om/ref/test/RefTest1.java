package om.ref.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

interface i1{
	
}
interface i2{
	
}
class A{
	
}

final class Hello extends A implements i1,i2{
	int a=10;
	int b;
	Hello(){
		
	}
	Hello (int b){
		this.b=b;
	}
	void show(){
		System.out.println(a);
		System.out.println(b);
	}
}
public class RefTest1 {

	public static void main(String[] args) {
		try{
			/*
			Hello hh=new Hello(100);
			hh.show();
			*/
			Class cla=Class.forName("om.ref.test.Hello");
			Hello h=(Hello)cla.newInstance();
			System.out.println(cla);
			System.out.println(cla.getName());
			System.out.println(cla.getPackage());
			System.out.println(cla.getPackage().getName());
			System.out.println(cla.getSuperclass());
			System.out.println(cla.getSuperclass().getName());
			Class c[]=cla.getInterfaces();
			for(Class c1:c){
				System.out.println(c);
			}
			System.out.println(cla.getModifiers());
			System.out.println(cla.isSynthetic());
			System.out.println(cla.isPrimitive());
			System.out.println(cla.isMemberClass());
			System.out.println(cla.getSimpleName());
			Method []m=cla.getMethods();
			for(Method m1:m){
				System.out.println(m1);
			}
			Field []f=cla.getFields();
			System.out.println(f.length);
			for(Field f1:f){
				System.out.println(f1);
			}
			
			
			
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
