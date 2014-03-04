package com.test.anno;

import java.lang.reflect.Field;

public class AnnoTest {

	
	public static void main(String[] args) {
		Student s=new Student();
		AnnoProcessor.processAnnotations(s);
		System.out.println(s.toString());

	}

}

class AnnoProcessor{
	public static void processAnnotations(Object obj){
		
		try{
			
			Class cls=obj.getClass();
			for(Field f:cls.getDeclaredFields()){
				Insert i=f.getAnnotation(Insert.class);
				if(i!=null){
					System.out.println(i.value());
					  f.setAccessible(true);
			            f.set(obj, i.value());
				}
			}
		}
		catch(Exception e){
			
		}
	}
}
