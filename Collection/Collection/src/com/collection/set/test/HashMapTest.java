package com.collection.set.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MA{
	int id;
	String name;
	MA(int id,String name){
		this.id=id;
		this.name=name;
	}
	
	public boolean equals(Object o){
		System.out.println("MA Equals method >>>>>>>>>>>>>>>>>>");
		if(o instanceof MA){
			MA ma=(MA)o;
			if(ma.name.equals(this.name)){
				return true;
			}
		}
		return false;
	}
	public int hashCode(){
		System.out.println("MA hashcode method ****************");
		return id;
	}
}


public class HashMapTest {

	public static void main(String[] args) {
		MA m=new MA(1,"Ram");
		MA m1=new MA(2,"Ram");
		MA m2=new MA(1,"Ram");
		HashMap<MA,String>h1=new HashMap<MA,String>();
		System.out.println(h1.size());
		System.out.println(h1.isEmpty());
		h1.put(m,"Ram");
		h1.put(m2,"Anshu");
		h1.put(null,"Sita");
		h1.put(m1,"Ram");
		h1.put(null,null);
		System.out.println(h1.size());
		System.out.println(h1.containsKey(m));
		System.out.println(h1.containsKey(null));
		System.out.println(h1.containsValue("Ram"));
		Set <Map.Entry<MA,String>> set=h1.entrySet();
		Iterator<Map.Entry<MA,String>> it=set.iterator();
		while (it.hasNext()) {
			Map.Entry<com.collection.set.test.MA, java.lang.String> entry = (Map.Entry<com.collection.set.test.MA, java.lang.String>) it
					.next();
			System.out.println("Key: "+entry.getKey()+"     Value: "+entry.getValue());
			
		}
		System.out.println(h1.get(m1));
		Set<MA> set2=h1.keySet();
		System.out.println(set2);
		String s=h1.remove(m1);
		System.out.println(s);
		System.out.println(h1);
		h1.putAll(h1);
		System.out.println(h1);
		Collection<String> li= h1.values();
		Iterator i2=li.iterator();
		while (i2.hasNext()) {
			String object = (String) i2.next();
			if(object!=null)
			System.out.println(object);
			
		}
		

		
	}

}
