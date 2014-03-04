package om.ref.test2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

interface i{
	
}
class Hai{
	public int x=200;
	public void hai(){
		System.out.println("hai");
	}
}

final class Hello extends Hai implements i{
	public static final int a=10;
	public static int b=20;
	public int c=30;
	float d;
	public Hello(){
	}
	public Hello(int b){
		this.b=b;
	}
	public void show(){
		System.out.println("show");
		System.out.println(a);
		System.out.println(b);
	}
	public static void m1(String s1,String s2){
		System.out.println("m1");
		System.out.println(s1);
		System.out.println(s2);
	}
	 public final void m2(int x,int y){
		System.out.println("m2");
		System.out.println(x);
		System.out.println(y);
	}
}
public class RefTest {

	public static void main(String[] args) {
		try {
			Class cls=Class.forName("om.ref.test2.Hello");
			Hello h=(Hello) cls.newInstance();
			/*
			System.out.println("****************Class*******************");
			System.out.println(cls.getModifiers());
			System.out.println(cls.getSimpleName());
			System.out.println(cls.getSuperclass().getSimpleName());
			Class []cl=cls.getInterfaces();
			for(Class c2:cl){
				System.out.println(c2.getSimpleName());
			}
			System.out.println("****************Fields*******************");
			Field[] f= cls.getFields();
			for(Field f1:f){
					System.out.println(f1+"\t== " +f1.getName()+"\t== "+f1.getType()+"\t== "+f1.getModifiers());
					if(f1.getName().equals("c")){
						f1.setInt(h,1000);
						System.out.println(f1.getInt(h));
				}
			}
			Field[] f3=cls.getDeclaredFields();
			for(Field f1:f3){
				System.out.println(f1.getName()+"\t== "+f1.getType()+"\t== "+f1.getModifiers());
			}
			*/
			System.out.println("****************Methods*******************");
			Method []m=cls.getMethods();
			for(Method m1:m){
				System.out.println(m1+"\t=="+m1.getName()+"\t=="+m1.getModifiers()+"\t=="+m1.getReturnType());
				Class<?>[] o=m1.getParameterTypes();
				for(Class<?> o1:o){
					System.out.println(o.toString());
				}
				if(m1.getName().equals("m2")){
					Object o2[]={1,2};
					m1.invoke(h,o2);
				}
			}
		
		
		
		
		} catch (Exception e) {
					e.printStackTrace();
		}
		

	}

}
