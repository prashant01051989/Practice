package com.test.anno;

import java.lang.reflect.Field;

public class AnnotationTest {
public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
	Employee emp=new Employee();
	Processor.processAnnotations(emp);
	System.out.println(emp);
}


}


 class Processor{
	public static void  processAnnotations(Object obj) throws IllegalArgumentException, IllegalAccessException{
		Class cls=obj.getClass();
		for(Field f:cls.getDeclaredFields()){
			Data d=	f.getAnnotation(Data.class);
			if(d!=null){
				f.setAccessible(true);
				f.set(obj, d.value());
			}
		}
	}
}