package com.test.operator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class A{
	int id;
	String name;
	A(int id,String name){
		this.id=id;
		this.name=name;
	}
	public boolean equals(Object o){
		System.out.println("equals method of A");
		if(o instanceof A){
			A a=(A)o;
			if(a.name.equals(this.name)){
				return true;
			}
		}
		return false;
	}
public int hashCode(){
	System.out.println("hashCode method of A");
	return this.id;
}
	
}

public class SetTest {


	public static void main(String[] args) {
		Set<A> h1=new HashSet<A>();
		A a1=new A(1,"A Obj");
		
		h1.add(a1);
		a1.id=2;
		h1.add(a1);
		
		
		Iterator<A> it=h1.iterator();
		while(it.hasNext()){
			A a=(A)it.next();
			if(a!=null)
			System.out.println(a.name);
		}
		
	
	}
	
	
	

}