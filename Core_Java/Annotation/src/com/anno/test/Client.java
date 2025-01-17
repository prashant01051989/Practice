package com.anno.test;

import java.lang.reflect.Field;

public class Client {

	public static void main(String[] args) {
		Employee emp = new Employee();
		AnnoProcessor.processAnnotations(emp);
		System.out.println(emp.toString());

	}
}

class AnnoProcessor {
	public static void processAnnotations(Object obj) {
		try {
			Class cls = obj.getClass();
			for (Field f : cls.getDeclaredFields()) {
				Value value = f.getAnnotation(Value.class);
				System.out.println(value.toString());
				if (value != null) {
					
					f.setAccessible(true);
					f.set(obj, value.value());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}